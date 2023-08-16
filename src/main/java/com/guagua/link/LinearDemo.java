package com.guagua.link;

/**
 * 单链表
 *
 * @author guagua
 * @date 2023/2/21 14:24
 * @describe
 */
public class LinearDemo {

    public static void main(String[] args) {
        Linear linear = new Linear();
        linear.add(1);
        linear.add(2);
        linear.add(3);
        linear.add(4);

        System.out.println(linear);

        linear.delete(2);
        System.out.println(linear);

        linear.add(5);
        System.out.println(linear);

        System.out.println(linear.getFirst().value);

        System.out.println(linear.getLast().value);

        System.out.println("size=" + linear.getSize());

    }


    static class Linear {

        private Node first;

        private int size;

        /**
         * 添加
         *
         * @param value
         */
        public void add(int value) {
            Node newNode = new Node(value);
            if (first == null) {
                first = newNode;
                size++;
                return;
            }

            Node tmp = first;
            while (true) {
                if (tmp.next == null) {
                    tmp.next = newNode;
                    size++;
                    break;
                } else {
                    tmp = tmp.next;
                }
            }
        }

        public Integer getSize() {
            return size;
        }

        public Node getFirst() {
            return first;
        }

        public Node getLast() {
            if (first == null) {
                return null;
            }
            Node tmp = first;
            while (true) {
                if (tmp.next == null) {
                    return tmp;
                } else {
                    tmp = tmp.next;
                }
            }
        }

        public void print() {
            if (first != null) {
                Node tmp = first;
                while (tmp.next != null) {
                    System.out.println(tmp.value);
                    System.out.println(tmp.next.value);
                    tmp = tmp.next;
                }
            }
        }

        /**
         * 删除
         *
         * @param value
         */
        public void delete(int value) {
            if (first == null) {
                return;
            }
            Node tmp = first;
            if (tmp.value == value) {
                first = tmp.next;
                // GC 回收
                tmp.next = null;
                size--;
                return;
            }
            while (tmp.next != null) {
                if (tmp.next.value == value) {
                    tmp.next = tmp.next.next;
                    size--;
                    break;
                }
            }

        }

        @Override
        public String toString() {
            return "Linear{" +
                    "first=" + first +
//                    ", last=" + last +
                    '}';
        }
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
