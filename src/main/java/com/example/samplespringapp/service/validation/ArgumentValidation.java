package com.example.samplespringapp.service.validation;

public class ArgumentValidation {

    public ArgumentValidation() {
    }

    public static boolean minLength(String arg, Integer minLength){
        return arg.length() <= minLength;
    };

    public static boolean minValue(Integer arg, Integer minVal){
        return arg < minVal;
    };

    public static boolean maxLength(String arg, Integer maxVal){
        return arg.length() >= maxVal;
    }

    public static boolean maxValue(Integer arg, Integer maxVal){
        return arg >= maxVal;
    }

    public static boolean isEmail(String arg) {
        return arg.contains("@");
    };

    public static boolean isEmpty(String arg) {
        return arg.isEmpty();
    };

    public static boolean isNull(String arg) {
        return arg == null;
    };

    public static boolean isNull(Integer arg){
        return arg == null;
    };

}
