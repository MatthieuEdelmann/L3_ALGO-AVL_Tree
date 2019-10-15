package com.company;

public class TreeAVL {
    public int height;
    public NodeAVL root;

    public TreeAVL() {
        this.height = 1;
        this.root = null;
    }

    //ajoute ou supprime le noeud de l'arbre
    public void addOrDeleteNode(NodeAVL actualNode, NodeAVL newNode){
        if (isExistNode(newNode)){  //si le noeud est presnt
            removeNode(actualNode,newNode); //on retire ce noeud
            //equilibrage
        }
        else    //sinon on ajoute ce noeud
            addNode(actualNode,newNode); //ajout du noeud
            //equillibrage
    }

    public void removeNode(NodeAVL actualNode, NodeAVL deleteNode){
        if (deleteNode.getValueNode() < actualNode.getValueNode()){
            //deleteNode.setLeft(removeNode(actualNode,deleteNode.getLeft()));
        }
        else if (deleteNode.getValueNode() > actualNode.getValueNode()){
            //deleteNode.setRight(removeNode(actualNode,deleteNode.getRight()));
            ////
        }
        else if (actualNode.getLeft()==null){
            height--;
            actualNode.setRight(null);
        }
        else if (actualNode.getRight()==null){
            height--;
            actualNode.setLeft(null);
        }
    }

    public void addNode(NodeAVL actualNode, NodeAVL newNode){
        // si l'arbre est vide on insert le nouveau node comme racine
        if (isEmpty()) {
            actualNode = newNode;
            height = 1;
            return;//Root
        }
        //verifie si le noeud a un fils gauche
        if (actualNode.getValueNode() > newNode.getValueNode()){
            if (actualNode.getLeft()==null) {
                actualNode.setLeft(newNode);
                height++;
                return;
            }
            addNode(actualNode.getLeft(), newNode);
        }
        // pareil mais pour le fils droit
        else {
            if (actualNode.getRight() == null) {
                actualNode.setRight(newNode);
                height++;
                return;
            }

            addNode(actualNode.getRight(), newNode);
        }
    }

    public void balanceTree(TreeAVL a){

    }
//affiche
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


    // isEmpty fonction boolean qui retourne l'etat de l'arbre
    public boolean isEmpty(){

        return (this.root==null);
    }

// isExistNode permet de savoir si une valeur est dans l'arbre
    public boolean isExistNode(NodeAVL n) {
        if (n == null) {
            return false;
        }
        if (n.getValueNode() == root.getLeft().getValueNode() || n.getValueNode() == root.getRight().getValueNode()) {
            return true;
        }

        if (n.getValueNode() < root.getRight().getValueNode()) {
            return isExistNode(root.getLeft());
        }

        return isExistNode(root.getRight());
    }

    // retourne la hauteur de l'arbre
    public int getHeight(TreeAVL a) {

        return height;
    }




}
