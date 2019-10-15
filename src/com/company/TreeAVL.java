package com.company;

import java.util.ArrayList;
import java.util.List;

public class TreeAVL {
    public int height;
    public NodeAVL root;

    public TreeAVL() {
        this.height = 0;
        this.root = null;
    }




    //
    public boolean isExistNode(NodeAVL n) {
        if (n == null) {
            return false;
        }
        if (n.getValueNode() == n.getLeft().getValueNode() || n.getValueNode() == n.getRight().getValueNode()) {
            return true;
        }

        if (n.getValueNode() < n.getRight().getValueNode()) {
            return isExistNode(n.getLeft());
        }

        return isExistNode(n.getRight());
    }


    /*// retourne la hauteur de l'arbre
    // a finir
    public int getHeight(TreeAVL a) {
        int result = 0;
        if (a != null) {
            int heightL = getHeight(a.);//
            int heightR = getHeight(a.);//
            int maxHeightSoon = (heightL > heightR ? heightL : heightR);
            result = 1 + maxHeightSoon;
            a.height = result;
        }
        return result;
    }*/

    public void addOoDeleteNode(NodeAVL actualNode, NodeAVL newNode){
        if (actualNode == null) {
            root = newNode;
            height = 1;
            return;//Root
        } else if (actualNode.getValueNode() == newNode.getValueNode()) {
            //delete
        }
        else if (actualNode.getValueNode() > newNode.getValueNode()){
            if (actualNode.getLeft()==null) {
                actualNode.setLeft(newNode);
                height++;
                return;
            }
            addOoDeleteNode(actualNode.getLeft(), newNode);
        }
        else {
            if (actualNode.getRight()==null) {
                actualNode.setRight(newNode);
                height++;
                return;
            }
            addOoDeleteNode(actualNode.getRight(), newNode);
        }
    }

    //public static removeNode(NodeAVL n){

    //}

    public void display(NodeAVL actualNode){
        //System.out.print(actualNode.getValueNode()+" ");
        if (actualNode.getRight() == null && actualNode.getLeft() == null);
        else{
            if (actualNode.getLeft() != null){
                display(actualNode.getLeft());
                System.out.print(actualNode.getLeft().getValueNode()+" ");
            } else System.out.print("left_null ");

            if (actualNode.getRight() != null){
                display(actualNode.getRight());
                System.out.print(actualNode.getRight().getValueNode()+" ");
            } else System.out.print("right_null ");
        }
        return;
    }

    /*public void display(NodeAVL actualNode){
        //System.out.print(actualNode.getValueNode()+" ");
        boolean leftNodeIsExist = false, rightNodeIsExist = false;
        if (actualNode.getLeft() != null){
            leftNodeIsExist = true;
            System.out.print(actualNode.getLeft().getValueNode()+" ");
        } else System.out.print("null ");
        if (actualNode.getRight() != null){
            rightNodeIsExist = true;
            System.out.print(actualNode.getRight().getValueNode()+" ");
        } else System.out.print("null ");

        if (leftNodeIsExist) display(actualNode.getLeft());
        if (rightNodeIsExist) display(actualNode.getRight());
        return;
    }*/

}
