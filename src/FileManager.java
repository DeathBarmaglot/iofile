import java.io.*;

public class FileManager {
    static String copyFrom = "D:\\eng\\";
    static String copyTo = "C:\\eng\\";
    static String pathDir = "D:\\Telegram Desktop\\";
    static int countFile = 0;
    static int countDir = 0;

    public static void copy(String from, String to){
        new File(to).mkdirs();


    }

    public static int countDirs(String path) {
        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        for (File innerPath : innerPaths) {
            if (innerPath.isDirectory()) {
                countDirs("" + innerPath);
                countDir++;

            }
        }
        return countDir;
    }

    public static int countFiles(String path) {
        File paths = new File(path);
        File[] innerPaths = paths.listFiles();
        for (File innerPath : innerPaths) {
            if (innerPath.isFile())
                countFile++;
            if (innerPath.isDirectory()) {
                countFiles("" + innerPath);

            }
        }
        return countFile;
    }

    public static void main(String... args) throws IOException {
        countFiles(pathDir);
        countDirs(pathDir);
        System.out.println("Total files in directory " + pathDir + " are " + countFile);
        System.out.println("Total subdirectories in directory " + pathDir + " are " + countDir);


    }
}




