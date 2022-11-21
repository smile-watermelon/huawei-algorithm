package com.guagua.simple.math;

/**
 * @author guagua
 * @date 2022/11/21 11:53
 * @describe
 */
public class IntReverse {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        int n = 0;
//        int s = intReverse(n);
        // x = 1221

    }


    private static int intReverse(int x) {
//        2147483647
//        -2147483648
//        214748364
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            if (res <= Integer.MIN_VALUE || (res == Integer.MIN_VALUE)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

}
