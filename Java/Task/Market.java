/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/09 16:41
 */
public class Market {
    public String type;
    public double size;
    public double prize;
    public int amount;
    

    public Market(String type, double size, double prize, int amount) {
        this.amount = amount;
        this.type = type;
        this.size = size;
        this.prize = prize;
    }

    public void show() {
        System.out.println(type+"\t"+size+"\t"+prize+"\t"+amount+"\t");
    }

    public double Calc() {
        return prize * amount;
    }
}
