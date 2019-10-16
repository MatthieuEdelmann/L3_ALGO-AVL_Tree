package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TreeAVL tree = new TreeAVL();
        Integer value;
        Scanner sc;
        do {
            System.out.println();
            System.out.println();
            System.out.print("ajouter valeur : ");
            sc = new Scanner(System.in);
            value = sc.nextInt();
            tree.addOrDeleteNode(tree.root, new NodeAVL(value));
            tree.display();
        }while (true);
/*
        tree.addOrDeleteNode(tree.root, new NodeAVL(45));
        tree.addOrDeleteNode(tree.root, new NodeAVL(56));
        tree.addOrDeleteNode(tree.root, new NodeAVL(5));
        tree.addOrDeleteNode(tree.root, new NodeAVL(54));
        tree.addOrDeleteNode(tree.root, new NodeAVL(54));
        tree.addOrDeleteNode(tree.root, new NodeAVL(57));
        tree.addOrDeleteNode(tree.root, new NodeAVL(58));
        tree.display();
        tree.removeNode(tree.root, new NodeAVL(57));
        System.out.println();
        tree.display();*/
    }
}
