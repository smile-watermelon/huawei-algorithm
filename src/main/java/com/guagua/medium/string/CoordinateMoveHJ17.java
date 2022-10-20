package com.guagua.medium.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author guagua
 * @date 2022/10/19 15:30
 * @describe 坐标移动
 *
 * A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 */
public class CoordinateMoveHJ17 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(";");
        int x = 0;
        int y = 0;
        for(String s : in){
            // 不满足题目给定坐标规则
            if(!s.matches("[WASD][0-9]{1,2}")){
                continue;
            }
            int val = Integer.parseInt(s.substring(1));
            switch(s.charAt(0)){
                case 'W':
                    y += val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }
        System.out.println(x+","+y);
    }
}
