package leet_code.easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        char currentChar = 0;
        StringBuilder output = new StringBuilder();
        Arrays.sort(strs, (Comparator.comparingInt(String::length)));
        if (strs.length == 1){
            return strs[0];
        }
        for (int j = 0; j < strs[0].length(); j++){
            for (int i = 0; i < strs.length; i++) {
                char runningChar = strs[i].charAt(index);
                if (i==0){
                    currentChar = runningChar;
                } else {
                    if (currentChar != runningChar){
                        return output.toString();
                    } else if (i == strs.length-1){
                        output.append(runningChar);
                    }
                }
            }
            index++;
        }
        return output.toString();
    }
}
