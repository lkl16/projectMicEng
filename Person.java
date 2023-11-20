/**
 * Persons within the module
 *
 * @author (Liam Kelly, 22346317)
 * @version (20/11/23)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Person
{
    private String firstName;
    private String lastName;
    public Person(String firstName, String lastName)
    { 
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public String getEntry(int studentNum,String password){
        
        
        return "";
    }
    
    public String addEntry(String moduleName,int studentNum, String status,String grade){
        String filePath = moduleName;
        filePath=filePath.replaceAll(" ","")+".csv";
        
         // Student information to be added
        String[] studentInfo = {""+countEntries(filePath), ""+studentNum, firstName, lastName,status,moduleName,grade, ""+gradeToPoints(grade)};

        
        return "Successfully Added Entry";
    }
    
    public static int countEntries(String filePath) {
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
    
    public static void writeCSV(String filePath, String[] data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            // Creating a string with CSV format
            StringBuilder csvEntry = new StringBuilder();
            for (String value : data) {
                csvEntry.append(value).append(",");
            }
            csvEntry.deleteCharAt(csvEntry.length() - 1); // Remove the trailing comma

            writer.write(csvEntry.toString());
            writer.newLine(); // Move to the next line for the next entry

            writer.close();
            System.out.println("Entry added to the CSV file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int gradeToPoints(String grade){
        int points = 0;
        if(grade.toUpperCase().equals("A1")){
            
        }
        //do this for each possible grade
        return points;
    }
    
}
