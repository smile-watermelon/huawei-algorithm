package com.guagua.link;

import java.nio.file.Path;
import java.security.Key;

/**
 * @类名: 双向链表
 * @描述:
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/15 21:59
 * @修改历史: （列表如下）
 * 时间    修改人   修改原因  修改内容
 * XXX     XXXX      XXXXX    源文件那个方法的那个代码块
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();

        System.out.println(list.getFirst().value);
        System.out.println(list.getLast().value);
        System.out.println(list.getSize());

        System.out.println(list.delete(1).value);
        list.print();

        list.add(4);
        list.add(5);

        list.print();

        list.delete(3);

        list.print();

        System.out.println(list.size);

    }

    static class LinkedList {
        private Node first = new Node();

        private int size;

        public void add(int value) {
            Node node = new Node(value);

            if (first.next == null) {
                first.next = node;
                node.pre = first;
                size++;
                return;
            }
            Node tmp = first;
            while (true) {
                if (tmp.next == null) {
                    tmp.next = node;
                    node.pre = tmp;
                    size++;
                    break;
                } else {
                    tmp = tmp.next;
                }
            }
        }


        public Node delete(int value) {
            Node tmp = first.next;

            if (tmp.value == value) {
                first.next = tmp.next;
                tmp.next.pre = first;

                tmp.pre = null;
                tmp.next = null;
                size--;
                return tmp;
            }


            Node current = null;
            while (true) {
                // 遍历到链表的末尾没有找到元素，结束遍历
                if (tmp.next == null) {
                    return null;
                }
                if (tmp.next.value == value) {
                    current = tmp.next;

                    tmp.next = tmp.next.next;
                    tmp.next.next.pre = tmp;

                    current.next = null;
                    current.pre = null;
                    size--;
                    return tmp.next;
                } else {
                    tmp = tmp.next;
                }
            }
        }

        public int getSize() {
            return size;
        }

        /**
         * 获取链表第一个元素
         * @return
         */
        public Node getFirst() {
            if (first.next != null) {
                return first.next;
            }
            return null;
        }

        /**
         * 获取链表最后一个元素
         * @return
         */
        public Node getLast() {
            Node tmp = first;

            while (true) {
                if (tmp.next != null) {
                    tmp = tmp.next;
                } else {
                    return tmp;
                }
            }
        }

        public void print() {
            Node tmp = first.next;

            while (true) {
                if (tmp.next != null) {
                    System.out.print(tmp.value + " -》");
                    tmp = tmp.next;
                } else {
                    System.out.print(tmp.value);
                    System.out.println();
                    break;
                }
            }
        }
    }

    static class Node {
        private Integer value;

        private Node pre;

        private Node next;

        public Node() {
        }

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }
}
