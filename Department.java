import java.util.ArrayList;
import java.lang.System;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Department Class
 *
 * @author (Liam Kelly,22346317)
 * @version v7
 */
public class Department
{
    private String name;
    private ArrayList<Program> programs;
    private ArrayList<Student> studentList;
    private ArrayList<Faculty> staffList;
    private ArrayList<Module> moduleList;
    public Department(String name){
        this.name=name;
        this.programs=new ArrayList<Program>();
        this.studentList=new ArrayList<Student>();
        this.moduleList=new ArrayList<Module>();
        this.staffList=new ArrayList<Faculty>();
    }
    public void addProgram(Program program){
        programs.add(program);
    }
    public void addModule(Module module,Program program,int year,int semester){
        moduleList.add(module);
        programs.get(programs.indexOf(program)).addModule(year,semester,module);
    }
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void addStaff(Faculty faculty){
        staffList.add(faculty);
    }
    public void removeProgram(Program program){
        programs.remove(program);
    }
    public void examBoardModule(double cutoffQCA, Module module,Program program){
        if(!program.getModuleList().contains(module)){
            System.out.println("Error, this module is not in this program.");
        }
        else{
            for(Student i: module.getClassList()){
                if(module.getStudentGrade(i)<cutoffQCA){
                    csvWrite(program.getName(),new String[] {""+i.getId(),i.getFirstName(),i.getLastName(),"Module: "+module.getName()});
                }
            }
        }
    }

    public void examBoardSemester(double cutoffQCA, int semester, int year,Program program){

        if(year>program.getDuration() || (semester-1)>1||(semester-1)<0||year<0){
            System.out.println("Error, this semester is not in this program.");
        }
        else{
            for(Student i: program.getStudentList()){
                if(program.getSemesterQCA(semester-1,year-1,i)<cutoffQCA){
                    csvWrite(program.getName(),new String[] {""+i.getId(),i.getFirstName(),i.getLastName(),"Year "+year,"Semester "+semester});
                }
            }
        }

    }

    public void examBoardSemester(double cutoffQCA, int semester,Program program){
        int year = (semester/2)+(semester%2);
        semester=semester%2;
        examBoardSemester(cutoffQCA,semester+1,year,program);
    }

    public void examBoardYear(double cutoffQCA, int year,Program program){
        if(year>program.getDuration()||program.getDuration()<0){
            System.out.println("Error, this year is not in this program.");
        }
        else{
            for(Student i: program.getStudentList()){
                if(program.getYearQCA(year-1,i)<cutoffQCA){
                    csvWrite(program.getName(),new String[] {""+i.getId(),i.getFirstName(),i.getLastName(),"Year "+year});
                }
            }
        }
    }

    public void examBoardOverall(double cutoffQCA,Program program){
        for(Student i: program.getStudentList()){
            if(program.overallQCA(i)<cutoffQCA){
                csvWrite(program.getName(),new String[] {""+i.getId(),i.getFirstName(),i.getLastName(),"Program"});
            }
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
    public String getName(){
        return name;
    }
    public ArrayList<Program> getPrograms(){
        return programs;
    }
    
}