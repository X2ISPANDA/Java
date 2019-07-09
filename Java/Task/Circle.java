import java.util.Scanner;

/**
 * @Description:求圆的面积和周长
 * @Author Mingyu Xiong
 * @Date 2019/07/09 16:22
 */
public class Circle {
    public static void main(String[] args) {
        final double PI=3.14;
        System.out.print("请输入圆的半径：");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();

        System.out.println("圆的面积是：" + (PI * r * r));
        System.out.println("圆的周长是：" + (2 * PI * r));
    }
}
