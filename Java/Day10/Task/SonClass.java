/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */


/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 10:13
 */
public class SonClass extends Father implements ITeacher,IActor {
    @Override
    public void actor() {
        System.out.println(getName()+"会演戏");
    }

    @Override
    public void playGuitar() {
        System.out.println(getName()+"是六指琴魔");
    }

    @Override
    public void playChess() {
        System.out.println(getName()+"是个围棋少年");
    }

    @Override
    public void read() {
        System.out.println(getName()+"爱看带颜色的书籍");
    }

    @Override
    public void paint() {
        System.out.println(getName()+"爱画艺术");
    }
}
