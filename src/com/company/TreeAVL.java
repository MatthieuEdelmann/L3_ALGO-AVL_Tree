package com.company;

public class TreeAVL {
    public int height;
    public NodeAVL root;

    public TreeAVL() {
        this.height = 1;
        this.root = null;
    }
///////////////////////////////////////////////////////////////////////////////////
 //ajoute ou supprime le noeud de l'arbre
//OK
    public void addOrDeleteNode(NodeAVL actualNode, NodeAVL newNode){
        if (isExistNode(newNode)){  //si le noeud est presnt
            removeNode(actualNode,newNode); //on retire ce noeud
            balanceTree();//equilibrage
        }
        else    //sinon on ajoute ce noeud
            addNode(actualNode,newNode); //ajout du noeud
            balanceTree();//equillibrage
    }

///////////////////////////////////////////////////////////////////////////////////
//ajoute nouveau noeud
//OK
    public void addNode(NodeAVL actualNode, NodeAVL newNode){
        // si l'arbre est vide on insert le nouveau node comme racine
        if (isEmpty()) {
            root = newNode;
            root.setHeight(1);
            return;//Root
        }
        //verifie si le noeud a un fils gauche
        if (actualNode.getValueNode() > newNode.getValueNode()){
            if (actualNode.getLeft()==null) {
                actualNode.setLeft(newNode);
                actualNode.setHeight(actualNode.getHeight()-1);
                return;
            }
            addNode(actualNode.getLeft(), newNode);
        }
        // pareil mais pour le fils droit
        else {
            if (actualNode.getRight() == null) {
                actualNode.setRight(newNode);
                actualNode.setHeight(actualNode.getHeight()-1);
                return;
            }
            addNode(actualNode.getRight(), newNode);
        }
    }
   
///////////////////////////////////////////////////////////////////////////////////////    
//supprime un noeud
//a finir
    public void removeNode(NodeAVL actualNode, NodeAVL deleteNode){
       
    }

//////////////////////////////////////////////////////////////////////////////////////////
//réequilibrage de l'arbre
//a faire
    public void balanceTree(){
    }
    
///////////////////////////////////////////////////////////////////////////////////////    
//affichage 
//OK
    public void display(){
        NodeAVL[] binaryHeap = new NodeAVL[(int) (Math.pow(2, height))];
        binaryHeap[1] = root;
        for (int i = 1; i != (Math.pow(2, height) / 2) - 4; i++) {
            if (binaryHeap[i] != null){
                binaryHeap[i * 2] = binaryHeap[i].getLeft();
                binaryHeap[2 * i + 1] = binaryHeap[i].getRight();
            }
        }
        for (int i = 1; i != (Math.pow(2, height)) - 1; i++) {
            if(binaryHeap[i] != null)System.out.print("case n°" + i + " : " + binaryHeap[i].getValueNode() + " | ");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////
// isEmpty fonction boolean qui retourne l'etat de l'arbre
//OK
    public boolean isEmpty(){
        return (this.root==null);
    }

//////////////////////////////////////////////////////////////////////////////////
// isExistNode permet de savoir si une valeur est dans l'arbre
//OK
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
}
