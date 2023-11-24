import java.util.ArrayList;

/**
 * Module Class
 *
 * @author (Liam Kelly,22346317)
 * @version (20/11/2023)
 */
public class Module
{
    private String moduleName;
    private ArrayList<Student> classList;
    private ArrayList<Faculty> staffList;
    public Module(String name)
    {
        this.moduleName=name;
        classList=new ArrayList<Student>();
        //staffList=new ArrayList<Faculty>();
    }

    
    
    public double getStudentGrade(Student student){
        String myEntry = student.getEntry(moduleName);
        if(myEntry != null&&!myEntry.equals("Err: Couldn't get Student ID")){ 
            String[] moduleInfo = myEntry.split(",");
            return Double.parseDouble(moduleInfo[5]);
        }
        else return -1.0;
    }
    public double getStudentGrade(int ID){
        for(Student i:classList){
            if(i.getId() == ID){
                return getStudentGrade(i);
            }
        }
        return -1.0;
    }
    
    
    
    
    
    
    public String getName(){
        return moduleName;
    }
    public ArrayList<Student> getClassList(){
        return classList;
    }
    public ArrayList<Faculty> getFacultyList(){
        return staffList;
    }
}
