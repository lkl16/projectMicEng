import java.util.ArrayList;
import java.lang.System;
/**
 * Write a description of class Program here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Program
{
    private String name; //ie, computer systems
    private String programCode; //ie, LM121
    private int duration; //in years
    private ArrayList<ArrayList<ArrayList<Module>>> years;//outermost list

    public Program(String name, int duration, String programCode){
        this.duration=duration;
        this.name=name;
        this.programCode=programCode;
        this.years = new ArrayList<ArrayList<ArrayList<Module>>>();

    }

    public void createModule(int year, int semester,String moduleName){
        if(years.get(year).isEmpty()){
            years.set(year, new ArrayList<ArrayList<Module>>());
        }
        if(years.get(year).get(semester).isEmpty()){
            years.get(year).set(semester,new ArrayList<Module>());
        }
        years.get(year).get(semester).add(new Module(moduleName));        
    }

    public String getFullProgram(){
        String outString = String.format("%s, %s:\n",this.name,this.programCode);
        for(ArrayList<ArrayList<Module>> year: years){
            outString=outString+String.format("Year %d:\n",years.indexOf(year)+1);
            for(ArrayList<Module> semester:year){
                outString=outString+String.format("Semester %d:\n",year.indexOf(semester)+1);
                for(Module module:semester){
                    outString=outString+String.format("Modules %d: %s\n",semester.indexOf(module)+1,module.getName());
                    
                }
            }
        }
        return outString;
    }

    public double getSemesterQCA(int semester,int ID){
        int year = semester/2;
        semester=semester%2;
        return getSemesterQCA(semester+1,year+1,ID);
    }

    public double getSemesterQCA(int semester,int year,int ID){
        semester=semester-1;
        year=year-1;
        double QCA = 0.0;
        int counter = 0;
        for(Module i: years.get(year).get(semester)){
            double moduleGrade = i.getStudentGrade(ID);
            if(moduleGrade>=0){
                QCA=QCA+moduleGrade;
                counter++;
            }else{
                System.out.println("Student not found in module: "+i.getName());
            }
        }
        return QCA/counter;
    }

    public double getSemesterQCA(int semester,Student student){
        int year = semester/2;
        semester=semester%2;
        return getSemesterQCA(semester+1,year+1,student);
    }

    public double getSemesterQCA(int semester,int year,Student student){
        semester=semester-1;
        year=year-1;
        double QCA = 0.0;
        int counter = 0;
        if(years.get(year).get(semester).isEmpty()){
            return -1.0;
        }
        for(Module i: years.get(year).get(semester)){
            
            double moduleGrade = i.getStudentGrade(student);
            if(moduleGrade>=0){
                QCA=QCA+moduleGrade;
                counter++;
            }else{
                System.out.println("Student not found in module: "+i.getName());
            }
        }
        return QCA/counter;
    }
    
    public double getYearQCA(int year, Student student){
        double QCA = 0.0;
        double sem1QCA=getSemesterQCA(1,year,student);
        double sem2QCA=getSemesterQCA(2,year,student);
        if(sem1QCA<0&&sem2QCA<0){
            return -1.0;
        }
        
        QCA = QCA + sem1QCA;
        QCA = QCA + sem2QCA;
        QCA = QCA/2;
        return QCA;
    }
}
