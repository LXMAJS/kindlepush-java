package com.temp.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoApplication {
    public static void main ( String[] args ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        // 类加载
//        Class rc = Class.forName ( "com.temp.demo1.Robot" );
//        // 类实例化
//        Robot r = (Robot)rc.newInstance ();
//
//        System.out.println ("Class name is " + rc.getName ());
//
//        // 获得私有方法
//        Method getHello = rc.getDeclaredMethod ("throwHello", String.class);
//        // 将当前获得的私有方法的访问限制取消，将可访问性设置为true
//        getHello.setAccessible ( true );
//        // 唤醒并调用方法获得返回结果
//        Object obj1 = getHello.invoke (r, "LXMAJS" );
//        System.out.println ("getHello's result is " + obj1);
//
//        // 获得共有方法
//        Method getHi = rc.getMethod ( "sayHi", String.class);
//        // 获得返回结果
//        getHi.invoke ( r, "Welcome" );
//
//
//        // 尝试获得域
//        Field name = rc.getDeclaredField ( "name" );
//        name.setAccessible ( true );
//        name.set ( r, "LXMAJS" );
//        getHi.invoke ( r, "Hello" );



    }
}
