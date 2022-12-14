package com.guagua.simple.string;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/18 20:24
 * @describe 字符串分隔
 * <p>
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例
 * 输入：abc
 * 输出：abc00000
 */
public class SplitStringHJ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.length() > 100) {
                System.out.println("字符串长度小于100");
                continue;
            }
            int len = str.length();
            int diff = 8 - len % 8;

            StringBuilder sb = new StringBuilder(str);//牢记字符串缓冲区的建立语法
            while (diff > 0 && diff < 8) { //注意边界调节，避免addzero=8
                sb.append('0');//使用‘’或“”都可
                diff--;
            }
            String str1 = sb.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }

        }
    }
}
