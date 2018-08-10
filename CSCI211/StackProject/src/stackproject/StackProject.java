/*
 *Project 4 Stack Project
 *CSCI 211
 *Last modified 10/29 @ 4:00 PM
 *@author Leo Vergnetti
 */
package stackproject;

/****************************************************************************
 * The StackProject class is the main class for the StackProject. It contains a 
 * main method and a method to print each element in an array.  It utilizes the 
 * StackElement and Stack classes to reverse the order of a String array.
 */
public class StackProject {

    /**************************************************************************
     * the main class is the entrypoint for the Stack Project class.  It first
     * creates a new string and initializes it with some elements.  Then it 
     * calls the print method.  it creates a new stack object and initializes it
     * with a while loop.  it prints by calling the stack's print method, and then 
     * calls the pop method in a while statement to move the Strings from the 
     * stack back to the array.  the array is (then reversed) printed from the 
     * print method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a String array with some elements to demonstrate stack
        String[] dataArray = {"Do", "Re", "Me", "Fa", "So", "La", "Ti","Do"};
        Stack stack = new Stack(); //create a new stack
            for (int i = 0; i < dataArray.length; i++){
                stack.push(dataArray[i]);  //push element at index onto stack
            }
        print(dataArray); //print the elements in the array
        stack.print();  //print from the stack's print method
        
        //iterate the array, popping each String in the stack back into the array
        //since stack is in reverse order, array will now be reversed.
        for (int i=0; i<dataArray.length; i++){
            dataArray[i] = stack.pop(); //pop the next item on the stack into dataArray
        }//end for
        print(dataArray);   //call print method on dataArray (now reversed)
    }//end main
    
    /*************************************************************************
     * method to print the elements in an array to the console.  Takes the array
     * as input.
     * @param dataArray 
     */
    public static void print(String[] dataArray){
        System.out.println("Printing from Array:");  //print message letting user know what is printing
        for(int i=0; i<dataArray.length; i++){  //iterate the array
            System.out.println(dataArray[i]);   //output each element in the array to the console
        }//end for
    }//end print method
    
}//end Stack Project class
