package com.temp.demo1.gc;

public class ReferenceCounterProblem {

    public static void main ( String[] args ) {

        // 实例化两个对象
        MyObject object1 = new MyObject ();
        MyObject object2 = new MyObject ();

        // 将两个对象的子节点设置为对方
        object1.childNode = object2;
        object2.childNode = object1;

    }
}
