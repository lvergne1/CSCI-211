/*
 *Project 4 Stack Project
 *CSCI 211
 *Last modified 10/29 @ 4:00 PM
 *@author Leo Vergnetti
 */

package stackproject;

/*******************************************************************************
 * The Stack class is designed to be used with StackElement class, and is demonstrated
 * in StackProject.  The class can be instantiated with a String array, a String, 
 * or with no arguments. Stack has two datamembers: a StackElement to point to next
 * item on the stack, and an integer to keep track of the size of the stack. 
 * It contains 3 utility methods: print, push, and pop.  
 */
public class Stack {
    //datamembers
    StackElement pointer;    //keeps track of first element in stack
    int size;   //Keeps track of size of stack 
    
    //methods
    
    
    /**************************************************************************
     * Constructor accepts a String argument.  First initializes size to 0, and
     * then calls push method to add the String to the stack.
     * @param element 
     */
    public Stack(String element){
        this.size=0;    //initializes size to 0
        push (element); //push String on to stack.
    }//end constructor
    
    /**************************************************************************
     * No argument constructor to create an empty stack. initializes size to 0.
     */
    public Stack(){
        this.size = 0;  //initialize size to 0
    }//end constructor
    
    /***************************************************************************
     * Push method is used to populate the stack.  Accepts a String argument, and
     * instantiates a StackElement object, containing the data.  If there is nothing
     * in the stack, pointer points to the new element.  Otherwise the old pointer
     * is held in a catalyst StackElement called prev, and pointer is then set 
     * point to the new element, with it's next member pointing to prev. Finally,
     * size is incremented
     * @param data
     */
    public void push(String data){
        StackElement element = new StackElement(data);  //create a new StackElement with the String data
        if (size==0){   //if list is empty
            pointer = element;  //pointer points to new element
        }//end if
        else{
            StackElement prev = pointer;    //make a StackElement pointing to pointer
            pointer = element;  //set pointer to point to new element and
            element.setNext(prev);  //set new element's next to point to old pointer
        }//endelse
        size++;       //increment size
    }//end push method
    
    /**************************************************************************
     * method to pop last item added to stack out of the stack.  Returns the value
     * of the stack's data if there is anything in it. First a String data is
     * made to hold the data of whatever element is first in stack. then removes
     * that element from stack.
     * @return 
     */
    public String pop(){
        String data = "";  //Sring to hold data of pointer element
        if (size > 0){  //if there actually is something in the stack
        data = pointer.getData();   //assign String data in element to data
        pointer = pointer.getNext();    //set pointer to point to next item in list and
        size--; //decrement the size of the array
        }//endif
        return data;    //then return the data 
    }//end pop
    
    /***************************************************************************
     * Method to print data from Stack without removing anything.  First method announces
     * where it will be printing from (to show difference between print method in 
     * StackProject class). If there is an actual list, print the first element, and 
     * then print each successive element until out of elements.
     */
    public void print(){
        System.out.println(" Printing from Stack:");    //tell user which method is printing
        if(size > 0){   //if there is a list there must be at least 1 element
            System.out.println(pointer.getData());  //output the first element
            StackElement currentElement = pointer;  //currentElement points to pointer
            while (currentElement.getNext()!= null){    //while there is a next item in the list
                currentElement = currentElement.getNext();  //assign currentElement to point to that item
                System.out.println(currentElement.getData());//and print the data that Element contains
            }//end while
        }//end if
    }//end print method
    
    /**************************************************************************
     * isEmpty method.  boolean, returns true if size equals 0 (that is the list
     * is empty.
     * @return empty
     */
    public boolean isEmpty(){
        boolean empty = false;  //boolean set to false initiall
        if(size == 0){  //if list is empty
            empty = true;   //set empty to true
        }//end if
        return empty;   //return  
    }//end isEmpty method
}//end class
