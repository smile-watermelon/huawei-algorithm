package com.guagua.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @类名: LRUCache
 * @描述: leetcode 146
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/15 23:21
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        lruCache.print();

        lruCache.put(4, 4);

        lruCache.put(5, 5);

        lruCache.print();

        System.out.println(lruCache.get(5));
        lruCache.print();

        System.out.println(lruCache.get(3));

        lruCache.print();

        System.out.println(lruCache.get(4));

        lruCache.print();

        System.out.println(lruCache.get(5));

        lruCache.print();

        lruCache.put(1, 1);

        lruCache.print();

        lruCache.get(5);

        lruCache.print();



    }

    /**
     * 哨兵节点
     */
    private Node first;

    private Node last;

    /**
     * 这里增加了一个缓存来达到O(1)的时间复杂度，用空间换时间。
     */
    private Map<Integer, Node> cache = new HashMap<>();

    private Integer capacity;

    private int size;

    public Integer getSize() {
        return size;
    }

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
    }

    static class Node {
        private Integer key;
        private Integer value;

        private int hit;

        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    public int get(int key) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.hit += 1;

            /**
             * 例如 3 -》2 -》1，获取1，将1 设置为头结点
             * 1 -》3 -》2
             *
             * 例如 3 -》2 -》1，获取2，将2 设置为头结点
             * 2 -》3 -》1
             *
             */
            if (node == first) {
                cache.put(key, node);
                return first.value;
            }

            if (node == last) {
                // 将当前节点，移动到头节点
                Node tmp = first;

                Node pre = node.pre;

                first = node;
                first.next = tmp;
                first.pre = null;

                // 连接下一个节点，1 -》3
                tmp.pre = first;

                pre.next = null;

                last = pre;

            } else {
                // 将当前节点，移动到头节点
                Node tmp = first;

                Node pre = node.pre;
                Node next = node.next;

                first = node;
                first.next = tmp;
                first.pre = null;

                tmp.pre = first;
                tmp.next = next;

            }

            cache.put(key, node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.hit += 1;

            Node tmp = first;
            Node next = node.next;

            first = node;
            first.pre = null;
            first.next = tmp;

            tmp.pre = first;
            tmp.next = next;
            next.pre = tmp;

            cache.put(key, node);
        } else {
            Node node = new Node(key, value);
            node.hit += 1;

            if (first == null) {
                first = node;
                last = first;

                cache.put(key, node);
                size++;
                return;
            }

            if (size < capacity) {
                Node tmp = first;
                first = node;
                first.next = tmp;
                tmp.pre = first;

                // ToDo 重要：因为采用的是头插法，最后一个元素，应该是头元素的下一个元素
                last = tmp.next;

                size++;
                cache.put(key, node);

            } else {

                Node lastNode = cache.get(last.key);

                // 删除最近最少使用的key
                Node tmp = first;

                // 将当前新增节点作为头节点，表示最新访问的数据
                first = node;
                first.next = tmp;
                tmp.pre = first;


                last = lastNode.pre;
                last.next = null;
                // 让 GC 回收
                lastNode.pre = null;

                cache.put(key, node);
                // 删除链表的最后一个元素
                cache.remove(lastNode.key);
            }
        }
    }

    public void print() {
        if (first == null) {
            return;
        }

        Node tmp = first;

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
