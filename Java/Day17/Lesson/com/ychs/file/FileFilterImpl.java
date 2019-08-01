/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/30 11:33
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".html");
    }
}
