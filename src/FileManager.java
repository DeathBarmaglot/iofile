import java.io.*;

public class FileManager {
    static String pathDir = "D:\\Telegram Desktop\\";
    static String pathNew = "C:\\Telegram Desktop\\";
    static String copyFrom = pathDir + "Java Basics 05 final.pptx";
    static String copyTo = pathNew + "Java Basics 05 final.pptx";
    static int countFile = 0;
    static int countDir = 0;

    public static void move(String from, String to) throws IOException {
        copy(from, to);
        System.out.println("Remove directory & Remove file " + copyTo);
        new File(from).delete();
    }


    public static void copy(String from, String to) throws IOException {
        new File(pathNew).mkdir();
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
        System.out.println("Create new directory & copy file " + copyTo);
    }

    public static int countDirs(String path) {
        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        if (innerPaths != null) {
            for (File innerPath : innerPaths) {
                if (innerPath.isDirectory()) {
                    countDirs("" + innerPath);
                    countDir++;

                }
            }
        }
        System.out.println("Total subdirectories in directory " + pathDir + " are " + countDir);

        return countDir;
    }

    public static int countFiles(String path) {
        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        if (innerPaths != null) {
            for (File innerPath : innerPaths) {
                if (innerPath.isFile())
                    countFile++;
                if (innerPath.isDirectory()) {
                    countFiles("" + innerPath);

                }
            }
        }
        System.out.println("Total files in directory " + pathDir + " are " + countFile);
        return countFile;
    }

    public static void main(String... args) throws IOException {
        countFiles(pathDir);
        countDirs(pathDir);
        copy(copyFrom, copyTo);
        move(copyFrom, copyTo);

    }
}




