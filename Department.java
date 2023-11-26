import java.util.ArrayList;

/**
 * Write a description of class Department here.
 *
 * @author Liam Kelly 22346317
 * @version 1.0
 */
public class Department
{
    private String name;
    private ArrayList<Program> programs;
   public Department(String name){
       this.name=name;
       this.programs=new ArrayList<Program>();
   }
}
