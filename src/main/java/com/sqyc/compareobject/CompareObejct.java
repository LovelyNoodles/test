package com.sqyc.compareobject;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.sqyc.compareobject.FieldNote.Pattern;

public class CompareObejct<T> {

	private static BiConsumer<CompareObjectAttr, List<Object>> defaultConsumer = null;

	static {
		defaultConsumer = new BiConsumer<CompareObjectAttr, List<Object>>() {
			@Override
			public void accept(CompareObjectAttr attr, List<Object> results) {
				String old = attr.getOld();
				String fresh = attr.getFresh();
				String note = attr.getNote();

				if (StringUtils.isBlank(old)) {
					results.add(note + " 设置为：" + fresh);
				} else if (StringUtils.isBlank(fresh)) {
					results.add("将原有的  " + note + "( " + old + " )" + " 清空");
				} else {
					results.add("将  " + note + " 由  " + old + " 更新为   " + fresh);
				}
			}
		};
	}

	public static List<Object> contrastObj(Object old, Object fresh,
			BiConsumer<CompareObjectAttr, List<Object>> consumer) {

		if (old == fresh) {
			return new ArrayList<>();
		}

		Class<? extends Object> clazz = old.getClass();
		if (!clazz.equals(fresh.getClass())) {
			throw new RuntimeException("对比的对象必须为同一种类");
		}

		try {
			Field[] fields = clazz.getDeclaredFields();
			List<Object> results = new ArrayList<>();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				FieldNote fieldNote = field.getAnnotation(FieldNote.class);
				if (fieldNote == null) {
					continue;
				}
				String noteValue = fieldNote.value();
				Pattern pattern = fieldNote.pattern();

				PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
				Method getter = pd.getReadMethod();
				Object o1 = getter.invoke(old);
				Object o2 = getter.invoke(fresh);
				if (o1 == o2) {
					continue;
				}
				if ((o1 != null && o1.equals(o2)) || (o2 != null && o2.equals(o1))) {
					continue;
				}

				Function<Object, String> defaultFunction = new Function<Object, String>() {
					@Override
					public String apply(Object obj) {
						if (obj instanceof Date) {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.value());
							return formatter
									.format(LocalDateTime.ofInstant(((Date) obj).toInstant(), ZoneId.systemDefault()));
						}
						return obj.toString();
					}
				};

				String value1 = (String) Optional.ofNullable(o1).map(defaultFunction).orElseGet(String::new);
				String value2 = (String) Optional.ofNullable(o2).map(defaultFunction).orElseGet(String::new);

				if (consumer == null) {
					consumer = defaultConsumer;
				}
				CompareObjectAttr attr = new CompareObjectAttr();
				attr.setOld(value1);
				attr.setFresh(value2);
				attr.setNote(noteValue);
				consumer.accept(attr, results);
			}
			if (results.isEmpty()) {
				return new ArrayList<>();
			}
			return results;
		} catch (Exception e) {
			throw new RuntimeException("对比出错：" + e.getMessage());
		}
	}

	static class CompareObjectAttr {
		private String old;
		private String fresh;
		private String note;

		public String getOld() {
			return old;
		}

		public void setOld(String old) {
			this.old = old;
		}

		public String getFresh() {
			return fresh;
		}

		public void setFresh(String fresh) {
			this.fresh = fresh;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

	}

	static class Person {
		@FieldNote("姓名")
		private String name;

		@FieldNote("年龄")
		private Integer age;

		@FieldNote("出生日期")
		private Date birthday;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((age == null) ? 0 : age.hashCode());
			result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age == null) {
				if (other.age != null)
					return false;
			} else if (!age.equals(other.age))
				return false;
			if (birthday == null) {
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

}
