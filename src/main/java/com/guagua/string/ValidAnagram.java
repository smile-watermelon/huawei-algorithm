package com.guagua.string;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author guagua
 * @date 2022/10/21 01:37
 * @describe 有效的回文
 */
public class ValidAnagram {

    public static void main(String[] args) {
//        args.length
        boolean madam = isPalindrome("1madam");
        System.out.println(madam);
        System.out.println(isPalindromeNum(11));
    }

    public boolean canPermutePalindrome(String s) {
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() <= 1;

    }

    public static boolean isPalindromeNum(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            ch1 = Character.toLowerCase(ch1);
            ch2 = Character.toLowerCase(ch2);
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
