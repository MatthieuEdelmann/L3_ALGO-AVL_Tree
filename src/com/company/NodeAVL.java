package com.company;


class NodeAVL {
    private NodeAVL left, right;
    private int valueNode;
    private  int height;

    // root
    public NodeAVL(int valueNode) {
        this.left = null;
        this.right = null;
        this.valueNode = valueNode;
        this.height = 1;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }

    public int getValue() {
        return valueNode;
    }

    public void setValue(int valueNode) {
        this.valueNode = valueNode;
    }

    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }
}
