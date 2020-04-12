/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/14 20:34
 */
class Point {

    public String string = "sss";


    public class Line { public int x,y;
        public String string = "aaa";
        void test() {
            System.out.println(Point.this.string);
            System.out.println(string);
        }
    }
    public Point getPoint() { return new Point(); }
    public class P{}

    public Line getLineInstance() {
        return new Line();
    }
    public static void main(String[] args) {
        Point point = new Point();
        Point.Line line = point.new Line();
        Point.Line line1 = point.getLineInstance();
        line1.test();
        line.test();
    }


}

class Triangle {
    public Triangle() {

        }
}

public class Line {

}
