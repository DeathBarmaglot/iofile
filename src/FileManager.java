import java.io.*;

public class FileManager {
    static String pf = "D:\\Telegram Desktop\\";
    static  int c = 0;
    public static int countFiles(String paths) {
        File path = new File (paths);
        File [] innerPaths = path.listFiles();

        for (File innerPath: innerPaths){
                if (innerPath.isFile())
                    c++;
                if (innerPath.isDirectory()) {
                    countFiles("" + innerPath);

            }
        }
        return c;
    }

    public static void main(String... args) throws IOException {
        File path = new File (pf);
        File [] innerPaths = path.listFiles();
        for (File innerPath: innerPaths){
            if (innerPath.isFile())
                c++;
        if (innerPath.isDirectory()){
            countFiles("" + innerPath);

            }

        }
            System.out.println("Total files in directory "+ pf + " are "+c);


    }
}




