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
public class BT {
    private int height;
    private int size;
    private BTNode rootNode;
    
    public BT (){
        this.height = 0;
        this.size = 0;
    }
    
    public BT(int[] data){
        
    }
    
    public void addNode(int data){
        BTNode newNode = new BTNode(data);
        if (this.rootNode == null){
            rootNode = newNode;
        }
        else{
            if (height)
        }
    }
    
    
}
