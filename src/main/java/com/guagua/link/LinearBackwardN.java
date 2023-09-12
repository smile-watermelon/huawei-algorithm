package com.guagua.link;

/**
 * @类名: LinearBackwardN
 * @描述: 计数法 - 求单链表的倒数第n个节点
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/9/12 20:39
 */
public class LinearBackwardN {

    private Node first;

    /**
     * 链表中元素的个数
     */
    private int size;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        LinearBackwardN linear = new LinearBackwardN();

        linear.addNode(node1);
        linear.addNode(node2);
        linear.addNode(node3);
        linear.addNode(node4);
        linear.addNode(node5);

        int size = linear.size;
        // 求倒数第n个节点
        int n = 1;

        /********* 算法如下 ***********/
        Node tmp = linear.first;
        Node nodeN;
        int counter = 0;
        while (true) {
            // 倒数第N个元素是第一个元素
            if (n == size) {
                nodeN = tmp;
                break;
            }
            // 倒数第n个元素，因为counter计数是从0开始，所以要-1，
            if (tmp != null && counter == size - n - 1) {
                nodeN = tmp.next;
                break;
            }
            // 循环计数
            if (tmp != null && tmp.next != null) {
                tmp = tmp.next;
                counter++;
            }
        }

        System.out.println(nodeN.getVal());
    }

    void addNode(Node node) {
        if (first == null) {
            first = node;
            size++;
        } else {
            Node tmp = first;
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

    static class Node {
        private Integer val;

        private Node next;

        public Node(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
