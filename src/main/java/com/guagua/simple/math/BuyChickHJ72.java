package com.guagua.simple.math;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 18:56
 * @describe HJ72 百钱买百鸡问题
 * <p>
 * 描述
 * 公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 * <p>
 * 输出描述：
 * 输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 * <p>
 * 示例1
 * 输入：
 * 1
 * 复制
 * 输出：
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class BuyChickHJ72 {

    /**
     * 分析
     * 一只鸡翁价值5，100最多买20只鸡，假设可以买x只鸡翁。
     * 一只鸡母价值3，100最多买33只鸡，假设可以买y只鸡母。
     * 三只鸡雏价值1，100最多买300只鸡雏，假设可以买z只鸡雏。
     * 并且是100块钱买一百只鸡。
     * 则有以下表达式成立。
     * 鸡的价值为100
     * 5x + 3y + z/3 = 100;
     * 鸡的只数
     * x + y + z = 100;
     * ==>>> 第一个方程式乘以3
     * 15x + 9y + z = 300;
     * x + y + z = 100;
     * ===>>>两个方程式相减，消除z
     * 14x + 8y = 200 ;
     * ===>
     * 7x + 4y = 100;
     * 因为又满足价值小于 100，假设全部买鸡翁。则最多买 100/7 = 14只。所以  0<=x<=14
     * 根据x求带入方程式7x + 4y = 100;计算出y。根据x ,y带入方程式x + y + z = 100;计算出z;
     * 代码如下：
     *
     * @param args
     */
    public static void main(String[] args) {
        // 鸡翁值5， 一百块最多买20只  鸡翁买x只
        // 鸡母值3， 一百块最多买33只  鸡母买y只
        // 鸡雏三值1， 一百块最多买300只 鸡雏买z只
        // 买x鸡翁，y只鸡母，z只鸡雏
        //5x+3y+z/3=100  ==>  15x + 9y + z = 300
        //x+y+z==100确定         // ==>   14x + 8y = 200  ==> 7x + 4y = 100  ==>  y = (100 - 7x)/4
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x = 0; x <= 14; x++) {
            if ((100 - 7 * x) % 4 == 0) {
                int y = (100 - (7 * x)) / 4;
                int z = 100 - x - y;
                System.out.println(x + " " + y + " " + z);
            }
        }

    }
}