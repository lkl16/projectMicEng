import java.util.ArrayList;

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
}
