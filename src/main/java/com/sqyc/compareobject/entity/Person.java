package com.sqyc.compareobject.entity;

import java.util.Date;

import com.sqyc.compareobject.FieldNote;

import lombok.Data;

@Data
public class Person {

	@FieldNote("姓名")
	private String name;

	@FieldNote("年龄")
	private Integer age;

	@FieldNote("出生日期")
	private Date birthday;

}
