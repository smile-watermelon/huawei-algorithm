package com.guagua.medium;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author guagua
 * @date 2022/10/20 11:07
 * @describe 密码验证合格程序
 * <p>
 * 描述
 * 密码要求:
 * <p>
 * 1.长度超过8位
 * <p>
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * <p>
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 一组字符串。
 * <p>
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 * <p>
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 复制
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */
public class PasswordVerifyHJ20 {

    public static void main(String[] args) {

//        String s="a     ";
//        System.out.println(s.contains("\t"));


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String pwd = scanner.nextLine();

            if (pwd.length() < 8 || pwd.length() > 100) {
//                System.out.println("密码长度大于8小于100");
                System.out.println("NG");
                continue;
            }

            if (!verify(pwd)) {
                System.out.println("NG");
                continue;
            }
            // 判断是否有长度大于2的包含公共元素的子串重复
            if (hasSubStr(pwd, 0, 3)) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }
    }

    private static boolean hasSubStr(String pwd, int l, int r) {
        // 滑动窗口已到字符串最后
        if (r >= pwd.length()) {
            return false;
        }
        if (pwd.substring(r).contains(pwd.substring(l, r))) {
            return true;
        } else {
            return hasSubStr(pwd, l + 1, r + 1);
        }
    }

    private static boolean verify(String pwd) {
        int count = 0;
        if (pwd.contains(" ")) {
            return false;
        }
        if (Pattern.compile("[A-Z]").matcher(pwd).find()) {
            count++;
        }
        if (Pattern.compile("[0-9]").matcher(pwd).find()) {
            count++;
        }
        if (Pattern.compile("[a-z]").matcher(pwd).find()) {
            count++;
        }
        if (Pattern.compile("[^A-Za-z0-9]").matcher(pwd).find()) {
            count++;
        }

        return count >= 3;
    }
}
