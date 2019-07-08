/**
 * @Description:将13467秒转变为：X小时X分X秒
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:37
 */
public class TimeChange {
    public static void main(String[] args) {
        int sec=13467;
        int h;
        int m;
        int s;
        h=13467/3600;
        m=13467%3600/60;
        s=13467%3600%60;
        System.out.println(h+"小时"+m+"分"+s+"秒");
        int result=3*3600+44*60+27;
        System.out.println(result);
    }
}
