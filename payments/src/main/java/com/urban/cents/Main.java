package com.urban.cents;

import common.com.urban.cent.UrbanStringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UrbanStringUtils stringUtils = new UrbanStringUtils();
        String reversed  = stringUtils.reverse("Hello world!");
    }
}
