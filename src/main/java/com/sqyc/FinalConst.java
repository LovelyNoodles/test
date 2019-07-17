package com.sqyc;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FinalConst {
    private final Map map;

    private FinalConst() {
        this.map = new HashMap<>();
        this.map.put("name", "yyp");
    }

    public FinalConst(Map map) {
        super();
        this.map = map;
    }

    public static void main(String[] args) {
        FinalConst finalConst = new FinalConst();
        System.out.println(finalConst);

//		 finalConst.map = new HashMap<>();
    }

}
