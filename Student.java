/**
 * Student class
 *
 * @author (Liam Kelly, 22346317)
 * @version (v1)
 */
public class Student extends Person
{
    private int studentNum;
    private String studentStatus;
    public Student(int studentNum,String studentStatus, String firstName, String lastName)
    {
        super(firstName,lastName);
        this.studentNum=studentNum;
        this.studentStatus=studentStatus;
    }
    public int getId(){
        return studentNum;
    }
}
