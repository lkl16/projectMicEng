import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.lang.System;
/**
 * Student class
 *
 * @author (Liam Kelly, 22346317)
 * @version (20/11/2023)
 */

public class Student extends Person
{
    private int studentNum; //ie 22341234
    private String repeatInfo="";
    //private String studentStatus; //This is supposed to be in program. Oops.
    private HashMap<String,Double> gradeMap;
    
    //initialise the Student 
    public Student(int studentNum, String firstName, String lastName)
    {
        super(firstName,lastName); //initialises Person, which is the parent class
        this.studentNum=studentNum; //sets the local variables (arguments) to the instance variable
        //initialise the gradeMap here. No need for all the if/elifs
        gradeMap=new HashMap<String,Double>();
        gradeMap.put("A1", 4.00);
        gradeMap.put("A2", 3.60);//And so on. This is just an example. This will need to be filled out.
    }
    @Override //overrides the addEntry method in Person. This will be the method used instead.
    public String addEntry(String moduleName, String grade){
        //We use the moduleName (removing any spaces) as the name of the csv file
        String filePath = moduleName.replaceAll(" ","")+".csv";;

         // Student information to be added, we enter in a String[] array
        String[] studentInfo = {""+studentNum, getFirstName(), getLastName(),moduleName,grade, ""+gradeMap.get(grade.toUpperCase())};
        
        //write csv
        csvWrite(filePath,studentInfo);
        //return a string to finish
        return "Done!";
        
    }
    @Override
    public String getEntry(String moduleName){
        return super.getEntry(studentNum,moduleName);
    }
    public void setRepeatInfo(String info){
        repeatInfo=String.format("%s\n%s",repeatInfo,info);
    }
    private void csvWrite(String filePath,String[] info){
        try {
            //Write to the filepath that has been passed in
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            // Creating a string with CSV format
            StringBuilder csvEntry = new StringBuilder();
            //for each value in studentInfo
            for (String value : info) {
                csvEntry.append(value).append(",");
            }
            csvEntry.deleteCharAt(csvEntry.length() - 1); // Remove the trailing comma
            //enter data to csv file
            writer.write(csvEntry.toString());
            writer.newLine(); // Move to the next line for the next entry
            //close the writer - we are finished
            writer.close();
            System.out.println("Entry added to the CSV file successfully!");

        } catch (IOException e) {
            //error catch
            e.printStackTrace();
        }
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
