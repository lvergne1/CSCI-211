
package stateproject;

import java.util.Scanner;

/**
 * This is the main executable class for the states assignment. The main method
 * creates a new instance of StateList using the string constructor.  This list
 * is then printed.  After it searches for a user's state prints the state information
 * and then deletes a state from the user. 
 */
public class StateProject {
    
    public static void main(String[] args) {
        
        StateList stateList = new StateList("statedata.txt");//make a new stateList with string name of text file
        stateList.print();//print stateList
        
        //demonstrate search and delete 
        
        Scanner kb = new Scanner(System.in);//open scanner on Standard input
        System.out.println("Enter a State name ");  //ask user for a state
        stateList.searchState(kb.nextLine());   //call search for user's state
        System.out.println("Enter a state to delete");// ask user for a state to delete
        stateList.deleteState(kb.nextLine());//delete user's state
        kb.close();// close scanner
     } //end 
    
}
