package com.etiya.customerservice.helper;

public class Formatter {
    public static String formatString(String str){
        return "%"+ str + "%";
    };

    public static String formatNumber(Long number){
        return "%"+ number + "%";
    }
}
