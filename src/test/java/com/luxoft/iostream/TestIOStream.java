package com.luxoft.iostream;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static com.luxoft.iostream.FileManager.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIOStream {
    public static final String pathDir = "D:\\";
    public static final String pathNew = "C:\\test\\";
    public static final String pathOld = "D:\\test\\";
    public static final String subPath = "test\\";

    @Test
    public void testAddNewDirectory() {

        mkdir(pathOld + subPath + subPath);
            assertEquals(2, countDirs(pathOld));
    }

    @Test
    public void testRemoveDirectory() {
        remove(new File(pathOld + subPath));
        assertEquals(0, countDirs(pathOld));
    }

    @Test
    public void testCounter() {
        countFiles(pathOld);
        countDirs(pathOld);

    }
    @Test
    public void testMoveFile() throws IOException {
        testCounter();
        move(pathOld, pathNew);
    }

    @Test
    public void testCopyFile() {
        testCounter();
        copy(pathOld, pathNew);
    }
}