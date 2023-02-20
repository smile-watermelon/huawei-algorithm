package com.guagua.tree;

import java.time.OffsetDateTime;

/**
 * @author guagua
 * @date 2023/2/19 15:09
 * @describe
 */
public class BinarySearch {

    public static void main(String[] args) {

        BinarySortedSearch search = new BinarySortedSearch();
        int[] nums = {4, 1, 2, 7, 9, 6};

        for (int i = 0; i < nums.length; i++) {
            search.add(new BinarySortedSearch.Node(nums[i]));
        }

//        BinarySortedSearch.Node result = search.search(7);
//        System.out.println(result);
//        BinarySortedSearch.Node parent = search.searchParent(2);
//        System.out.println(parent);

//        search.delete(2);
//        search.infixOrder();

//        search.preOrder();
//        System.out.println("-----------前序遍历----------");

//        search.infixOrder();
//        System.out.println("-----------中序序遍历----------");

//        search.afterOrder();
//        System.out.println("-----------后序序遍历----------");

    }


}


class BinarySortedSearch {
    Node root;

    public void add(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            root.add(node);
        }
    }

    public void delete(int value) {
        if (this.root == null) {
            return;
        }

        Node target = search(value);
        if (target == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        Node parent = searchParent(value);
        if (target.left == null && target.right == null) {
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;

            }
        }

    }

    /**
     * 查找
     */

    public Node search(int value) {
        if (this.root == null) {
            return null;
        }
        return this.root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return this.root.searchParent(value);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void afterOrder() {
        if (this.root != null) {
            this.root.afterOrder();
        }
    }


    static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (node.value < this.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }


        /**
         * 查找节点
         */
        public Node search(int targetValue) {
            if (this.value == targetValue) {
                return this;
            } else if (targetValue < this.value) {
                if (this.left != null) {
                    return this.left.search(targetValue);
                }
            } else {
                if (this.right != null) {
                    return this.right.search(targetValue);
                }
            }
            return null;
        }

        /**
         * 查找父节点
         */

        public Node searchParent(int targetValue) {
            if (this.left != null && this.left.value == targetValue) {
                return this;
            } else if (this.right != null && this.right.value == targetValue) {
                return this;
            } else {
                if (targetValue < this.value && this.left != null) {
                    return this.left.searchParent(targetValue);
                } else if (targetValue > this.value && this.right != null) {
                    return this.right.searchParent(targetValue);
                }
            }
            return null;
        }

        /**
         * 前序遍历，根-左-右
         */
        public void preOrder() {
            System.err.println(this.value);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历，左-根-右
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.err.println(this.value);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void afterOrder() {
            if (this.left != null) {
                this.left.afterOrder();
            }
            if (this.right != null) {
                this.right.afterOrder();
            }
            System.out.println(this.value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }


    }
}