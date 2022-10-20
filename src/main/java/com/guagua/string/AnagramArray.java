package com.guagua.string;


/**
 * @author guagua
 * @date 2022/10/20 18:31
 * @describe 是否包含变位词，纯英文小写，用数组代替哈希表
 */
public class AnagramArray {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ac", "dgcaf"));
    }

    /**
     * s2 中是否包含 s1变位词
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] counts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
            System.out.println(i);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            System.out.println(i + " " + (i - s1.length()));
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++; // 当前字符，一次只有一个字符，进入加+1, 离开-1
            if (areaAllZero(counts)) {
                return true;
            }
        }
        return false;
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
