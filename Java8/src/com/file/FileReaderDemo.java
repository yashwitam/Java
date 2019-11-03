package com.file;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderDemo {

    public static void main(String[] args) throws FileNotFoundException {
        File csvFile = new File("file.csv");

        InputStream inputStream = new FileInputStream(csvFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        List<Identity> identityList = br.lines().skip(1)
                .map(item -> item.split(","))
                .map(item -> new Identity(Long.valueOf(item[0]), item[1], item[2], item[3], item[4], item[5]))
                .collect(Collectors.toList());

        identityList.forEach(identity -> System.out.println(identity.getName()));

    }

}
