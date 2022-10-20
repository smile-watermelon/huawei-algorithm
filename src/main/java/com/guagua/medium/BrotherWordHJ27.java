package com.guagua.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author guagua
 * @date 2022/10/20 15:31
 * @describe 查找兄弟单词
 * <p>
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 * <p>
 * 数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
 * <p>
 * 输入描述：
 * 输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
 * <p>
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * <p>
 * 示例1
 * 输入：3 abc bca cab abc 1
 * <p>
 * 输出：
 * 2
 * bca
 * <p>
 * 示例2
 * 输入：6 cab ad abcd cba abc bca abc 1
 * <p>
 * 输出：
 * 3
 * bca
 * 说明：abc的兄弟单词有cab cba bca，所以输出3 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 */
public class BrotherWordHJ27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordsTotal = scanner.nextInt();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < wordsTotal; i++) {
            words.add(scanner.next());
        }
//        System.out.println(wordsTotal);
//        System.out.println(words);
        String brother = scanner.next();
//        System.out.println(brother);
        int k = scanner.nextInt();
//        System.out.println(k);
        List<String> sorted = words.stream()
                .filter(i -> {
                    if (i.length() != brother.length()) {
                        return false;
                    }
                    if (i.equals(brother)) {
                        return false;
                    }
                    char[] chars = i.toLowerCase().toCharArray();
                    Arrays.sort(chars);
                    char[] chars1 = brother.toLowerCase().toCharArray();
                    Arrays.sort(chars1);

                    return String.valueOf(chars).equals(String.valueOf(chars1));
                }).sorted().collect(Collectors.toList());

        System.out.println(sorted.size());
        if (k < sorted.size()) {
            System.out.println(sorted.get(k - 1));
        }

    }
}
