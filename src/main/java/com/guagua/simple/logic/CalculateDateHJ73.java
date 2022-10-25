package com.guagua.simple.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 18:39
 * @describe HJ73 计算日期到天数转换
 */
public class CalculateDateHJ73 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day=  scanner.nextInt();

            Calendar instance = Calendar.getInstance();
            instance.set(year, month -1, day);
            System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        }
    }
}
