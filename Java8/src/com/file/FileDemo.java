package com.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class FileDemo {

    public static void main(String[] args) {

        //List all files in current directory
        File[] fileArray = new File(".").listFiles();
        List<File> fileList = Arrays.asList(fileArray);

        fileList.forEach(file -> System.out.println(file.getAbsolutePath()));

        //filter hidden files
        File[] hiddenFilesArray = new File(".").listFiles(new FileFilter(){
            public boolean accept(File file){
                return file.isHidden();
            }
        });

        System.out.println("***** Printing hidden files ****");
        List<File> hiddenFileList = Arrays.asList(hiddenFilesArray);

        hiddenFileList.forEach(file -> System.out.println(file.getAbsolutePath()));


        //Java8 concise code using method reference i.e pass method as value
        File[] hiddenFilesArray2 = new File(".").listFiles(File::isHidden);

        System.out.println("***** Printing hidden files ****");
        List<File> hiddenFileList2 = Arrays.asList(hiddenFilesArray2);

        hiddenFileList2.forEach(file -> System.out.println(file.getAbsolutePath()));

    }
}
