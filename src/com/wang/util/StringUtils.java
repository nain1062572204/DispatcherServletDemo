package com.wang.util;

/**
 * @author Rose
 * @create 2019/1/27
 * @since 1.0.0
 */
public class StringUtils {
    private static StringUtils instance = new StringUtils();


    public String initcap(String str) {//首字母大写
        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }


    public static StringUtils getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        System.out.println("get"+StringUtils.getInstance().initcap("stuClass"));
    }
}