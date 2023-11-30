import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.lang.System;
/**
 * Student Class
 *
 * @author (Liam Kelly,22346317)
 * @version v7
 */

public class Student extends Person
{
    private int studentNum; //ie 22341234
    private String repeatInfo="";
    //private String studentStatus; //This is supposed to be in program. Oops.
    
    
    //initialise the Student 
    public Student(int studentNum, String firstName, String lastName)
    {
        super(firstName,lastName); //initialises Person, which is the parent class
        this.studentNum=studentNum; //sets the local variables (arguments) to the instance variable
        //initialise the gradeMap here. No need for all the if/elifs
        
    }
    
    @Override
    public String getEntry(String moduleName){
        return super.getEntry(studentNum,moduleName);
    }
    
    
     public int getId(){ //in case we need to get student id
        return studentNum; 
    }
    public String getFirstName(){
        return super.getFirstName();
    }
    public String getLastName(){
        return super.getLastName();
    }
    
}
