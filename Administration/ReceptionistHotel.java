package Administration;
import java.util.Scanner;

public class ReceptionistHotel extends Employee{

    String department;
    String workStationLocation;
    String skills;
    

    Scanner input = new Scanner(System.in);
    public ReceptionistHotel(){
        super();
    };
    
    public ReceptionistHotel(String name , String cnic , String phoneNumber , String gmail , String dob,int salary,String department,String workStationLocation,String skills,String userName,String passWord){
        super(name, cnic, phoneNumber, gmail, dob,salary,userName,passWord);
        setDepartment(department);
        setSkills(skills);
        setWorkStationLocation(workStationLocation);
        
      }
    public String getDepartment() {
        return department;
    }
     void setDepartment(String department) {
        this.department = department;
    }
    public String getWorkStationLocation() {
        return workStationLocation;
    }
     void setWorkStationLocation(String workStationLocation) {
        this.workStationLocation = workStationLocation;
    }
    public String getSkills() {
        return skills;
    }
  void setSkills(String skills) {
        this.skills = skills;
    }
    public Scanner getInput() {
        return input;
    }
    void setInput(Scanner input) {
        this.input = input;
    }
   

    @Override
    public void loadEmp(){

        super.loadEmp();

        System.out.println("Enter the department of that employee : ");
        department = input.nextLine();
        System.out.println("Enter the work station where that employe work : ");
        workStationLocation = input.nextLine();
        System.out.println("Enter the skill of that employee : ");
        skills = input.nextLine();


    }
    public void  displayInfo(){
        super.displayInfo();
        System.out.println("Department of that employee : " + department);
        System.out.println("Work Station of that employee : " + workStationLocation );
        System.out.println("Skills of that employee : " + skills );

    }
}