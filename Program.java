import java.util.ArrayList;
import java.lang.System;
/**
 * Program Class
 *
 * @author (Liam Kelly,22346317)
 * @version v7
 */
public class Program
{
    private String name; //ie, computer systems
    private String programCode; //ie, LM121
    private int duration; //in years
    private ArrayList<ArrayList<ArrayList<Module>>> years;//list of years which contains a list of semesters which contains a list of modules
    private String programType;//ie taught/research
    private String level; //ie undergrad/postgrad
    private ArrayList<Student> studentList; //studentList
    private ArrayList<Faculty> staffList; //staffList
    public Program(String name, int duration, String programCode,String level, String programType){
        this.duration=duration;
        this.name=name;
        this.programCode=programCode;
        this.programType = programType;
        this.level=level;
        this.years = new ArrayList<ArrayList<ArrayList<Module>>>();
        this.studentList=new ArrayList<Student>();
        this.staffList=new ArrayList<Faculty>();
        for(int i=0;i<duration;i++){
            years.add(new ArrayList<ArrayList<Module>>());
            for(int j=0;j<2;j++){
                years.get(i).add(new ArrayList<Module>());
            }
        }
    }
    
    public void createModule(int year, int semester,String moduleName){
        years.get(year).get(semester).add(new Module(moduleName));        
    }
    public void addModule(int year, int semester,Module module){
        years.get(year).get(semester).add(module);
    }
    public void addStudent(Module module, Student student){
        module.addStudent(student);
        studentList.add(student);
    }
    public void addStaff(Faculty faculty, Module module){
        module.addStaff(faculty);
        staffList.add(faculty);
    }
    public void removeModule(Module module){
        for(ArrayList<ArrayList<Module>> semester: years){
            for(ArrayList<Module> Modules:semester){
                if(Modules.contains(module)){
                    Modules.remove(module);
                }
            }
        }
    }
    public void getStudents(){
        for(ArrayList<ArrayList<Module>> i: years){
            for(ArrayList<Module> j: i){
                for(Module k:j){
                    for(Student l:k.getClassList()){
                        if(!studentList.contains(l)){
                            studentList.add(l);
                        }
                    }
                }
            }
        }
    }
    public void getFaculty(){
        for(ArrayList<ArrayList<Module>> i: years){
            for(ArrayList<Module> j: i){
                for(Module k:j){
                    for(Faculty l:k.getFacultyList()){
                        if(!staffList.contains(l)){
                            staffList.add(l);
                        }
                    }
                }
            }
        }
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
        int year = (semester/2)+(semester%2);
        semester=semester%2;
        return getSemesterQCA(semester+1,year,ID);
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
        int year = (semester/2)+(semester%2);
        semester=semester%2;
        return getSemesterQCA(semester+1,year,student);
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
        double sem1QCA=getSemesterQCA(1,year,student);
        double sem2QCA=getSemesterQCA(2,year,student);
        return yearQCACalc(sem1QCA,sem2QCA);
    }

    public double getYearQCA(int year, int ID){
        double sem1QCA=getSemesterQCA(1,year,ID);
        double sem2QCA=getSemesterQCA(2,year,ID);
        return yearQCACalc(sem1QCA,sem2QCA);
    }
    private double yearQCACalc(double sem1QCA,double sem2QCA){
        int counter=0;
        double QCA=0.0;
        if(sem1QCA<0&&sem2QCA<0){
            return -1.0;
        }
        if(!(sem1QCA<0)){
            QCA = QCA + sem1QCA;
            counter++;
        }
        if(!(sem2QCA<0)){
            QCA = QCA + sem2QCA;
            counter++;
        }

        QCA = QCA/counter;
         return QCA;
    }
    
    public double overallQCA(int ID){
        int counter=0;
        double QCA = 0.0;
        
        for(int i=0;i<this.duration;i++){
            double temp = getYearQCA(i+1,ID);
            if(!(temp<0)){
                QCA=QCA+temp;
                counter++;
            }
        }
        if(counter==0){
            return -1.0;
        }
        return QCA/(counter);
    }
    public double overallQCA(Student student){
        int counter=0;
        double QCA = 0.0;
        
        for(int i=0;i<this.duration;i++){
            double temp = getYearQCA(i+1,student);
            if(!(temp<0)){
                QCA=QCA+temp;
                counter++;
            }
        }
        if(counter==0){
            return -1.0;
        }
        return QCA/(counter);
    }
    public String getTranscript(Student student){
        String outString="";
        ArrayList<Module> allModules=getModuleList();
        boolean infoGot =false;
        int counter=1;
        for(Module i:allModules){
            if(i.getClassList().contains(student)&&!infoGot){
                outString=outString+i.getStudentInfo(student);
                
            }
            if(i.getClassList().contains(student)){
                outString=outString+String.format("\nModule %d: %s",counter,i.getStudentTranscript(student));
                counter++;
            }
        }
        return outString;
    }
    
    
    
    
    
    
    public ArrayList<Module> getModuleList(){
        ArrayList<Module> moduleList = new ArrayList<Module>();
        for(ArrayList<ArrayList<Module>> year: years){
            for(ArrayList<Module> semester: year){
                for(Module i:semester){
                    moduleList.add(i);
                }
            }
        }
        return moduleList;
    }
    public ArrayList<Module> getModuleListSemester(){
        ArrayList<Module> moduleList = new ArrayList<Module>();
        for(ArrayList<ArrayList<Module>> year: years){
            for(ArrayList<Module> semester: year){
                for(Module i:semester){
                    moduleList.add(i);
                }
            }
        }
        return moduleList;
    }
    public ArrayList<Student> getStudentList(){
        return studentList;
    }
    public ArrayList<Faculty> getStaffList(){
        return staffList;
    }
    public int getDuration(){
        return duration;
    }
    public String getName(){
        return name;
    }
}