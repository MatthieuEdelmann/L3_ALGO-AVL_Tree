package com.company;

public class Main {

    public static void main(String[] args) {
        TreeAVL tree = new TreeAVL();
            tree.addOoDeleteNode(tree.root, new NodeAVL(50));
            tree.addOoDeleteNode(tree.root, new NodeAVL(45));
            tree.addOoDeleteNode(tree.root, new NodeAVL(56));
            tree.addOoDeleteNode(tree.root, new NodeAVL(5));
            tree.addOoDeleteNode(tree.root, new NodeAVL(54));
        System.out.println(tree.root.getValueNode());
            tree.display(tree.root);
    }
}
