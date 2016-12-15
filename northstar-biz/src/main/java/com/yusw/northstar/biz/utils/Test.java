package com.yusw.northstar.biz.utils;

/**
 * Created by yusw on 2016/12/14.
 */
public class Test {
    public static void main(String[] args) {
        int a=10;
        int b =20;
        method1( a, b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    public static void method1(int a,int b){
        a=100;
        b=200;
    }
}
