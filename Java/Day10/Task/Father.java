/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */


/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 10:08
 */
public class Father {

    private String name;
    private int age;

    public void eat() {
        System.out.println(name+"很会吃大.....");
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
     * Gets the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age
     * You can use getAge() to get the value of age
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
