package com.guagua.simple;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/19 20:07
 * @describe
 */
public class reversalStringHJ31 {

    public static void main(String[] args) {
        String s = "$bo*y gi!r#l";

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] split = str.split("[^A-Za-z]");
            StringBuilder stringBuilder = new StringBuilder("");

            for (int i = split.length - 1; i >= 0; i--) {
                stringBuilder.append(split[i]).append(" ");
            }
            System.out.print(stringBuilder.toString().trim());
        }
    }

}
