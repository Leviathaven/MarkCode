package com.markcode;

import com.pair.Pair;
import com.readfiles.ReadFiles;

import java.util.*;

public class MarkCode {
    
    Map<Integer, Pair> mapping;
    List<String> specialNums;
    String allLetters;

    public MarkCode() {
        specialNums = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        List<String> readMarkSequence = ReadFiles.readFile("marksequency.txt");
        allLetters = readMarkSequence.get(0);

        mapping = new HashMap<Integer, Pair>();
        mapping.put(0, new Pair("1",""));
        mapping.put(1, new Pair("2",""));
        mapping.put(2, new Pair("3",""));
        mapping.put(3, new Pair("4",""));
        mapping.put(4, new Pair("5",""));
        mapping.put(5, new Pair("6",""));
        mapping.put(6, new Pair("7",""));

        mapping.put(7, new Pair("8","1"));
        mapping.put(8, new Pair("8","2"));
        mapping.put(9, new Pair("8","3"));
        mapping.put(10, new Pair("8","4"));
        mapping.put(11, new Pair("8","5"));
        mapping.put(12, new Pair("8","6"));
        mapping.put(13, new Pair("8","7"));
        mapping.put(14, new Pair("8","8"));
        mapping.put(15, new Pair("8","9"));
        mapping.put(16, new Pair("8","0"));

        mapping.put(17, new Pair("9","1"));
        mapping.put(18, new Pair("9","2"));
        mapping.put(19, new Pair("9","3"));
        mapping.put(20, new Pair("9","4"));
        mapping.put(21, new Pair("9","5"));
        mapping.put(22, new Pair("9","6"));
        mapping.put(23, new Pair("9","7"));
        mapping.put(24, new Pair("9","8"));
        mapping.put(25, new Pair("9","9"));
        mapping.put(26, new Pair("9","0"));

        mapping.put(27, new Pair("0","1"));
        mapping.put(28, new Pair("0","2"));
        mapping.put(29, new Pair("0","3"));
        mapping.put(30, new Pair("0","4"));
        mapping.put(31, new Pair("0","5"));
        mapping.put(32, new Pair("0","6"));
        mapping.put(33, new Pair("0","7"));
    }

    public String encodeLine(String line) {
        char[] symbols = line.toCharArray();
        String result = "";
        for (int i = 0; i < symbols.length; i++) {
            char currSymb = symbols[i];
            if ((Character.isLetter(currSymb)) || (currSymb == '.') || (currSymb == '/')){
                result += this.mapping.get(allLetters.indexOf(currSymb)).glue();
            }
            else {
                result += currSymb;
            }

        }
        return result;
    }

    public String decodeLine(String line) {
        String result = "";
        String currSymbEncoded = "";
        for(String symbol: line.split("")) {
            if(currSymbEncoded.equals("")) {
                if (this.specialNums.contains(symbol)) {
                    result = result + allLetters.charAt(Integer.valueOf(symbol) - 1);
                }
                else if (Character.isDigit(symbol.charAt(0))) {
                    currSymbEncoded += symbol;
                }
                else {
                    result += symbol;
                }
            }
            else {
                currSymbEncoded += symbol;
                List<Integer> keys = new ArrayList(this.mapping.keySet());
                for(Integer key: keys) {
                    Pair currPair = this.mapping.get(key);
                    if (currPair.glue().equals(currSymbEncoded)) {
                        result = result + allLetters.charAt(key);
                    }
                }
                currSymbEncoded = "";
            }

        }
        return result;
    }

}