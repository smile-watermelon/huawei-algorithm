package com.guagua.simple.string;

import sun.security.provider.ConfigFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author guagua
 * @date 2022/10/25 17:00
 * @describe HJ87 密码强度等级
 * <p>
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 密码里的字母全都是小（大）写字母
 * 20 分: 密码里的字母符合”大小写混合“
 * <p>
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励（只能选符合最多的那一种奖励）:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱（Very_Weak）
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * SECURE
 * VERY_STRONG
 * STRONG
 * AVERAGE
 * WEAK
 * VERY_WEAK
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * 字母：a-z, A-Z
 * 数字：0-9
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 * :;<=>?@             (ASCII码：0x3A~0x40)
 * [\]^_`              (ASCII码：0x5B~0x60)
 * {|}~                (ASCII码：0x7B~0x7E)
 * <p>
 * 提示:
 * 1 <= 字符串的长度<= 300
 * 输入描述：
 * 输入一个string的密码
 * <p>
 * 输出描述：
 * 输出密码等级
 * <p>
 * 示例1
 * 输入：
 * 38$@NoNoN
 * 复制
 * 输出：
 * VERY_SECURE
 * 复制
 * 说明：
 * 样例的密码长度大于等于8个字符，得25分；大小写字母都有所以得20分；有两个数字，所以得20分；包含大于1符号，所以得25分；由于该密码包含大小写字母、数字和符号，所以奖励部分得5分，经统计得该密码的密码强度为25+20+20+25+5=95分。
 * <p>
 * 示例2
 * 输入：
 * Jl)M:+
 * 复制
 * 输出：
 * AVERAGE
 * 复制
 * 说明：
 * 示例2的密码强度为10+20+0+25+0=55分。
 */
public class PasswordVerifyHJ87 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String pwd = scanner.next();
            int len;
            if (pwd.length() <= 4) {
                len = 5;
            } else if (pwd.length() < 8) {
                len = 10;
            } else {
                len = 25;
            }
            int numeric = 0;
            int big = 0;
            int small = 0;
            int symbol = 0;
            for (int i = 0; i < pwd.length(); i++) {
                if (Character.isDigit(pwd.charAt(i))) {
                    if (numeric <= 20) {
                        numeric += 10;
                    }
                } else if (pwd.charAt(i) >= 'A' && pwd.charAt(i) <= 'Z') {
                    if (big < 20) {
                        big += 10;
                    }
                } else if (pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z') {
                    if (small < 20) {
                        small += 10;
                    }
                } else if (Pattern.matches("[^A-Za-z0-9]", String.valueOf(pwd.charAt(i)))) {
                    if (symbol < 20) {
                        symbol += 10;
                    }
                }
            }
            int score = len + numeric;
            if (symbol == 20) {
                score += 25;
            } else if (symbol == 10) {
                score += 10;
            }
            if (big != 0 && small != 0) {
                score += 20;
            } else if ((big == 0 && small != 0) || (big != 0 && small == 0)) {
                score += 10;
            }

            if (big != 0 && small != 0 && numeric != 0 && symbol != 0) {
                score += 5;
            } else if ((big != 0 || small != 0) && numeric != 0 && symbol != 0) {
                score += 3;
            } else if ((big != 0 || small != 0) && numeric != 0) {
                score += 2;
            }


            if (score >= 90) {
                System.out.println("VERY_SECURE");
            } else if (score >= 80) {
                System.out.println("SECURE");
            } else if (score >= 70) {
                System.out.println("VERY_STRONG");
            } else if (score >= 60) {
                System.out.println("STRONG");
            } else if (score >= 50) {
                System.out.println("AVERAGE");
            } else if (score >= 25) {
                System.out.println("WEAK");
            } else
                System.out.println("VERY_WEAK");
        }


    }
}
