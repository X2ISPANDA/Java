import java.util.Scanner;

/**
 * @Description:求矩形的面积和周长
 * @Author Mingyu Xiong
 * @Date 2019/07/09 16:27
 */
public class Rectangle {
    public static void main(String[] args) {
        System.out.print("请输入矩形的宽：");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.print("请输入矩形的高：");
        double h = sc.nextDouble();

        System.out.println("矩形的面积是：" + (a * h));
        System.out.println("圆的周长是：" + (2 * (h + a)));
    }
}
