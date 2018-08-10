/*
 *Project 4 Stack Project
 *CSCI 211
 *Last modified 10/29 @ 4:00 PM
 *@author Leo Vergnetti
 */
package stackproject;

/**
 * StackElement class is to designed to be used with Stack class for StackProject.
 * class has data members and methods to be used as elements in a stack. StackElement
 * objects must be created with a String containing the data to be contained in
 * the stack element.  
 */
public class StackElement {
    //datamembers
    private String data;    //String to hold data
    private StackElement next;  //Pointer to next Element
    
    //methods
    //constructor: must be initialized with a String containing the data
    public StackElement(String data){
        setData(data);  //call setData method to add data to datamember.
    }//end Constructor
    
    //mutator for String data contained in this element
    public void setData(String data){
        this.data = data;   //set value of datamember data to argument
    }//end setData
    
    //mutator for pointer to next element in list
    public void setNext(StackElement next){
        this.next = next;   //set value of datamember next to argumnet
    }//end setNext
    
    //accessor for String data datamember
    public String getData(){
        return this.data;   //return the String data
    }//end getData
    
    //accessor for pointer to next element
    public StackElement getNext(){
        return this.next;   //return pointer to next element in stack
    }   //end getNext
}//end class
