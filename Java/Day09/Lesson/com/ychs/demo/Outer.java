/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:外部类和内部类
 * @date 2019/07/17 10:05
 */
public class Outer {
    private int num = 3;

    private Inner inner2 = new Inner();

    class Inner
    {
        void show(){
            System.out.println("你是弟中弟" + num);//内部类可以直接访问外部类的属性方法
            class InnerInInner{
                private int num=4;
                void show(){
                    System.out.println("你是弟中弟中弟" + num);
                    class InnerInInnerInInner{
                        private int num=5;
                        void show(){
                            System.out.println("你是弟中弟中弟中弟" + num);
                            class InnerInInnerInInnerInInner{
                                private int num=6;
                                void show(){
                                    System.out.println("你是弟中弟中弟中弟中弟" + num);
                                }
                            }
                            new InnerInInnerInInnerInInner().show();
                        }
                    }
                    new InnerInInnerInInner().show();
                }
            }
            new InnerInInner().show();
        }
    }

    /**
     * 在外部类里又定义了一个方法,创建内部类的对象,然后调用内部类的方法
     */
    public void method(){
        Inner in = new Inner();
        in.show();

    }

    public static void main(String[] args) {
        //第一种方式
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
        //第二种方法
        new Outer().new Inner().show();
        //第三种方法
        outer.inner2.show();
    }
}

class InnerClassDemo{
    public static void main(String[] args){
        Outer out = new Outer();
        out.method();
    }
}
