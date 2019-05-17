package com.lc.jvm;

import org.junit.jupiter.api.Test;

/**
 * create time 2019 5 17
 * @author lc
 */
@SuppressWarnings("all")
public class Gc {

    public static void main(String[] args) {

        String str = "hello world!!!!";
        System.out.println(str.hashCode());
        str = "nice day!";
        System.out.println(str.hashCode());
        str = "hello world!!!!";
        System.out.println(str.hashCode());
        System.out.println();
    }

    @Test
    public void hashCodeTest(){
        String str = new String("hello world!!!!");
//        String str = "hello world!!!!";
        System.out.println(str.hashCode()+"str1的hashCode");
//        String str2 = "hello world!!!!";
        String str2 = new String("hello world!!!!");
        System.out.println(str2.hashCode()+"str2的hashCode");
        System.out.println(str==str2);

    }

}
