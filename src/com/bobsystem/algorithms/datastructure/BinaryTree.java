package com.bobsystem.algorithms.datastructure;

/**
 * 二叉查找树
 *   这里实现一个非线程安全的示例。
 * 二叉查找树的中序可以将树中所有值升序打印。
 *   原理是：
 *     比当前节点小的节点一定出现在当前节点的左侧，只是层级的高度不同。
 *     当左侧没有节点时，一定找到了最小值。
 */
public class BinaryTree<T extends Comparable<? super T>> {

    private BinaryNode current;

    //region member methods
    //region store()
    public void store(T value) {
        BinaryNode current = this.current;
        if (current == null) {
            current = new BinaryNode();
            this.current = current;
        }
        store(current, value);
    }

    private void store(BinaryNode current, T value) {
        T currentValue = current.value;
        if (currentValue == null) {
            current.value = value;
            return;
        }
        int com = value.compareTo(currentValue);
        if (com <= 0) {
            BinaryNode left = current.left;
            if (left == null) {
                left = new BinaryNode(value);
                current.left = left;
                return;
            }
            store(left, value);
            return;
        }
        //if (com > 0) {
            BinaryNode right = current.right;
            if (right == null) {
                right = new BinaryNode(value);
                current.right = right;
                return;
            }
            store(right, value);
        //}
    }
    //endregion store()

    //region find()
    public boolean find(T value) {
        System.out.println("finding value: " + value);
        return find(this.current, value);
    }

    private boolean find(BinaryNode current, T value) {
        T currentValue = current.value;

        System.out.println("finding, value to compare: " + currentValue);

        if (value == currentValue) return true;
        if (value.compareTo(currentValue) > 0) {
            BinaryNode right = current.right;
            if(right == null) return false;
            return find(right, value);
        }
        BinaryNode left = current.left;
        if(left == null) return false;
        return find(left, value);
    }
    //endregion find()

    //region middleList()
    /**
     * 中序，中序可以将树中所有值升序打印。
     *   原理是：
     *     比当前节点小的节点一定出现在当前节点的左侧，只是层级的高度不同。
     *     当左侧没有节点时，一定找到了最小值。
     */
    public void middleList() {
        middleList(false);
    }

    public void middleList(boolean descending) {
        System.out.println("print tree middle list. 中序可以将树中所有值升序打印。descending = " + descending);
        middleList(this.current, descending);
    }

    private void middleList(BinaryNode current, boolean descending) {
        if (current == null) return;

        BinaryNode smaller = current.left;
        BinaryNode bigger = current.right;
        if (descending) {
            BinaryNode temp = smaller;
            smaller = bigger;
            bigger = temp;
        }

        if(smaller != null) middleList(smaller, descending);

        System.out.print(current.value + ", ");

        if(bigger != null) middleList(bigger, descending);
    }
    //endregion middleList()

    ////region preList()
    ///**
    // * 前序
    // */
    //public void preList() {
    //    System.out.println("print tree pre list.");
    //    preList(this.current);
    //}
    //
    //private void preList(BinaryNode current) {
    //    if (current == null) return;
    //    System.out.print(current.value + ", ");
    //
    //    BinaryNode left = current.left;
    //    if(left != null) preList(left);
    //
    //    BinaryNode right = current.right;
    //    if(right != null) preList(right);
    //}
    ////endregion preList()
    //
    ////region afterList()
    ///**
    // * 后序
    // */
    //public void afterList() {
    //    System.out.println("print tree after list.");
    //    afterList(this.current);
    //}
    //
    //public void afterList(BinaryNode current) {
    //    if (current == null) return;
    //
    //    BinaryNode left = current.left;
    //    if(left != null) afterList(left);
    //
    //    BinaryNode right = current.right;
    //    if(right != null) afterList(right);
    //
    //    System.out.print(current.value + ", ");
    //}
    ////endregion afterList()
    //endregion member methods

    //region inner class
    private class BinaryNode {

        //region property fields
        private T value;
        private BinaryNode left;
        private BinaryNode right;
        //endregion property fields

        //region constructors
        public BinaryNode() { }

        public BinaryNode(T value) {
            store(this, value);
        }
        //endregion constructors
    }
    //endregion inner class
}
