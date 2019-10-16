package com.company;
import static java.lang.Float.max;

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
        if (isExistNode(actualNode,newNode)){  //si le noeud est presnt
            removeNode(actualNode,newNode); //on retire ce noeud
           /* if (isBalanceTree(newNode) == false) {
                //equilibrage
            }*/
        }
        else    //sinon on ajoute ce noeud
            addNode(actualNode,newNode); //ajout du noeud
            /* if (isBalanceTree(newNode) == false) {
            //equilibrage
            } */
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
                height++;
                return;
            }
            addNode(actualNode.getLeft(), newNode);
        }
        // pareil mais pour le fils droit
        else {
            if (actualNode.getRight() == null) {
                actualNode.setRight(newNode);
                actualNode.setHeight(actualNode.getHeight()-1);
                height++;
                return;
            }
            addNode(actualNode.getRight(), newNode);
        }
    }
   
///////////////////////////////////////////////////////////////////////////////////////    
//supprime un noeud
//a finir
    public void removeNode(NodeAVL actualNode, NodeAVL deleteNode) {
        if (actualNode.getValueNode() == deleteNode.getValueNode()) {
            if (actualNode.getLeft() == null && actualNode.getRight() == null) {
                actualNode = null;
                return;
            }
        }
        NodeAVL parentOfActualNode = root;
        parentOfActualNode = parentOfNode(parentOfActualNode, actualNode);
        if (actualNode.getLeft() == null) {
            parentOfActualNode.setRight(actualNode);
            return;
        }
        if (actualNode.getRight() == null) {
            parentOfActualNode.setLeft(actualNode);
            return;
        }

        actualNode = getMinRight(actualNode.getRight());

    }

//////////////////////////////////////////////////////////////////////////////////////////
//réequilibrage de l'arbre
//OK
    public boolean isBalanceTree(NodeAVL n){
        if (n == null){
            return true;
        }

        int i = (n.getRight().getHeight() - n.getLeft().getHeight());
        if (i <= 1)
                return true;
            else
                return false;
    }
///////////////////////////////////////////////////////////////////////////////////////
     public NodeAVL balanceL(NodeAVL n){
        NodeAVL y = n.getRight();
        NodeAVL z = y.getLeft();

        y.setLeft(n);
        n.setRight(z);

        n.setHeight((int) (max(n.getLeft().getHeight(),n.getRight().getHeight())+1));
        y.setHeight((int) (max(y.getLeft().getHeight(),y.getRight().getHeight())+1));

        return y;
    }
    
    public NodeAVL balanceR(NodeAVL y){
        NodeAVL x = y.getLeft();
        NodeAVL z = x.getRight();

        x.setLeft(y);
        y.setRight(z);

        y.setHeight((int) (max(y.getLeft().getHeight(),y.getRight().getHeight())+1));
        x.setHeight((int) (max(x.getLeft().getHeight(),x.getRight().getHeight())+1));

        return x;
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
    public boolean isExistNode(NodeAVL actualNode, NodeAVL n) {
        if (actualNode == null) return false;
        if (actualNode.getValueNode() == n.getValueNode()) return true;
        if (n == null || (actualNode.getLeft() == null && actualNode.getRight() == null) ) {
            return false;
        }
        if (actualNode.getLeft() != null){
            if (n.getValueNode() == actualNode.getLeft().getValueNode()) return true;
        }

        if (actualNode.getRight() != null){
            if (n.getValueNode() == actualNode.getRight().getValueNode()) return true;
        }

        if (actualNode.getRight() !=null || actualNode .getLeft() != null) return false;
        if (n.getValueNode() < actualNode.getRight().getValueNode()) {
            return isExistNode(actualNode.getLeft(),n);
        }
        return isExistNode(actualNode.getRight(), n);
    }
///////////////////////////////////////////////////////////////////////////////////////////

    public NodeAVL parentOfNode (NodeAVL cursorNode, NodeAVL actualNode){
        if (cursorNode.getLeft() != null){
            if(cursorNode.getLeft().getValueNode() == actualNode.getValueNode()){
                return cursorNode;
            }
            if (cursorNode.getLeft().getValueNode() > actualNode.getValueNode()){
                parentOfNode(cursorNode.getLeft(),actualNode);
            }
        }

        if (cursorNode.getRight() != null){
            if(cursorNode.getRight().getValueNode() == actualNode.getValueNode()){
                return cursorNode;
            }
            if (cursorNode.getRight().getValueNode() < actualNode.getValueNode()){
                parentOfNode(cursorNode.getRight(),actualNode);
            }
        }
        return null;
    }
///////////////////////////////////////////////////////////////////////////////////////////

    public NodeAVL getMinRight(NodeAVL actualNode){
        NodeAVL tmp;
        if (actualNode.getLeft() == null){
            tmp = actualNode;
            if(actualNode.getRight() != null){
                actualNode = actualNode.getRight();
            }
            return actualNode;
        } else {
            getMinRight(actualNode.getLeft());
        }
        return null;
    }
}
