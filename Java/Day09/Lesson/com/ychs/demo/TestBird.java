/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 10:05
 */
public class TestBird {
    public static void main(String[] args) {
        TestBird bird = new TestBird();
        //第一种
//		bird.test(new Bird() {
//			@Override
//			public String getName() {
//				return "野鸡";
//			}
//			@Override
//			public String fly() {
//				return "扑腾";
//			}
//		});
        //第二种
        Bird bird2 = new Bird() {
            @Override
            public String fly() {
                return "扑腾";
            }
        };
        bird2.setName("野鸡");
        bird.test(bird2);

        //第三种
//		BirdSon sonBird = new BirdSon();
//		bird.test(sonBird);
    }
    public void test(Bird bird) {
        System.out.println("name："+bird.getName());
        System.out.println(bird.fly());
    }
}
/**
 * 第三种
 * @author wjm
 * @date 2019年7月17日
 */
class BirdSon extends Bird{

    @Override
    public String fly() {
        return "扑腾";
    }
    @Override
    public String getName() {
        return "野鸡";
    }
}
