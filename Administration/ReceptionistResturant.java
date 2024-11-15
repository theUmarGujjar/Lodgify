package Administration;

public class ReceptionistResturant extends Employee{

String department;
String workStationLocation;
String skills;

public ReceptionistResturant(String name , String cnic , String phoneNumber , String gmail , String dob,int salary,String department,String workStationLocation,String skills,String userName,String passWord){
    super(name, cnic, phoneNumber, gmail, dob,salary,userName,passWord);
    setDepartment(department);
    setSkills(skills);
    setWorkStationLocation(workStationLocation);
    
  }

  public ReceptionistResturant(){
    super();
    
  }

public String getDepartment() {
    return department;
}
public void setDepartment(String department) {
    this.department = department;
}
public String getWorkStationLocation() {
    return workStationLocation;
}
public void setWorkStationLocation(String workStationLocation) {
    this.workStationLocation = workStationLocation;
}
public String getSkills() {
    return skills;
}
public void setSkills(String skills) {
    this.skills = skills;
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
    
}
