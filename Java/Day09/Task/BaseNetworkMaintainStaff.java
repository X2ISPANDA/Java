/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 15:33
 */
public class BaseNetworkMaintainStaff extends BaseMaintainStaff {
    @Override
    public void maintain() {
        System.out.println(getNo()+getName()+"正在检查网络是否畅通");
    }


}
