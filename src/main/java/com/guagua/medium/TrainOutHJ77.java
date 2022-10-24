package com.guagua.medium;

import java.util.*;

/**
 * @author guagua
 * @date 2022/10/24 18:54
 * @describe HJ77 火车进站
 * <p>
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：1\le n\le 10\1≤n≤10
 * 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 * <p>
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * <p>
 * 示例1
 * 输入：
 * 3
 * 1 2 3
 * 复制
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 复制
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class TrainOutHJ77 {

    static List<String> l = new ArrayList<>(); //储存结果

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            l.clear(); //静态变量，每次先清空
            int nums = in.nextInt();
            int[] id = new int[nums];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums; i++) {
                id[i] = in.nextInt();
            }
            trainOut(id, 0, 0, stack, "");
//            System.out.println(l);
//            对结果集排序
            Collections.sort(l);
            for (String str : l) {
                System.out.println(str);
            }
        }
        in.close();
    }

    /**
     *
     * @param id
     * @param i 入栈次数
     * @param j 出栈次数
     * @param stack
     * @param str
     */
    public static void trainOut(int[] id, int i, int j, Stack<Integer> stack, String str
    ) {
        if (j == id.length) {
            l.add(str); //如果所有火车均出栈则将当前结果保存
        }

        // 2、出栈压栈, 进去了
        if (!stack.empty()) { //栈非空时出栈
            int temp = stack.pop();
            trainOut(id, i, j + 1, stack, str + temp + " "); // 最后弹栈停在这
            stack.push(temp); //恢复现场
        }

        // 1、入栈弹栈， 数字挨个进栈，从步骤2弹出来 从入口进入口出。
        if (i < id.length) {
            stack.push(id[i]);
            trainOut(id, i + 1, j, stack, str); // 递归每次入栈都会停
            stack.pop(); //恢复现场

        }
    }
}
