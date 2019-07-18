/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Random;

/**
 * @Description:生成四位验证码
 * @Author Mingyu Xiong
 * @Date 2019/07/15 09:10
 */
public class RandomCode {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        int index;
        String code="";
        for(int i=0;i<4;i++) {
            index = r.nextInt(str.length());
            code=code+str.charAt(index);
        }
        System.out.println(code);

    }
}
