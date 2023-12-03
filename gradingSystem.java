import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
/**
 * Grading system
 *
 * @author (Liam Kelly,22346317)
 * @version v7
 */
class gradingSystem {
    private ArrayList<Department> departments;
    private ArrayList<Program> programs;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Faculty> facultyList;
    private boolean admin = false;
    private boolean staff = false;
    private boolean student = false;
    public gradingSystem(){
        programs = new ArrayList<Program>();
        modules = new ArrayList<Module>();
        students= new ArrayList<Student>();
        facultyList= new ArrayList<Faculty>();
        departments=new ArrayList<Department>();
        logIn();
    }

    private void logIn(){
        System.out.printf("\nHi, please Log in. Are you a...\n1)student\n2)staff\n3)admin\n4)Exit System\n");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        int optionPicked= myScanner.nextInt();
        myScanner.close();
        if(optionPicked==1){
            System.out.println("Logged in as student");
            student=true;
            checkUser();
            logIn();
        }else if(optionPicked==2){
            System.out.println("Logged in as staff");
            staff=true;
            checkUser();
            logIn();
        }else if(optionPicked==3){
            System.out.println("Logged in as admin");
            admin=true;
            checkUser();
            logIn();
        }else if(optionPicked==4){
            System.out.println("Exiting...");
        }
        else{
            System.out.println("Invalid");
            logIn();
        }
        
    }

    private void checkUser(){
        if((staff == true && student == true)||(staff==true && admin == true)||(admin ==true && student == true)){
            System.out.println("Error. Try logging in again");
            logIn();
        }
        else{
            if(staff){
                showOptionsStaff();
            }else if(student){
                showOptionsStudent();
            }else if(admin){
                showOptionsAdmin();
            }else{
                logIn();
            }
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
        System.out.printf("h) View modules\n");
        System.out.printf("i) View students\n");
        System.out.printf("j) View staff members\n");
        System.out.println();
        System.out.printf("k) Remove a department/school\n");
        System.out.printf("l) Remove a program\n");
        System.out.printf("m) Remove a module\n");
        System.out.println();
        System.out.printf("n) Log out\n\n");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        String optionPicked= myScanner.nextLine();
        myScanner.close();
        if(optionPicked.toUpperCase().equals("A")){
            createDepartment();
        }else if(optionPicked.toUpperCase().equals("B")){
            createProgram();
        }else if(optionPicked.toUpperCase().equals("C")){
            createModule();
        }else if(optionPicked.toUpperCase().equals("D")){
            createStudent();
        }else if(optionPicked.toUpperCase().equals("E")){
            createStaff();
        }else if(optionPicked.toUpperCase().equals("F")){
            System.out.println(showDepartments());
        }else if(optionPicked.toUpperCase().equals("G")){
            System.out.println(showPrograms());
        }else if(optionPicked.toUpperCase().equals("H")){
            System.out.println(showModules());
        }else if(optionPicked.toUpperCase().equals("I")){
            System.out.println(showStudents());
        }else if(optionPicked.toUpperCase().equals("J")){
            System.out.println(showStaff());
        }else if(optionPicked.toUpperCase().equals("K")){
            removeDepartment();
        }else if(optionPicked.toUpperCase().equals("L")){
            removeProgram();
        }else if(optionPicked.toUpperCase().equals("M")){
            removeModule();
        }else if(optionPicked.toUpperCase().equals("N")){
            logOut();
        }else{
            System.out.println("Error, invalid input");
        }
        checkUser();
    }

    private void showOptionsStaff(){
        System.out.printf("\nWelcome to the grading system. Here are your options.\n");
        System.out.printf("a) View all departments/schools\n");
        System.out.printf("b) View all programs\n");
        System.out.printf("c) View modules\n");
        System.out.printf("d) View students\n");
        System.out.printf("e) View staff members\n");
        System.out.println();
        System.out.printf("f) Grade a student\n");
        System.out.printf("g) Run an exam board\n");
        System.out.printf("h) Get Student Transcript");
        System.out.printf("i) Log out\n\n");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        String optionPicked= myScanner.nextLine();
        myScanner.close();
        if(optionPicked.toUpperCase().equals("A")){
            showDepartments();
        }else if(optionPicked.toUpperCase().equals("B")){
            showPrograms();
        }else if(optionPicked.toUpperCase().equals("C")){
            showModules();
        }else if(optionPicked.toUpperCase().equals("D")){
            showStudents();
        }else if(optionPicked.toUpperCase().equals("E")){
            showStaff();
        }else if(optionPicked.toUpperCase().equals("F")){
            gradeStudent();
        }else if(optionPicked.toUpperCase().equals("G")){
            examBoard();
        }else if(optionPicked.toUpperCase().equals("H")){
            printTranscript();
        }else if(optionPicked.toUpperCase().equals("I")){
            logOut();
        }else{
            System.out.println("Error, invalid input");
        }
        checkUser();
    }

    private void showOptionsStudent(){
        System.out.printf("\nWelcome to the grading system. Here are your options.\n");
        System.out.printf("a) Get Student Transcript\n");
        System.out.printf("b) Log out\n\n");
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter your choice: ");
        String optionPicked= myScanner.nextLine();
        myScanner.close();
        if(optionPicked.toUpperCase().equals("A")){
            printTranscript();
        }else if(optionPicked.toUpperCase().equals("B")){
            logOut();
        }else{
            System.out.println("Error, invalid input");
        }
        checkUser();
    }

    private void createDepartment(){
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.printf("\nTo make our department, please enter:\n");
        System.out.print("Department name: ");
        String name= myScanner.nextLine();

        departments.add(new Department(name));
        myScanner.close();  
    }

    private void createProgram(){
        if(departments.isEmpty()){
            System.out.println("First, make a department");
        }
        else{
            Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Select a department to put program in ");
            int j = 1;
            for(Department i:departments){
                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            int departmentChosen = myScanner.nextInt();
            myScanner.nextLine();
            
            Department department = departments.get(departmentChosen-1);

            System.out.printf("\nTo make our program, please enter:\n");
            System.out.print("Program name: ");
            String name= myScanner.nextLine();
            System.out.print("Program duration (in years): ");
            int duration= myScanner.nextInt();
            myScanner.nextLine();
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
                int j = 1;
                for(Department i:departments){
                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);
                System.out.println("Select a program: ");
                j = 1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);

                System.out.printf("\nTo make our module, please enter:\n");
                System.out.print("Module name: ");
                String name= myScanner.nextLine();
                System.out.print("Year module will be done: ");
                int year= myScanner.nextInt();
                myScanner.nextLine();
                System.out.print("Semester module will be done: ");
                int semester= myScanner.nextInt();
                myScanner.nextLine();
                myScanner.close();
                Module myModule = new Module(name);
                department.addModule(myModule,program,year,semester);
                modules.add(myModule);
            }
        }

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
                    int j = 1;
                    for(Department i:departments){

                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int departmentChosen = myScanner.nextInt();
                    myScanner.nextLine();
                    Department department = departments.get(departmentChosen-1);
                    System.out.println("Select student's program: ");
                    j = 1;
                    for(Program i: department.getPrograms()){

                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int programChosen = myScanner.nextInt();
                    myScanner.nextLine();
                    Program program = department.getPrograms().get(programChosen-1);

                    System.out.printf("\nTo make our Student, please enter:\n");
                    System.out.print("Student's first name: ");
                    String firstName= myScanner.nextLine();
                    System.out.print("Student's lastname: ");
                    String lastName= myScanner.nextLine();

                    boolean idUnique=false;
                    int ID=0;
                    while(!idUnique){
                        System.out.print("Student's ID: ");
                        ID= myScanner.nextInt();
                        idUnique=true;
                        for(Student i:students){
                            if(ID==i.getId()){
                                System.out.println("Error! This student ID is in use!");
                                idUnique=false;
                            }
                        }
                    }

                    myScanner.close();
                    Student myStudent = new Student(ID,firstName,lastName);
                    department.addStudent(myStudent);
                    enrollStudentToModules(myStudent,program);
                    if(!students.contains(myStudent)){
                        students.add(myStudent);
                    }
                    
                }
            }
        }

    }

    private void enrollStudentToModules(Student student,Program program){
        Scanner myScanner =new Scanner(System.in);
        boolean add = true;
        ArrayList <Module> moduleList = program.getModuleList();

        while(add){
            int j = 1;
            for(Module i:moduleList){
                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            System.out.print("Select Module to enroll student in: ");
            int choice = myScanner.nextInt();
            myScanner.nextLine();
            if(choice>j||choice<0){
                System.out.println("invalid");
            }
            else{
                
                moduleList.get(choice-1).addStudent(student);
            }
            System.out.print("Do you want to enroll the student in another module? (enter 'y' if you want to continue): ");
            String continueChoice = myScanner.nextLine();
            if (!continueChoice.toUpperCase().equals("Y")) {
                add = false;
            }else{
                add=true;
            }

        }
        myScanner.close();
    }

    private void createStaff(){
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
                    System.out.println("Select staff's department: ");
                    int j = 1;
                    for(Department i:departments){

                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int departmentChosen = myScanner.nextInt();
                    myScanner.nextLine();
                    Department department = departments.get(departmentChosen-1);
                    System.out.println("Select staff's program: ");
                    j = 1;
                    for(Program i: department.getPrograms()){

                        System.out.printf("%s) %s\n",""+j,i.getName());
                        j++;
                    }
                    int programChosen = myScanner.nextInt();
                    myScanner.nextLine();
                    Program program = department.getPrograms().get(programChosen-1);

                    System.out.printf("\nTo make our Staff, please enter:\n");
                    System.out.print("Staff's first name: ");
                    String firstName= myScanner.nextLine();
                    System.out.print("Staff's lastname: ");
                    String lastName= myScanner.nextLine();
                    System.out.print("Staff's role (ie. Lecturer): ");
                    String role= myScanner.nextLine();
                    myScanner.close();
                    Faculty myStaff = new Faculty(role,firstName,lastName);
                    department.addStaff(myStaff);
                    addStaff(myStaff,program);
                    facultyList.add(myStaff);
                }
            }
        }

    }

    private void addStaff(Faculty faculty, Program program){
        Scanner myScanner =new Scanner(System.in);
        boolean add = true;
        ArrayList <Module> moduleList = program.getModuleList();

        while(add){
            int j = 1;
            for(Module i:moduleList){
                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            System.out.print("Select Module to enter staff in: ");
            int choice = myScanner.nextInt();
            myScanner.nextLine();
            if(choice>j||choice<0){
                System.out.println("invalid");
            }
            else{
                moduleList.get(choice-1).addStaff(faculty);
            }
            System.out.print("Do you want to enter staff in to another module? (enter 'y' if you want to continue): ");
            String continueChoice = myScanner.nextLine();
            if (!continueChoice.toUpperCase().equals("Y")) {
                add = false;
            }else{
                add=true;
            }

        }
        myScanner.close();
    }

    private String showDepartments(){
        String outString="";
        int j = 1;
        for(Department i:departments){

            outString=outString+String.format("%s) %s\n",""+j,i.getName());
            j++;
        }
        return outString;
    }

    private String showPrograms(){
        String outString="";
        int j = 1;
        for(Department i:departments){

            outString=outString+String.format("%s) %s\n",""+j,i.getName());
            int l=1;
            for(Program k: i.getPrograms()){

                outString=outString+String.format("\t%s) %s\n",""+j,i.getName());
                l++;
            }
            j++;
        }
        return outString;
    }

    private String showModules(){
        String outString="";
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
                int j = 1;
                for(Department i:departments){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);
                outString=outString+String.format("In department %s, ",department.getName());
                System.out.println("Select a program: ");
                j=1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);
                outString=outString+String.format("In program %s, ",program.getName());
                j=1;
                for(Module i: program.getModuleList()){
                    outString=outString+String.format("%s) %s\n",""+j,i.getName());
                    j++;
                }
                myScanner.close();
            }
        }
        return outString;
    }

    private String showStudents(){
        String outString="";
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
                int j = 1;
                for(Department i:departments){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);
                outString=outString+String.format("In department %s, ",department.getName());
                System.out.println("Select a program: ");
                j=1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);
                outString=outString+String.format("In program %s, ",program.getName());
                j=1;
                for(Student i: program.getStudentList()){
                    outString=outString+String.format("%s) ID=%d, %s %s\n",""+j,i.getId(),i.getFirstName(),i.getLastName());
                    j++;
                }
                myScanner.close();
            }
        }
        return outString;
    }

    private String showStaff(){
        String outString="";
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
                int j = 1;
                for(Department i:departments){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);
                outString=outString+String.format("In department %s, ",department.getName());
                System.out.println("Select a program: ");
                j=1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);
                outString=outString+String.format("In program %s, ",program.getName());
                j=1;
                for(Faculty i: program.getStaffList()){
                    outString=outString+String.format("%s)%s: %s %s\n",""+j,i.getRole(),i.getFirstName(),i.getLastName());
                    j++;
                }
                myScanner.close();
            }
        }
        return outString;
    }

    private void removeDepartment(){
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);
        myScanner.close();
        departments.remove(department);
    }

    private void removeProgram(){
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select a department to remove: ");
        int j = 1;
        for(Department i:departments){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);
        System.out.println("Select a program to remove: ");
        j=1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        myScanner.nextLine();
        Program program = department.getPrograms().get(programChosen-1);
        myScanner.close();
        department.removeProgram(program);
        programs.remove(program);
    }

    private void removeModule(){
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
                int j = 1;
                for(Department i:departments){
                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);
                System.out.println("Select a program: ");
                j = 1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);
                System.out.println("Select a module to remove: ");
                j = 1;
                ArrayList<Module> moduleList = program.getModuleList();
                for(Module i: moduleList){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int moduleChosen = myScanner.nextInt();
                Module myModule = moduleList.get(moduleChosen-1);
                myScanner.close();
                program.removeModule(myModule);
                modules.remove(myModule);
            }
        }

    }

    private void examBoard(){
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
                }else{
                    Scanner myScanner = new Scanner(System.in);
                    System.out.printf("a) Run exam board for a module\n");
                    System.out.printf("b) Run exam board for a semester\n");
                    System.out.printf("c) Run exam board for a year\n");
                    System.out.printf("d) Run exam board for a program");
                    String choice = myScanner.nextLine();
                    myScanner.close();

                }
            }
        }
    }

    private void examBoardModule(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a minimum QCA to pass: ");
        double cutoff = myScanner.nextInt();
        myScanner.nextLine();

        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){
            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);

        System.out.println("Select a program: ");
        j = 1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        myScanner.nextLine();
        Program program = department.getPrograms().get(programChosen-1);

        System.out.println("Select a module to run exam board on: ");
        j = 1;
        ArrayList<Module> moduleList = program.getModuleList();
        for(Module i: moduleList){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int moduleChosen = myScanner.nextInt();
        myScanner.nextLine();
        Module myModule = moduleList.get(moduleChosen-1);
        myScanner.close();

        department.examBoardModule(cutoff,myModule, program);
    }

    private void examBoardSemester(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a minimum QCA to pass: ");
        int cutoff = myScanner.nextInt();
        myScanner.nextLine();

        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){
            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);

        System.out.println("Select a program: ");
        j = 1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        myScanner.nextLine();
        Program program = department.getPrograms().get(programChosen-1);

        System.out.println("Select a the year to run exam board on: ");
        int year = myScanner.nextInt();
        myScanner.nextLine();

        System.out.println("Select a the semester to run exam board on: ");
        int semester = myScanner.nextInt();
        myScanner.nextLine();

        myScanner.close();

        department.examBoardSemester(cutoff,semester,year,program);
    }

    private void examBoardYear(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a minimum QCA to pass: ");
        int cutoff = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){
            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);

        System.out.println("Select a program: ");
        j = 1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        myScanner.nextLine();
        Program program = department.getPrograms().get(programChosen-1);

        System.out.println("Select a the year to run exam board on: ");
        int year = myScanner.nextInt();
        myScanner.nextLine();
        myScanner.close();
        department.examBoardYear(cutoff,year,program);
    }

    private void examBoardProgram(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a minimum QCA to pass: ");
        int cutoff = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){
            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);

        System.out.println("Select a program: ");
        j = 1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        myScanner.nextLine();
        Program program = department.getPrograms().get(programChosen-1);

        myScanner.close();
        department.examBoardOverall(cutoff,program);
    }

    private void logOut(){
        admin=false;
        staff=false;
        student=false;
    }

    private void printTranscript(){
        Scanner myScanner = new Scanner(System.in);
        if(student == true){
            System.out.print("Enter your student ID: \n");
            int id = myScanner.nextInt();
            myScanner.nextLine();
            System.out.print("Enter your last name: \n");
            String lastName = myScanner.nextLine();
            boolean found =false;
            Student student = new Student(0,"","");
            for(Student i:students){
                if(id==i.getId()&& lastName.equals(i.getLastName())){
                    student = i;
                    found=true;
                }
            }

            if(found){
                System.out.println("Select a department: ");
                int j = 1;
                for(Department i:departments){
                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int departmentChosen = myScanner.nextInt();
                myScanner.nextLine();
                Department department = departments.get(departmentChosen-1);

                System.out.println("Select a program: ");
                j = 1;
                for(Program i: department.getPrograms()){

                    System.out.printf("%s) %s\n",""+j,i.getName());
                    j++;
                }
                int programChosen = myScanner.nextInt();
                myScanner.nextLine();
                Program program = department.getPrograms().get(programChosen-1);

                System.out.println(program.getTranscript(student));
            }else{
                System.out.print("\nCould not find student\n");
            }
        }else{
            int j=1;
            System.out.println("Select student: ");

            for(Student i:students){
                System.out.printf("%s) %s %s, %d\n",""+j,i.getFirstName(),i.getLastName(),i.getId());
                j++;
            }
            int choice = myScanner.nextInt();
            myScanner.nextLine();
            Student student = students.get(choice-1);

            System.out.println("Select a department: ");
            j = 1;
            for(Department i:departments){
                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            int departmentChosen = myScanner.nextInt();
            myScanner.nextLine();
            Department department = departments.get(departmentChosen-1);

            System.out.println("Select a program: ");
            j = 1;
            for(Program i: department.getPrograms()){

                System.out.printf("%s) %s\n",""+j,i.getName());
                j++;
            }
            int programChosen = myScanner.nextInt();
            Program program = department.getPrograms().get(programChosen-1);

            System.out.println(program.getTranscript(student));
        }
        myScanner.close();
    }

    public void gradeStudent(){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Select a department: ");
        int j = 1;
        for(Department i:departments){
            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int departmentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Department department = departments.get(departmentChosen-1);

        System.out.println("Select a program: ");
        j = 1;
        for(Program i: department.getPrograms()){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int programChosen = myScanner.nextInt();
        Program program = department.getPrograms().get(programChosen-1);

        System.out.println("Select a module: ");
        j = 1;
        ArrayList<Module> moduleList = program.getModuleList();
        for(Module i: moduleList){

            System.out.printf("%s) %s\n",""+j,i.getName());
            j++;
        }
        int moduleChosen = myScanner.nextInt();
        myScanner.nextLine();
        Module myModule = moduleList.get(moduleChosen-1);
        
        System.out.println("Select a faculty member: ");
        j = 1;
        ArrayList<Faculty> staffList = myModule.getFacultyList();
        for(Faculty i: staffList){

            System.out.printf("%s) %s %s\n",""+j,i.getFirstName(), i.getLastName());
            j++;
        }
        int staffChosen = myScanner.nextInt();
        Faculty myStaff = staffList.get(staffChosen-1);
        
        System.out.println("Select a student: ");
        j = 1;
        ArrayList<Student> studentList = myModule.getClassList();
        for(Faculty i: facultyList){

            System.out.printf("%s) %s %s\n",""+j,i.getFirstName(), i.getLastName());
            j++;
        }
        int studentChosen = myScanner.nextInt();
        myScanner.nextLine();
        Student myStudent = studentList.get(staffChosen-1);
        
        System.out.print("What grade is the student getting?");
        String grade = myScanner.nextLine();
        myScanner.close();
        System.out.println(myStaff.addEntry(myModule.getName(),grade,myStudent));
    }
}