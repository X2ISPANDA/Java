/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 15:35
 */
public class StaffTest {
    public static void main(String[] args) {
        BaseJavaEEDevelopStaff javaEEStaff = new BaseJavaEEDevelopStaff();
        javaEEStaff.setName("王武");
        javaEEStaff.setNo(1024);
        javaEEStaff.develop();

        BaseAndroidDevelopStaff androidDevelopStaff = new BaseAndroidDevelopStaff();
        androidDevelopStaff.setNo(10);
        androidDevelopStaff.setName("小三");
        androidDevelopStaff.develop();

        BaseNetworkMaintainStaff networkMaintainStaff = new BaseNetworkMaintainStaff();
        networkMaintainStaff.setName("凳子骑");
        networkMaintainStaff.setNo(438);
        networkMaintainStaff.maintain();

        BaseHardwareMaintainStaff hardwareMaintainStaff = new BaseHardwareMaintainStaff();
        hardwareMaintainStaff.setNo(38);
        hardwareMaintainStaff.setName("蔡依林");
        hardwareMaintainStaff.maintain();
    }
}
