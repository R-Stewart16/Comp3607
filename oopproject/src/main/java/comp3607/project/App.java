package comp3607.project;

import java.util.*;
import java.io.File;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void  listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        final File folder = new File("FilesToRename");
        listFilesForFolder(folder);
    }
}
