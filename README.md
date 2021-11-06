javac ./FileAnalyzer.java && java FileAnalyzer ../asserts/story.txt duck

#Практика: 

1: Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:

    путь к файлу
    слово Usage: java FileAnalyzer C:/test/story.txt duck

Выводит:

    Кол-во вхождений искомого слова в файле
    Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!"). Каждое предложение выводится с новой строки.

 
2: Пишем class FileManager с методами public class FileManager { // public static int countFiles(String path) - принимает путь к папке, // возвращает количество файлов в папке и всех подпапках по пути public static int countFiles(String path) { return 0; }

// public static int countDirs(String path) - принимает путь к папке, // возвращает количество папок в папке и всех подпапках по пути public static int countDirs(String path) { return 0; } }

public static void copy(String from, String to) - метод по копированию папок и файлов. Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование. public static void move(String from, String to) - метод по перемещению папок и файлов. Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
