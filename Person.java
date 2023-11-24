import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.*;  
import java.util.Scanner; 
import java.lang.System;
/**
 * Persons within the module
 *
 * @author (Liam Kelly, 22346317)
 * @version (2.0)
 */
public class Person
{
    private String firstName;
    private String lastName;
    public Person(String firstName, String lastName) //setup the first/last name of the person
    { 
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getEntry(int studentNum,String moduleName){
        String currentLine; //the current line of the csv
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            //go through each line in the 
            for (int i = 0; i < countEntries(moduleName.replaceAll(" ","")+".csv"); i++){
                currentLine=br.readLine();//set currentline to the line we just read
                if(currentLine.split(",")[0].equals(studentNum+"")){//check if id in csv matches the id we're looking for
                    return currentLine;//id found, return line
                }
            }
            return null;//if id doesnt exist
        } 
        catch(IOException e){
            System.out.println(e); //error catch
        }
        return null;//shouldnt get to here, but just in case
    }
    
    public String getEntry(String moduleName){
        return "Err: Couldn't get Student ID";
        //should either be overrided by student or faculty should provide id
    }
    
    
    
    

    private int countEntries(String filePath) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public String addEntry(String moduleName, String grade){
        return "Failure";
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
