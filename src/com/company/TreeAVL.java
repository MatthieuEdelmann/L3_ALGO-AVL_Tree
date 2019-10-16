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

    public void addOrDeleteNode(NodeAVL actualNode, NodeAVL newNode){
        if (isExistNode(actualNode,newNode)){  //si le noeud est presnt
            removeNode(actualNode,newNode); //on retire ce noeud
           /* if (isBalanceTree(newNode) == false) {
                //equilibrage
            }*/
        }
        else {   //sinon on ajoute ce noeud
            addNode(actualNode,newNode); //ajout du noeud
            /* if (isBalanceTree(newNode) == false) {
            //equilibrage
            } */
        }
    }

///////////////////////////////////////////////////////////////////////////////////
//ajoute nouveau noeud

    public void addNode(NodeAVL actualNode, NodeAVL newNode){
        // si l'arbre est vide on insert le nouveau node comme racine
        if (isEmpty()) {
            root = newNode;
            root.setHeight(1);
            return;//Root
        }
        //verifie si le noeud a un fils gauche
        if (actualNode.getValue() > newNode.getValue()){
            if (actualNode.getLeft()==null) {
                actualNode.setLeft(newNode);
                actualNode.setHeight(actualNode.getHeight()-1);
                height++;
                return;
            }
            addNode(actualNode.getLeft(), newNode);
        }
        // verifie si le noeud a un fils droit
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

    public void removeNode(NodeAVL actualNode, NodeAVL deleteNode) {
        if (actualNode.getValue() == deleteNode.getValue()) {
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
// vérifie le réequilibrage de l'arbre
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

    public void display(){
        NodeAVL[] binaryHeap = new NodeAVL[(int) (Math.pow(2, height))];
        binaryHeap[1] = root;
        for (int i = 1; i != (Math.pow(2, height) / 2); i++) {
            if (binaryHeap[i] != null){
                binaryHeap[i * 2] = binaryHeap[i].getLeft();
                binaryHeap[2 * i + 1] = binaryHeap[i].getRight();
            }
        }
        for (int i = 1; i != (Math.pow(2, height)) ; i++) {
            if(binaryHeap[i] != null)System.out.print("case n°" + i + " : " + binaryHeap[i].getValue() + " | ");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////
// isEmpty fonction boolean qui retourne l'etat de l'arbre

    public boolean isEmpty(){
        return (this.root==null);
    }

//////////////////////////////////////////////////////////////////////////////////
// isExistNode permet de savoir si une valeur est dans l'arbre

    public boolean isExistNode(NodeAVL actualNode, NodeAVL n) {
        if (actualNode == null) return false;
        if (actualNode.getValue() == n.getValue()) return true;
        if (actualNode.getLeft() == null && actualNode.getRight() == null) {
            return false;
        }
        if (actualNode.getLeft() != null){
            if (n.getValue() == actualNode.getLeft().getValue()) return true;
        }

        if (actualNode.getRight() != null){
            if (n.getValue() == actualNode.getRight().getValue()) return true;
        }

        if (actualNode.getRight() !=null || actualNode .getLeft() != null) return false;
        if (n.getValue() < actualNode.getRight().getValue()) {
            return isExistNode(actualNode.getLeft(),n);
        }
        return isExistNode(actualNode.getRight(), n);
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
///////////////////////////////////////////////////////////////////////////////////////////

    public NodeAVL parentOfNode (NodeAVL cursorNode, NodeAVL actualNode){
        if (cursorNode.getLeft() != null){
            if(cursorNode.getLeft().getValue() == actualNode.getValue()){
                return cursorNode;
            }
            if (cursorNode.getLeft().getValue() > actualNode.getValue()){
                parentOfNode(cursorNode.getLeft(),actualNode);
            }
        }

        if (cursorNode.getRight() != null){
            if(cursorNode.getRight().getValue() == actualNode.getValue()){
                return cursorNode;
            }
            if (cursorNode.getRight().getValue() < actualNode.getValue()){
                parentOfNode(cursorNode.getRight(),actualNode);
            }
        }
        return null;
    }
///////////////////////////////////////////////////////////////////////////////////////////
}
