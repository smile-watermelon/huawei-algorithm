package com.guagua.link;

import java.util.HashSet;
import java.util.Set;

/**
 * @类名: IsLoopLink
 * @描述: 判断一个链表是不是环形链表
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/31 13:39
 */
public class IsLoopLink {


    /**
     * 设置哨兵节点
     */
    private static Node first = new Node();

    /**
     * ToDo 判断一个链表中是否有没有环，只需要判断链表的下一个节点是不是出现了多次
     * 所以可以用一个 Set 集合保存链表中出现的Node，如果下一个Node 在Set 集合中已存在，说明
     * 指针指向了之前的节点，构成了环
     *
     * @param args
     */
    public static void main(String[] args) {
        Node node = new Node(1, "环节点");
        Node node1 = new Node(2, "正常节点");
        Node node2 = new Node(3, "正常节点");

        first.next = node;
        node.next = node1;
        node1.next = node2;
        // ToDo 构成了环
        node2.next = node;

        Set<Node> hashSet = new HashSet<>();

        Node tmp = first;

        Node loop = null;
        while (tmp != null) {
            Node next = tmp.next;
            if (hashSet.contains(next)) {
                loop = next;
                break;
            } else {
                hashSet.add(next);
            }

            tmp = next;
        }

        System.out.println(loop.getVal() + " " + loop.getMsg());
    }

    static class Node {
        private Integer val;

        private String msg;

        private Node next;

        public Node() {
        }

        public Node(Integer val, String msg) {
            this.val = val;
            this.msg = msg;
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

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        //        @Override
//        public String toString() {
//            return "Node{" +
//                    "val=" + val +
//                    ", next=" + next +
//                    '}';
//        }
    }
}
