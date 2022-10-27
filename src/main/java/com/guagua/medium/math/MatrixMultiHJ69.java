package com.guagua.medium.math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/24 17:45
 * @describe HJ69 矩阵乘法
 * <p>
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 * <p>
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 * <p>
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入：
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 * 复制
 * 输出：
 * 14 13
 * 10 11
 * 复制
 * 说明：
 * 1 2 3
 * 3 2 1
 * 乘以
 * 1 2
 * 2 1
 * 3 3
 * 等于
 * 14 13
 * 10 11
 */
public class MatrixMultiHJ69 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayList<Integer> result = new ArrayList<>();
        while (scanner.hasNextInt()) {
//            if (scanner.nextLine() == null) {
//                break;
//            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();


            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            int[][] result = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }
            /**
             * * 2
             *  * 3
             *  * 2
             *  * 1 2 3
             *  * 3 2 1
             *  * 1 2
             *  * 2 1
             *  * 3 3
             *  * 复制
             *  * 输出：
             *  * 14 13
             *  * 10 11
             */
//            System.out.println(matrix1.length);
//            System.out.println(matrix2[0].length);
//            System.out.println(matrix2.length);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
