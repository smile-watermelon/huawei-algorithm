package com.guagua.string;

/**
 * @类名: PalindromeString
 * @描述: 判断一个字符串是不是回文字符串
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/9/14 15:13
 */
public class PalindromeString {

    public static void main(String[] args) {
        String s = "1abcba";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);

    }

    private static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int n = sb.length();
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
