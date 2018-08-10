package stateproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateList {
    //datamembers
    private int size;   //size keeps track of how many states are actually added
    private State[] states; //array of state objects; 
    
    //constructor inits size to 0 and creates state array with 100 elements
    public StateList(){
        size = 0;       //initialize size of states to 0
        states = new State[100];//creates array of state objects with 100 states.
    }//end StateList()
    
    /*
    *Overloaded constructor, accepts a String fileName and calls addState method 
    *to add multiple names.
    */
    public StateList(String fileName){
        size = 0;   //initializes size to 0
        states = new State[100]; //creates array of state objects with 100 states
        addState(fileName);//call addState with fileName
    }//end StateList(string)
    
//getter for size of list (different than array length)
    public int getSize(){
        return size;//return the value of size
    }//end /getSize
    
    //method to add a state object, accepts single object adds it to array, size is incremented
    public void addState(State state){
        states[size] = state;   //add a single state to index of current size
        size++;        //increment size to account for new state.
    }//end addState()
    
    /*overloaded method to add state object from file. Accepts a string argument
    * which is the name of a file. Begins loop and makes a state object with name, 
    * population and capitol from file. ends when no lines left in file.
    */
    public void addState(String fileName){
        try{
            File file = new File(fileName);//File object for string fileName
            Scanner readFile = new Scanner(file);// open Scanner on file
            while(readFile.hasNext()){  //begin loop when not at end of file
                State state = new State();//make a new state
                state.setName(readFile.nextLine());//add name to state object
                state.setCapitol(readFile.nextLine());//add name of capitol to state
                state.setPopulation(readFile.nextLine()); //add population to state object
                addState(state); //call add state with state object.
                }//end while
            readFile.close(); // close scanner
        }catch(FileNotFoundException e){//catch potential file not found exception
            System.out.println(fileName + " Not Found");//output error with filename
        }//end catch
    }//end addState(file)
    
    //getIndex searches array for string in state name returns index if found
    //else returns -1.  Separated pending removeState code;
    private int getIndex(String name){
        int index = -1;//initialized to -1, if no matches -1 is returned
        for (int i=0; i<size; i++){
            if (name.equalsIgnoreCase(states[i].getName())){//if the state name matches the search criteria,
                index = i; //the index is set to i
                break;//if found stop looping
            } //end if
        }//end for
        return index;//return value of index, if -1, then not found
    }//end getIndex(Sring)
    
    //search state will attempt to get the index of the state with string value equal to the name of state
    //if index returns -1, prints not found message, otherwise it will print state data at index;
    public void searchState(String name){//accepts string parameter
        int searchIndex = getIndex(name);//calls getIndex method
        if(searchIndex == -1){  //search index = -1 means state not found
            System.out.println(name +" not found!");//outputs that the given state could not be found
        }//end if
        else{
            printState(states[searchIndex]);//if object was found, print the state
        }//end else
    }
    //prints formatted single state data, accepts state object as argument
    public void printState(State state){
        System.out.printf("%-15s%-20s%-10s%n",  state.getName(),state.getCapital(),
                            state.getPopulation());   //print formatted output
    }
   
    //prints whole state list.  will simply call printState for every state object
    //in the array.
    public void print(){
        for(int i = 0; i < size; i++){//begin for loop and iterate for as many states as were added
            printState(states[i]);//call print state method on state at index of current iteration
        }//end for;
    }//end print;
    
    //a hypothetical deleteState name.
    //1.verify and get index of state to be deleted;
    //2.copy index+1 to index marked for deletion
    //3.continue copying until states[size] is reached
    //4.decrement size to account for missing model
    public void deleteState(String name){
        int deleteIndex = getIndex(name);//find index of name by calling getIndex method
        if (deleteIndex != -1){//if index is -1, then the state wasn't found
            for (int i=deleteIndex; i<size; i++){ //begin iteration of remaining states after deletion point
                states[i] = states[i+1]; //state to be deleted info is replaced by adjacent state in array   
            }//end for
            size--;
            states[(size-1)].setName(""); //remove state name in old last filled array location
            states[(size-1)].setCapitol("");//remove state capitol in last filled array location
            states[(size-1)].setPopulation("");//remove population in last filled array location
            
           // size--;//decrement size datamember
            System.out.println(name + " Deleted");//tell user state was deleted
        }//end if
        else {
            System.out.println(name +" Not Found");//else print that state was not found
        }//end else
    }//end deleteState()
}//end class