package com.guagua.simple.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 12:27
 * @describe 句子逆序
 * <p>
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * <p>
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * <p>
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 * <p>
 * 输出描述：得到逆序的句子
 * <p>
 * <p>
 * 示例1
 * 输入：I am a boy
 * 输出：boy a am I
 * <p>
 * 输入：nowcoder
 * 输出：nowcoder
 */
public class RevertStringHJ13 {

    public static void main(String[] args) {
//        m1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");

            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String result = Arrays.stream(str.split(" "))
                    .reduce((v, v1) -> v1 + " " + v).get();
            System.out.println(result);
        }
    }
}
