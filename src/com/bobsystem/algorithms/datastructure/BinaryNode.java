package com.bobsystem.algorithms.datastructure;

public class BinaryNode<T extends Comparable<? super T>> {

    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public void store(T value) {

        if (this.value == null) {
            this.value = value;
            return;
        }
        if (value.compareTo(this.value) == -1) {

            if (left == null) {
                left = new BinaryNode<T>();
                left.value = value;

                return;
            }
            left.store(value);
            return;
        }
        if (value.compareTo(this.value) == 1) {

            if (right == null) {
                right = new BinaryNode<T>();
                right.value = value;

                return;
            }
            right.store(value);
        }
    }

    public boolean find(T value) {

        System.out.println("find: " + this.value);

        if(value == this.value) {
            return true;
        }
        if (value.compareTo(this.value) == 1) {
        //if (value > this.value) {

            if(right == null) return false;

            return right.find(value);
        }

        if(left == null) return false;

        return left.find(value);
    }

    //// 前序
    //public void preList() {
    //
    //    System.out.print(this.value + ",");
    //
    //    if(left != null) left.preList();
    //
    //    if(right != null) right.preList();
    //}

    // 中序
    public void middleList() {

        if(left != null) left.middleList();

        System.out.print(this.value + ",");

        if(right != null) right.middleList();
    }

    //// 后序
    //public void afterList() {
    //
    //    if(left != null) left.middleList();
    //
    //    if(right != null) right.middleList();
    //
    //    System.out.print(this.value + ",");
    //}
}
