import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

class gradingSystem {
    private ArrayList<Department> departments;
    private ArrayList<Program> programs;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Faculty> faculty;
    private boolean admin = false;
    private boolean staff = false;
    private boolean student = false;
    public gradingSystem(){
        programs = new ArrayList<Program>();
        modules = new ArrayList<Module>();
        students= new ArrayList<Student>();
        faculty= new ArrayList<Faculty>();
    }
    public void main(String[] args) {
        if(!logIn()){
            logIn();
        }
    }
    private boolean logIn(){
        System.out.printf("Hi, please Log in. Are you a...\n1)student\n2)staff\n3)admin\n4)Exit System");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        int optionPicked= myScanner.nextInt();
        myScanner.close();
        if(optionPicked==1){
            
        }else if(optionPicked==2){
            
        }else if(optionPicked==3){
            System.out.println("Logged in as admin");
            admin=true;
            showOptionsAdmin();
            return true;
        }else if(optionPicked==4){
            System.out.println("Exiting...");
        }
        else{
            System.out.println("Invalid");
        }
        return false;
    }
    private void checkUser(){
        if(staff){
            
        }else if(student){
            
        }else if(admin){
            showOptionsAdmin();
        }else{
            logIn();
        }
    }
    private void showOptionsAdmin(){
        System.out.printf("\nWelcome to the grading system. Here are your options.\n");
        System.out.printf("a) Create a department/school\n");
        System.out.printf("b) Create a program\n");
        System.out.printf("c) Create a module\n");
        System.out.printf("d) Add a student\n");
        System.out.printf("e) Add a staff member\n");
        System.out.println();
        System.out.printf("f) View all departments/schools\n");
        System.out.printf("g) View all programs\n");
        System.out.printf("h) View allmodules\n");
        System.out.printf("i) View all students\n");
        System.out.printf("j) View all staff members\n");
        System.out.println();
        System.out.printf("k) Remove a department/school\n");
        System.out.printf("l) Remove a program\n");
        System.out.printf("m) Remove a module\n");
        System.out.printf("n) Remove a student\n");
        System.out.printf("o) Remove a staff member\n");
        System.out.println();
        System.out.printf("p) Run an exam board\n");
        System.out.printf("q) Log out\n");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        String optionPicked= myScanner.nextLine();
        myScanner.close();
        if(optionPicked.toUpperCase().equals("A")){
            createDepartment();
        }
    }
    private void createDepartment(){
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.printf("\nTo make our department, please enter:");
        System.out.print("Department name: ");
        String name= myScanner.nextLine();
        myScanner.close();
        departments.add(new Department(name));
    }
    private void createProgram(){
        if(departments.isEmpty()){
            System.out.println("First, make a department");
        }
        else{
            Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Select a department to put program in ");
            for(Department i:departments){
                int j = 1;
                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            int departmentChosen = myScanner.nextInt();
            Department department = departments.get(departmentChosen-1);
            
            System.out.printf("\nTo make our program, please enter:");
            System.out.print("Program name: ");
            String name= myScanner.nextLine();
            System.out.print("Program duration (in years): ");
            int duration= myScanner.nextInt();
            System.out.print("Program code: ");
            String code= myScanner.nextLine();
            System.out.print("Program level: ");
            String level= myScanner.nextLine();
            System.out.print("Program type (ie. research/taught): ");
            String type= myScanner.nextLine();
            myScanner.close();
            if(duration>0){
                Program myProgram = new Program(name,duration,code,level,type);
                department.addProgram(myProgram);
                programs.add(myProgram);
            }
            else{
                System.out.println("You entered an invalid duration");
            }
        }
        checkUser();
    }
    private void createModule(){
        if(departments.isEmpty()){
            System.out.println("First, make a department");
        }
        else{
            if(programs.isEmpty()){
                System.out.println("First, make a program");
            }
            else{
                Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Select a department: ");
                for(Department i:departments){
                    int j = 1;
                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                Department department = departments.get(departmentChosen-1);
                System.out.println("Select a program: ");
                for(Program i: department.getPrograms()){
                    int j = 1;
                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                Program program = department.getPrograms().get(programChosen-1);
                
                System.out.printf("\nTo make our module, please enter:");
                System.out.print("Module name: ");
                String name= myScanner.nextLine();
                System.out.print("Year module will be done: ");
                int year= myScanner.nextInt();
                System.out.print("Semester module will be done: ");
                int semester= myScanner.nextInt();
                myScanner.close();
                Module myModule = new Module(name);
                department.addModule(myModule,program,year,semester);
                modules.add(myModule);
            }
        }
        checkUser();
    }
    private void createStudent(){
        if(departments.isEmpty()){
            System.out.println("First, make a department");
        }
        else{
            if(programs.isEmpty()){
                System.out.println("First, make a program");
            }
            else{
                if(modules.isEmpty()){
                    System.out.println("First, make a module");
                }
                else{
                    Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Select student's department: ");
                    for(Department i:departments){
                        int j = 1;
                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int departmentChosen = myScanner.nextInt();
                    Department department = departments.get(departmentChosen-1);
                    System.out.println("Select student's program: ");
                    for(Program i: department.getPrograms()){
                        int j = 1;
                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int programChosen = myScanner.nextInt();
                    Program program = department.getPrograms().get(programChosen-1);
                    
                    System.out.printf("\nTo make our Student, please enter:");
                    System.out.print("Student's first name: ");
                    String firstName= myScanner.nextLine();
                    System.out.print("Student's lastname: ");
                    String lastName= myScanner.nextLine();
                    System.out.print("Student's ID: ");
                    int ID= myScanner.nextInt();
                    myScanner.close();
                    Student myStudent = new Student(ID,firstName,lastName);
                    enrollStudentToModules();
                }
            }
        }
        checkUser();
    }
    private void enrollStudentToModules(){
        
    }
}