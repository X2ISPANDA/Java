import java.util.Scanner;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/09 15:19
 */
public class Grade {
    public static void main(String[] args) {
        System.out.print("STB的成绩是：");
        Scanner sc = new Scanner(System.in);
        int stb = sc.nextInt();
        System.out.print("Java的成绩是：");
        int java=sc.nextInt();
        System.out.print("SQL的成绩是：");
        int sql = sc.nextInt();

        System.out.println("-----------------------------");
        System.out.print("Stb\tJava\tSql\n");
        System.out.print(stb + "\t" + java + "\t" + sql + "\n");
        System.out.println("-----------------------------");
        System.out.println("Java和SQL的成绩差：" + Math.abs(java - sql));
        System.out.println("三门课的平均分："+(stb+java+sql)/3);

    }
}
