package com.company;

public class Main {

    public static void main(String[] args) {
        TreeAVL tree = new TreeAVL();
        tree.addOrDeleteNode(tree.root, new NodeAVL(50));
        tree.addOrDeleteNode(tree.root, new NodeAVL(45));
        tree.addOrDeleteNode(tree.root, new NodeAVL(56));
        tree.addOrDeleteNode(tree.root, new NodeAVL(5));
        tree.addOrDeleteNode(tree.root, new NodeAVL(54));
        tree.addOrDeleteNode(tree.root, new NodeAVL(54));
        tree.addOrDeleteNode(tree.root, new NodeAVL(57));
        tree.addOrDeleteNode(tree.root, new NodeAVL(58));
        tree.display();
    }
}
