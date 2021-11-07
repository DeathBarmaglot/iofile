package com.luxoft.iostream;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    static ArrayList<String> listDir = new ArrayList();
    static ArrayList<String> listFile = new ArrayList();

    public static void move(String from, String to) throws IOException {
        copy(from, to);
        System.out.println("Remove directory & Remove file " + to);
        File src = new File(from);
        remove(src);
    }

    public static void remove(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                remove(sub);
            }
        }
        element.delete();
        listDir = new ArrayList();
    }

    public static void mkdir(String path) {
        new File(path).mkdirs();
    }

    public static void copy(String from, String to) {

        listDir.stream().map(s -> ("" + s).replace(from, to)).forEach(FileManager::mkdir);

        for (Object o : listFile) {
            try {
                newCopy("" + o, ("" + o).replace(from, to));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void newCopy(String from, String to) throws IOException {

        File src = new File(from);
        File dest = new File(to);

        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];

        int length;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
        System.out.println("Create new directory & copy file " + to);
    }

    public static int countDirs(String path) {

        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        if (innerPaths != null) {
            for (File innerPath : innerPaths) {
                if (innerPath.isDirectory()) {
                    countDirs("" + innerPath);
                    listDir.add("" + innerPath);
                }
            }
        }
        return listDir.size();
    }

    public static int countFiles(String path) {

        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        if (innerPaths != null) {
            for (File innerPath : innerPaths) {
                if (innerPath.isFile())
                    listFile.add("" + innerPath);
                if (innerPath.isDirectory()) {
                    countFiles("" + innerPath);
                }
            }
        }
        return listFile.size();
    }
}
