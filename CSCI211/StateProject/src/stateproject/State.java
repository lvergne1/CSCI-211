
package stateproject;

/*
 * State class is a template for each state object, holds state name, population
 * and capitol.  
 */
public class State {
    //data members
    private String name;        //String for state name
    private String capitol;     //String for capitol
    private String population;     //integer for population
    
    //methods
    //constructor
    /*
     *Null constructor initializes name and capitol, and sets population to 0; 
    */
    public State(){
        this.name = ""; //initialize name
        this.capitol = "";//initialize capitol
        this.population = "";//initialize population
    }

    //accessors
    public String getName(){//accessor for name
        return name; //return the name
    }
    public String getCapital(){ //accessor for capitol
        return capitol; //returns capitol
    }
    public String getPopulation(){ //accessor for population
        return population;  //returns the population
    }
    //mutators
    public void setName(String name){
        this.name = name;   //sets name datamember to parameter
    }
    public void setCapitol(String capitol){
        this.capitol = capitol; //sets capitol datamember to parameter
    }
    public void setPopulation(String population){
        this.population = population;//setes population datamember to parameter
    }
}