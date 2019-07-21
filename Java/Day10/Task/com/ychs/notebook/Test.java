package com.ychs.notebook;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/21 15:13
 */
public class Test {
    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();
        noteBook.run();
        KeyBoard keyBoard = new KeyBoard();
        Mouse mouse = new Mouse();
        noteBook.useUSB(keyBoard);
        noteBook.closeUSB(keyBoard);
        noteBook.useUSB(mouse);
        noteBook.closeUSB(mouse);
        noteBook.shutdown();
    }
}
