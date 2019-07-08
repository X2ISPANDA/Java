/**
 * @Description: 去年Apple笔记本所占市场份额是20，今年增长的市场额是9.8，求今年所占份额
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:43
 */
public class Apple {
    public static void main(String[] args) {
        float apple = 0.2f;
        float thisYear = apple * (1 + 0.098F);
        System.out.println(thisYear);
    }
}
