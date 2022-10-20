package com.guagua.string;


import java.util.LinkedList;
import java.util.List;

/**
 * @author guagua
 * @date 2022/10/20 18:31
 * @describe 包含所有变位词在字符串中的下表，纯英文小写，用数组代替哈希表
 */
public class AnagramAllArray {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbadabacg", "abc"));
    }

    /**
     * s1 中找出所有 s2 变位词
     *
     * @param s1
     * @param s2
     * @return
     */
    public static List<Integer> findAnagrams(String s1, String s2) {
        LinkedList<Integer> indices = new LinkedList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }
        int[] counts = new int[26];
        int i = 0;
        for (; i < s2.length(); ++i) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }

        if (areaAllZero(counts)) {
            indices.add(0);
        }
        for (; i < s1.length(); ++i) {
            counts[s1.charAt(i) - 'a']--;
            counts[s1.charAt(i - s2.length()) - 'a']++;
            if (areaAllZero(counts)) {
                indices.add(i - s2.length() + 1);
            }
        }
        return indices;
    }

    public static boolean areaAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
