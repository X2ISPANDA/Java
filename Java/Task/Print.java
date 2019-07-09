/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/09 16:43
 */
public class Print {
    public static void main(String[] args) {
        Market mac = new Market("MacBookAir", 13.3, 6888.88, 5);
        Market lenovo = new Market("ThinkpadT450", 14.0, 5999.99, 10);
        Market asus = new Market("ASUS-FL5800", 15.6, 4999.5, 18);
        System.out.println("---------------商场库存清单---------------");
        System.out.println("品牌型号"+"\t\t"+"尺寸"+"\t"+"价格"+"\t"+"库存");
        mac.show();
        lenovo.show();
        asus.show();
        System.out.println("----------------------------------------");

        System.out.println("总库存数:"+(mac.amount+lenovo.amount+asus.amount));
        System.out.println("库存商品总金额:"+(mac.Calc()+lenovo.Calc()+asus.Calc()));
    }
}
