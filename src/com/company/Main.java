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
    }
}

