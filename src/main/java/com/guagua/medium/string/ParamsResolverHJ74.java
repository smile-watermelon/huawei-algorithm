package com.guagua.medium.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/20 23:17
 * @describe 参数解析
 * <p>
 * 描述
 * 在命令行输入如下命令：
 * <p>
 * xcopy /s c:\\ d:\\e，
 * <p>
 * 各个参数如下：
 * <p>
 * 参数1：命令字xcopy
 * <p>
 * 参数2：字符串/s
 * <p>
 * 参数3：字符串c:\\
 * <p>
 * 参数4: 字符串d:\\e
 * <p>
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * <p>
 * <p>
 * 解析规则：
 * <p>
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，
 * 参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * <p>
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 数据范围：字符串长度：1\le s\le 1000\1≤s≤1000
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述：
 * 输出参数个数，分解后的参数，每个参数都独占一行
 * <p>
 * 示例1
 * 输入：
 * xcopy /s c:\\ d:\\e
 * 复制
 * 输出：
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\e
 */
public class ParamsResolverHJ74 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();

            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList();
            boolean flag = false;
            for (int i = 0; i < nextLine.length(); i++) {
                char c = nextLine.charAt(i);

                if (String.valueOf(c).equals("\"")) { // 双引号是成对出现的，作为一个开关，防止在双引号里有空格导致错误
                    flag = !flag;
                    continue;
                }

                if (String.valueOf(c).equals(" ") && !flag) {

                    arrayList.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder(); // 每次遇到空格说明是一个参数，新建构建器保存下一个新的参数
                } else {
                    stringBuilder.append(c);
                }

            }
            arrayList.add(stringBuilder.toString());
            System.out.println(arrayList.size());
            for (String s : arrayList) {
                System.out.println(s);
            }
        }
    }
}
