package com.guagua.link;

/**
 * @类名: LinearBackwardNDoublePointer
 * @描述: 双指针 - 求链表的第n个节点
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/9/12 21:38
 */
public class LinearBackwardNDoublePointer<T> {

    private Node<T> first;
    private int size;

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        LinearBackwardNDoublePointer<Integer> linear = new LinearBackwardNDoublePointer<>();

        linear.addNode(node1);
        linear.addNode(node2);
        linear.addNode(node3);
        linear.addNode(node4);
        linear.addNode(node5);


        // 求倒数第n个节点
        int n = 2;
        // 第一个指针
        Node<Integer> p1 = linear.first;
        // 第二个指针
        Node<Integer> p2 = linear.first;

        /********** 方式1 ***********/
        // 方式1：先让p1 往前走 n 次
        Node<Integer> target;
//        for (int i = 0; i < n; i++) {
//            p1 = p1.next;
//        }

        // 方式1：这里p1 走到最后一个节点的时候，还会再执行一次，此时 p2 刚好到达倒数第n的位置
        // ToDo 但是这样不太好理解，很容易忽略掉p1走到最后一个位置，while 循环还会再执行一次

//        while (p1 != null) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }

        /********** 方式2 ***********/

        // 方式2：将p1 指向倒数第n个位置的前一个
        for (int i = 0; i < n - 1; i++) {
            p1 = p1.next;
        }

        // 方式2：让p1 走到最后一个位置，此时 p2 刚好停留在倒数第n个节点
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        target = p2;
        System.out.println(target.getVal());

    }

    void addNode(Node<T> node) {
        if (first == null) {
            first = node;
            size++;
        } else {
            Node<T> tmp = first;
            while (true) {
                if (tmp.next == null) {
                    tmp.next = node;
                    size++;
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    static class Node<T> {
        private T val;

        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
