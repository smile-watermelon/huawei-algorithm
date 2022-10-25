package com.guagua.simple.array;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * @author guagua
 * @date 2022/10/25 18:12
 * @describe HJ83 二维数组操作
 * <p>
 * 描述
 * 有一个m*n\m∗n 大小的数据表，你会依次进行以下5种操作：
 * 1.输入m\m 和n\n ，初始化m*n\m∗n 大小的表格。
 * 2.输入x_1x
 * 1
 * ​
 * 、y_1y
 * 1
 * ​
 * 、x_2x
 * 2
 * ​
 * 、y_2y
 * 2
 * ​
 * ，交换坐标在(x_1,y_1)(x
 * 1
 * ​
 * ,y
 * 1
 * ​
 * )和(x_2,y_2)(x
 * 2
 * ​
 * ,y
 * 2
 * ​
 * )的两个数。
 * 3.输入x\x ，在第x\x 行上方添加一行。
 * 4.输入y\y ，在第y\y 列左边添加一列。
 * 5.输入x\x 、y\y ，查找坐标为(x,y)\(x,y) 的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 * <p>
 * 详细要求:
 * <p>
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的m*n\m∗n 大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对m*n\m∗n 大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 * <p>
 * 本题含有多组样例输入！行列从0开始标号
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5
 * 进阶：时间复杂度：O(1)\O(1) ，空间复杂度：O(1)\O(1)
 * 输入描述：
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 * <p>
 * 输出描述：
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 * <p>
 * 示例1
 * 输入：
 * 4 9
 * 5 1 2 6
 * 0
 * 8
 * 2 3
 * 4 7
 * 4 2 3 2
 * 3
 * 3
 * 4 7
 * 复制
 * 输出：
 * 0
 * -1
 * 0
 * -1
 * 0
 * 0
 * -1
 * 0
 * 0
 * -1
 * 复制
 * 说明：
 * 本组样例共有2组样例输入。
 * 第一组样例：
 * 1.初始化数据表为4行9列，成功
 * 2.交换第5行1列和第2行6列的数据，失败。因为行的范围应该是(0,3)，不存在第5行。
 * 3.在第0行上方添加一行，成功。
 * 4.在第8列左边添加一列，失败。因为列的总数已经达到了9的上限。
 * 5.查询第2行第3列的值，成功。
 * 第二组样例：
 * 1.初始化数据表为4行7列，成功
 * 2.交换第4行2列和第3行2列的数据，失败。因为行的范围应该是(0,3)，不存在第4行。
 * 3.在第3行上方添加一行，成功。
 * 4.在第3列左边添加一列，成功。
 * 5.查询第4行7列的值，失败。因为虽然添加了一行一列，但数据表会在添加后恢复成4行7列的形态，所以行的区间仍然在[0,3]，列的区间仍然在[0,6]，无法查询到(4,7)坐标。
 */
public class ArrayOpeHJ83 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (scanner.hasNextInt()) { // 注意 while 处理多个 case
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println((m > 9 || n > 9) ? -1 : 0);
//            int[][] a = new int[m][n];
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(((Math.max(x1, x2) >= m) || (Math.max(y1, y2) > n)) ? -1 : 0);
            int x = scanner.nextInt();
            System.out.println(x > m || (m + 1) > 9 ? -1 : 0);
            int y = scanner.nextInt();
            System.out.println(y > n || (y + 1) > 9 ? -1 : 0);
            x = scanner.nextInt();
            y = scanner.nextInt();
            System.out.println((x >= m || y >= n) ? -1 : 0);


        }
    }
}
