package leet_code.easy;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> symboleMap = new HashMap<>();
        symboleMap.put('I', 1);
        symboleMap.put('V', 5);
        symboleMap.put('X', 10);
        symboleMap.put('L', 50);
        symboleMap.put('C', 100);
        symboleMap.put('D', 500);
        symboleMap.put('M', 1000);

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int counter = 1;
            int b = symboleMap.get(s.charAt(i));
            int c = i < s.length() - 1 ? symboleMap.get(s.charAt(i + 1)) : -1;
            while (c != -1 && b == c) {
                if (counter < 4) {
                    value = value + b;
                }
                i++;
                if (i == s.length()) {
                    return value;
                }
                b = symboleMap.get(s.charAt(i));
                c = i < s.length() - 1 ? symboleMap.get(s.charAt(i + 1)) : -1;
                counter++;
            }
            if (c == -1) {
                return value + b;
            }
            if (c != -1 && b > c) {
                value = value + b;
            } else if (c != -1) {
                value = value + (c - b);
                i++;
            }
        }
        return value;
    }
}
