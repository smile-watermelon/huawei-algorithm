package com.guagua.simple;

import com.guagua.hard.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author guagua
 * @date 2022/10/25 23:31
 * @describe HJ51 输出单向链表中倒数第k个结点
 * <p>
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * <p>
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int m_nKey;
 * ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 数据范围：链表长度满足 1 \le n \le 1000 \1≤n≤1000  ， k \le n \k≤n  ，链表中数据满足 0 \le val \le 10000 \0≤val≤10000
 * <p>
 * 本题有多组样例输入。
 * <p>
 * <p>
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * <p>
 * 输出描述：
 * 输出一个整数
 * <p>
 * 示例1
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 复制
 * 输出：5
 */
public class LinkedListHJ51 {

    public static void main(String[] args) {
//        m1();
        // 练习
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            ListNode head = new ListNode();
            ListNode tmp = head;
            for (int i = 0; i < size; i++) {
                tmp.next = new ListNode(scanner.nextInt(), null);
                tmp = tmp.next;
            }
            int n = scanner.nextInt();
            ListNode target;
            for (target = head.next; size > n; size--) {
                target = target.next;
            }
            System.out.println(target == null ? 0:target.val);
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            ListNode head = new ListNode();
            ListNode tmp = head;
            for (int i = 0; i < size; i++) {
                tmp.next = new ListNode(scanner.nextInt(), null);
                tmp = tmp.next;
            }

            int target = scanner.nextInt();
            int res = getTarget(target, size, head);
            System.out.println(res);
        }
    }

    private static int getTarget(int target, int size, ListNode head) {
        ListNode node;
        // 找倒数第k个
        for (node = head.next; size > target; size--) {
            node = node.next;
        }

        return node == null ? 0 : node.val;
    }


}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}