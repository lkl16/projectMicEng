import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Module Class
 *
 * @author (Liam Kelly,22346317)
 * @version (20/11/2023)
 */
public class Module
{
    private String moduleName;
    private ArrayList<Person> classList;
    public Module(String name)
    {
        this.moduleName=name;
        classList=new ArrayList<Person>();
    }
    
    
}
