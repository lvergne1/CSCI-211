/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeproject;

/**
 *
 * @author c317
 */
public class BTNode {
    private int data;
    private BTNode leftChild;
    private BTNode rightChild;
    private BTNode parent;
    
    public BTNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data=data;
    }
    public void setLeftChild(BTNode leftChild){
        this.leftChild = leftChild;
    }
    public void setRightchild(BTNode rightChild){
        this.rightChild = rightChild;
    }
    public void setParent (BTNode parent){
        this.parent = parent;
    }
    
    public int getData(){
        return this.data;
    }
    public BTNode getLeftChild(){
        return this.leftChild;
    }
    public BTNode getRightChild(){
        return this.rightChild;
    }
    public BTNode getParent(){
        return this.parent;
    }
}
