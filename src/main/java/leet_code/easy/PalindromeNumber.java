package leet_code.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int input = x;
        if (x < 0) return false;
        int reverseVal = 0;
        while (x > 0) {
            if (reverseVal == 0) {
                reverseVal = x % 10;
            } else {
                reverseVal = (reverseVal * 10) + x % 10;
            }
            x = x / 10;
        }
        return reverseVal == input;
    }
}
