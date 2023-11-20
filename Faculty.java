/**
 * Student class
 *
 * @author (Liam Kelly, 22346317)
 * @version (v1)
 */
public class Faculty extends Person
{
    private String teachingRole; //ie, lecturer, tutorials, etc.
    private String password ="example";
    public Faculty(String teachingRole,String firstName, String lastName)
    {
        super(firstName,lastName);
        this.teachingRole=teachingRole;
    }
    @Override
    
}