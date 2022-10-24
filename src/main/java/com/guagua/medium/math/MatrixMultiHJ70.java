package com.guagua.medium.math;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author guagua
 * @date 2022/10/24 21:35
 * @describe HJ70 矩阵乘法计算量估算
 * <p>
 * 描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * <p>
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * <p>
 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 * <p>
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * <p>
 * 数据范围：矩阵个数：1\le n\le 15 \1≤n≤15 ，行列数：1\le row_i,col_i\le 100\1≤row
 * i
 * ​
 * ,col
 * i
 * ​
 * ≤100 ，保证给出的字符串表示的计算顺序唯一。
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * <p>
 * 输入描述：
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 * <p>
 * 输出描述：
 * 输出需要进行的乘法次数
 * <p>
 * 示例1
 * 输入：
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 * 复制
 * 输出：
 * 3500
 */
public class MatrixMultiHJ70 {

    public static void main(String[] args) {

        /**
         * [1,1,1,1,1] * [1, 1]
         * [1,1,1,1,1] * [1, 1]
         *             * [1, 1] = [1*1+1*1+1*1+1*1+1*1,1*1+1*1+1*1+1*1+1*1]
         *               [1, 1]   [1*1+1*1+1*1+1*1+1*1,1*1+1*1+1*1+1*1+1*1]
         *             * [1, 1]
         *            A row = 2 col = 5
         *            B row = 5 col = 2 === 5 * (2 * 2)
         * [1,1] * [1,1]
         * [1,1] * [1,1] =
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            sc.nextLine();
        }
        int count = 0;
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '(') {
                continue;
            } else if (chars[j] == ')') {
                int x = stack.pop();
                int y = stack.pop();
                int z = stack.pop();
                int m = stack.pop();
                count += x * y * m;
                stack.push(m);
                stack.push(x);
            } else {
                stack.push(arr[chars[j] - 'A'][0]);
                stack.push(arr[chars[j] - 'A'][1]);
            }
        }
        System.out.println(count);
    }
}
