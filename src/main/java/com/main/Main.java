package com.main;

import com.readfiles.ReadFiles;
import com.writefiles.WriteFiles;
import com.markcode.MarkCode;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)  throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Put in the name of the file where to read from: ");
        String readPath = in.nextLine();
        String readPathFile = readPath + ".txt";
        System.out.println("Put in the name of the file where to write to: ");
        String writePath = in.nextLine();
        String writePathFile = writePath + ".txt";
        List<String> result = new ArrayList<String>();
        List<String> theEncodedFile = ReadFiles.readFile(readPathFile);
        MarkCode coder = new MarkCode();

        for (String encoding: theEncodedFile) {
            String encodedLine = coder.encodeLine(encoding);
            result.add(encodedLine);
        }

        List<String> decodedResult = new ArrayList<String>();
        for (String line: result) {
            String decodedLine = coder.decodeLine(line);
            decodedResult.add(decodedLine);
        }

        result.addAll(decodedResult);
        WriteFiles.writeFile(writePathFile, result);
    }
}


