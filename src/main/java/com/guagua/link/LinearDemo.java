package com.guagua.link;

/**
 * 单链表
 * todo 待完善
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
//        linear.print();



    }


    static class Linear {

        Node first;

//        Node last;

        /**
         * 添加
         *
         * @param value
         */
        public void add(int value) {
            Node newNode = new Node(value);
            if (first == null) {
                first = newNode;
                return;
//                last = first;
            }
//            else {
//                if (last != null) {
//                    last.next = node;
//                }
//            }
            Node tmp = first;
            while (tmp.next != null) {

            }

        }

//        public Node getLast() {
//            return last;
//        }

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
            if (first.value == value) {
                first = first.next;
                return;
            }
            Node tmp = first;
            while (tmp.next != null) {
                if (tmp.next.value == value) {
                    tmp.next = tmp.next.next;
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
