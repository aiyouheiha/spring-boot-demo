package com.heiha.example.init;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-15 02:42
 * <b>Author:</b> heiha
 */
public class SampleInitUtil {
    public static void doSomething(Class clazz) {
        System.out.println(clazz.getName() + ": do something ...");
    }

    public static void before(Class clazz, String note) {
        System.out.println(clazz.getName() + " : " + note + " : before do something ...");
    }

    public static void after(Class clazz, String note) {
        System.out.println(clazz.getName() + " : " + note + " : after do something ...");
    }
}
