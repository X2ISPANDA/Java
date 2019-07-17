/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 15:34
 */
public class BaseHardwareMaintainStaff extends BaseMaintainStaff {
    @Override
    public void maintain() {
        System.out.println(getNo()+getName()+"正在修复打印机");
    }
}
