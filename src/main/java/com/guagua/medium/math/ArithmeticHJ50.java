package com.guagua.medium.math;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author guagua
 * @date 2022/10/22 23:15
 * @describe HJ50 四则运算
 * <p>
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * <p>
 * 数据范围：表达式计算结果和过程中满足 |val| \le 1000 \∣val∣≤1000  ，字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * <p>
 * 输入描述：
 * 输入一个算术表达式
 * <p>
 * 输出描述：
 * 得到计算结果
 * <p>
 * 示例1
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 复制
 * 输出：
 * 25
 */
public class ArithmeticHJ50 {

    public static void main(String[] args) {
//        m1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String s = str.replace("[", "(")
                    .replace("{", "(")
                    .replace("]", ")")
                    .replace("}", ")");

            System.out.println(resolve1(s));
        }
    }

    private static int resolve1(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        int number = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                number = ch - '0' + number * 10;
            }
            if (ch == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    if (chars[j] == ')') count--;
                    if (chars[j] == '(') count++;
                    j++;
                }
                number = resolve1(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(ch) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = ch;
                number = 0;
            }

        }
        int sum = 0;
        if (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    private static void m1() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //将其他括号，替换成小括号
        s = s.replace("{", "(")
                .replace("[", "(")
                .replace("}", ")")
                .replace("]", ")");
        System.out.println(slove(s));
    }

    public static int slove(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char[] chs = s.toCharArray();
        int index = 0;
        //初始化符号为'+'
        char sign = '+';
        //记录数字
        int number = 0;
        for (int i = 0; i < n; i++) {
            char ch = chs[i];
            //当前字符是空格，跳过
            if (ch == ' ') continue;
            //当前字符是数字，拼数字
            if (Character.isDigit(ch)) {
                number = ch - '0' + number * 10;
            }
            //如果当前字符是小括号
            if (ch == '(') {
                //移到小括号后一位字符
                int j = i + 1;
                //统计括号的数量
                int count = 1;
                while (count > 0) {
                    //遇到右括号，括号数-1
                    if (chs[j] == ')') count--;
                    //遇到左括号，括号数+1
                    if (chs[j] == '(') count++;
                    j++;
                }
                //递归，解小括号中的表达式, todo 递归是暂停到上一次执行的位置
                number = slove(s.substring(i + 1, j - 1));

                i = j - 1;
            }
            //遇到符号，将数字处理后放进栈
            if (!Character.isDigit(ch) || i == n - 1) {
                //如果是'+',直接入栈
                if (sign == '+') {
                    stack.push(number);
                }
                //如果是'-',数字取相反数在入栈
                else if (sign == '-') {
                    stack.push(-1 * number);
                }
                //如果是'*',弹出一个数字乘后放入栈
                else if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                //如果是'/',弹出一个数字/后放入栈
                else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                //更新符号
                sign = ch;
                //刷新数字
                number = 0;
            }
        }
        //栈中数字求和得到结果
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


}
