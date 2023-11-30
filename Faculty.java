import java.util.ArrayList;
import java.lang.System;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.io.IOException;

/**
 * Faculty Class
 *
 * @author (Liam Kelly,22346317)
 * @version v7
 */
public class Faculty extends Person
{
    private String teachingRole; //ie, lecturer, tutorials, etc.
    private HashMap<String,Double> gradeMap;
    //initialising
    public Faculty(String teachingRole,String firstName, String lastName)
    {
        super(firstName,lastName);
        this.teachingRole=teachingRole;
        gradeMap=new HashMap<String,Double>();
        gradeMap.put("A1", 4.00);
        gradeMap.put("A2", 3.60);//And so on. This is just an example. This will need to be filled out.
    }

    @Override //overrides the addEntry method in Person. This will be the method used instead.
    public String addEntry(String moduleName, String grade,Student student){
        //We use the moduleName (removing any spaces) as the name of the csv file
        if(!gradeMap.containsKey(grade)){
            return "Error! This grade is invalid!";
        }else{
            String filePath = moduleName.replaceAll(" ","")+".csv";;

            // Student information to be added, we enter in a String[] array
            String[] studentInfo = {""+student.getId(), getFirstName(), getLastName(),moduleName,grade, ""+gradeMap.get(grade.toUpperCase())};

            //write csv
            csvWrite(filePath,studentInfo);
            //return a string to finish
            return "Done!";
        }

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

    public String getRole(){
        return teachingRole;
    }
}