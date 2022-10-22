package com.guagua.medium;

import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/22 16:27
 * @describe MP3光标位置
 * <p>
 * 描述
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * <p>
 * <p>
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 * <p>
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * <p>
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * <p>
 * <p>
 * <p>
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 * <p>
 * <p>
 * <p>
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 * <p>
 * <p>
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 * <p>
 * <p>
 * <p>
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 * <p>
 * <p>
 * <p>
 * 其他情况，不用翻页，只是挪动光标就行。
 * <p>
 * 数据范围：命令长度1\le s\le 100\1≤s≤100 ，歌曲数量1\le n \le 150\1≤n≤150
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 * <p>
 * 输出描述：
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 * <p>
 * 示例1
 * 输入：
 * 10
 * UUUU
 * 复制
 * 输出：
 * 7 8 9 10
 * 7
 */
public class Mp3HJ64 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String cmd = sc.next();
            parseCmd(cmd, n);
        }
    }

    public static void parseCmd(String str, int n) {
        // 页面数据大小，默认4
        int pageSize = 4;
        // 页面的歌曲大小，最大为4
        if (n < pageSize) {
            pageSize = n;
        }
        // 根据指令移动current光标，可以当作歌曲编号
        int current = 1;
        // 记录光标在页面中的位置pageIndex，即歌曲编号
        int pageIndex = 1;
        for (int i = 0; i < str.length(); i++) {
            // 上移
            if (str.charAt(i) == 'U') {
                // 特殊情况，当前光标在歌曲中第一首
                if (current == 1) {
                    // 从第一行上移，移动到最后的歌曲
                    current = n;
                    // 光标在页面的位置，
                    pageIndex = pageSize;
                    // 一般情况，即光标不在第一行
                } else {
                    // 光标上移
                    current--;
                    if (pageIndex != 1) {
                        pageIndex--;
                    }
                }
            } else {
                // 下移
                // 已经到最后一首歌曲，光标到第一首歌曲
                if (current == n) {
                    current = 1;
                    pageIndex = 1;
                } else {
                    // 非最后一行，则光标下移即可
                    current++;
                    if (pageIndex != pageSize) {
                        pageIndex++;
                    }
                }
            }
        }
        // 计算光标前后数字个数
        int next = pageSize - pageIndex;
        int pre = pageSize - 1 - next;
        // 打印页面
        StringBuilder page = new StringBuilder();

        // 从当前光标前一个元素开始向前打印
        for (int i = pre; i > 0; i--) {
            page.append(current - i).append(" ");
        }
        page.append(current).append(" ");
        for (int i = 1; i <= next; i++) {
            page.append(current + i).append(" ");
        }
        // 去除尾部空格
        System.out.println(page);
        // 打印当前光标
        System.out.println(current);
    }
}
