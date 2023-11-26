import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * Student class
 *
 * @author (Liam Kelly, 22346317)
 * @version (20/11/2023)
 */

public class Student extends Person
{
    private int studentNum; //ie 22341234
    private String studentStatus; //ie, undergraduate
    private HashMap<String,Integer> gradeMap;
    
    //initialise the Student 
    public Student(int studentNum,String studentStatus, String firstName, String lastName)
    {
        super(firstName,lastName); //initialises Person, which is the parent class
        this.studentNum=studentNum; //sets the local variables (arguments) to the instance variable
        this.studentStatus=studentStatus;
        //initialise the gradeMap here. No need for all the if/elifs
        gradeMap=new HashMap<String,Integer>();
        gradeMap.put("A1", 100);
        gradeMap.put("A2", 80);//And so on. This is just an example. This will need to be filled out.
    }
    
    public int getId(){ //in case we need to get student id
        return studentNum; 
    }
    public String getStatus(){ //if we need to get student status
        return studentStatus;
    }
    
    @Override //overrides the addEntry method in Person. This will be the method used instead.
    public String addEntry(String moduleName, String grade){
        //We use the moduleName (removing any spaces) as the name of the csv file
        String filePath = moduleName.replaceAll(" ","")+".csv";;

        
         // Student information to be added, we enter in a String[] array
        String[] studentInfo = {""+studentNum, getFirstName(), getLastName(),studentStatus,moduleName,grade, ""+gradeMap.get(grade.toUpperCase())};
           
        //go to the writeCSV method
        writeCSV(filePath,studentInfo);
        //return a string to finish
        return "Done!";
    }
    
    
 
    
    public static void writeCSV(String filePath, String[] data) {
        try {
            //Write to the filepath that has been passed in
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            // Creating a string with CSV format
            StringBuilder csvEntry = new StringBuilder();
            //for each value in String[] data
            for (String value : data) {
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
    
    
    
    @Override
    public String getEntry(int studentNum,String password,String moduleName){
        return super.getEntry(this.studentNum,password,moduleName);
    }
    
    
}
