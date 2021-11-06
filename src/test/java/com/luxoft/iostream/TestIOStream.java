package com.luxoft.iostream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.luxoft.iostream.FileManager.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIOStream {

    @Test
    public void testAddNewDirectory() {
        String path = "D:\\test\\";
        String subPath = "test\\";
        mkdir(path + subPath + subPath);
        assertEquals(2, countDirs(path));
    }

    @Test
    public void testRemoveDirectory() {
        String path = "D:\\test\\";
        String subPath = "test\\";
        remove(new File(path + subPath));
        assertEquals(0, countDirs(path));
    }

    @Test
    public void testCounter() {
        String pathDir = "D:\\test\\";
        countFiles(pathDir);
        countDirs(pathDir);
    }

    @Test
    public void testCopy() throws IOException {
        String pathDir = "D:\\test\\";
        String pathNew = "C:\\test\\";
        String file = "Java Basics 05 final.pptx";
            copy(pathDir, pathNew, file);
//            move(pathDir, pathNew, file);
   }
}