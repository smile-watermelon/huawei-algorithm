package com.guagua.simple.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author guagua
 * @date 2022/10/18 16:54
 * @describe  计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 */
public class StringLengthHJ1 {

    public static void main(String[] args) {
        // 测试
//        String s = "  h  ";
//        System.out.println(s.length());
//        System.out.println(s.trim().length());

        Scanner scanner = new Scanner(System.in);
        int length = 5000;
        scannerHasNextLine(scanner, length);

        // 测试 nextIn
        scannerHasNextInt(scanner, length);
    }

    public static void scannerHasNextLine(Scanner scanner, int strLen) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.length() <= 0 ) {
                System.out.println("请输入字符串");
                continue;
            }
            if (line.length() > strLen) {
                System.out.println("字符串长度小于" + strLen);
                continue;
            }
            System.out.println(lastWordLength(line));
            System.out.println(lastWordLength2(line));
        }
    }

    public static void scannerHasNextInt(Scanner scanner, int strLen) {
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(a + b);
        }
    }

    public static int lastWordLength(String line) {
        if (null == line) {
            return -1;
        }
        List<String> words = Arrays.stream(line.trim().split(" "))
                .map(String::trim)
                .collect(Collectors.toList());
        String word = words.get(words.size() - 1).trim();
        return word.length();
    }

    public static int lastWordLength2(String line) {
        if (null == line) {
            return -1;
        }
        String[] words = line.split(" ");
        return words[words.length - 1].trim().length();
    }

}