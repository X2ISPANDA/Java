/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 15:27
 */
public abstract class BaseStaff {
    private String name;
    private int no;

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of no
     *
     * @return the value of no
     */
    public int getNo() {
        return no;
    }

    /**
     * Sets the no
     * You can use getNo() to get the value of no
     *
     * @param no no
     */
    public void setNo(int no) {
        this.no = no;
    }
}
