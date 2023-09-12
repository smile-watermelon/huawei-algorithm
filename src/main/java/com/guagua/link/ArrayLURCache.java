package com.guagua.link;

/**
 * @类名: ArrayLURCache
 * @描述: todo 待完善
 * @作者: Mabin
 * @版本: 1.0
 * @创建时间: 2023/8/23 21:21
 * @修改历史: （列表如下）
 */
public class ArrayLURCache {


    private Object[] cache = {};

    private int capacity;

    private int size;


    public ArrayLURCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {

    }


    public void add(int val) {
        Node node = new Node(val);
        if (size < capacity) {
            cache[size++] = node;
        } else {
            //
        }

    }

    static class Node {
        private Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }


}
