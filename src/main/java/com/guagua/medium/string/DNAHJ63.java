package com.guagua.medium.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/21 13:35
 * @describe HJ63 DNA序列
 * <p>
 * 描述
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 * <p>
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 * <p>
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 * <p>
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 * <p>
 * 示例1
 * 输入：ACGT
 * 2
 * 输出：CG
 * <p>
 * 说明：ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG
 * <p>
 * 示例2
 * 输入：AACTGTGCACGACCTGA
 * 5
 * 输出：GCACG
 * <p>
 * 说明：虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 */
public class DNAHJ63 {

    public static void main(String[] args) {
//        m1();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int subLen = scanner.nextInt();

            String result = "";
            int len = 0;

            for (int i = 0; i < str.length() - subLen + 1; i++) {
                String subStr = str.substring(i, subLen + i);
                String s = subStr.replaceAll("[GC]", "");
                int diff = subStr.length() - s.length();
                if (diff > len) {
                    len = diff;
                    result = subStr;
                }
            }
            System.out.println(result);
        }

    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String DNAStr = scanner.next();
            int subLen = scanner.nextInt();

            ArrayList<String> list = new ArrayList<>();
            int subCount = 0;
            // DNAStr.length() - subLen + 1 因为是截取到字符串最后一个位置
            // 为了防止越界这里需要 减去子串的长度 例如：ACGT 2，最后一组是GT G下标为2，2 +2 = 4 是字符串的长度
            for (int i = 0; i < DNAStr.length() - subLen + 1; i++) {
//                if (subLen + i < DNAStr.length()) {
                    String subStr = DNAStr.substring(i, subLen + i);
                    String repStr = subStr.replaceAll("[GC]", "");
                    int diff = subLen - repStr.length();
                    if (subLen != repStr.length() && diff > subCount) {
                        subCount = diff;
                        list.clear();
                        list.add(subStr);
                    }
//                }

            }
            System.out.println(list.get(0));
        }
    }


}
