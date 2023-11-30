import java.util.ArrayList;

/**
 * Module Class
 *
 * @author (Liam Kelly,22346317)
 * @version v7
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
        staffList=new ArrayList<Faculty>();
    }
    public void addStudent(Student student){
        if(!classList.contains(student)){
            classList.add(student);
        }
        
    }
    public void addStaff(Faculty staff){
        if(staffList.contains(staff)){
            staffList.add(staff);
        }
        
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
    public String getStudentTranscript(Student student){
        String myEntry = student.getEntry(moduleName);
        if(myEntry != null&&!myEntry.equals("Err: Couldn't get Student ID")){ 
            String[] moduleInfo = myEntry.split(",");
            return String.format("Module name: %s, Grade: %s, Module QCA: %s ",moduleInfo[1],moduleInfo[2],moduleInfo[0],moduleInfo[3],moduleInfo[4],moduleInfo[5] );
        }
        else return null;
    }
    public String getStudentInfo(Student student){
        String myEntry = student.getEntry(moduleName);
        if(myEntry != null&&!myEntry.equals("Err: Couldn't get Student ID")){ 
            String[] moduleInfo = myEntry.split(",");
            return String.format("\nName: %s %s, Student id: %s, ",moduleInfo[1],moduleInfo[2],moduleInfo[0]);
        }
        else return null;
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
