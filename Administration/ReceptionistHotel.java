package Administration;
import java.util.Scanner;

public class ReceptionistHotel extends Employee{
    private static Scanner sc = new Scanner(System.in);
    private String department;
    private String workStationLocation;
    private String skills;


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
    public void setSkills(String skills) {
        skills = skills.trim();
        if (skills != null && skills.matches("[a-zA-Z ]+")) {
            this.skills = skills;
        } else {
            System.out.println("Invalid input for skills: only alphabetic characters are allowed.");
            System.out.print("Please enter valid skills: ");
            String newInput = sc.nextLine();
            setSkills(newInput);
        }
    }

    public void setDepartment(String department) {
        department = department.trim();
        if (department != null && department.matches("[a-zA-Z ]+")) {
            this.department = department;
        } else {
            System.out.println("Invalid input for department: only alphabetic characters are allowed.");
            System.out.print("Please enter a valid department: ");
            String newInput = sc.nextLine();
            setDepartment(newInput);
        }
    }

    void setWorkStationLocation(String workStationLocation) {
        workStationLocation = workStationLocation.trim();
        if (workStationLocation != null && workStationLocation.matches("[a-zA-Z0-9 ]+")) {
            this.workStationLocation = workStationLocation;
        } else {
            System.out.println("Invalid input for work station: only alphabetic characters are allowed.");
            System.out.print("Please enter a valid work station: ");
            String newInput = sc.nextLine();
            setWorkStationLocation(newInput);
        }
       
    }
    public String getDepartment() {
        return department;
    }
    public String getWorkStationLocation() {
        return workStationLocation;
    }
    public String getSkills() {
        return skills;
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
        setDepartment(department);
        System.out.println("Enter the work station where that employe work : ");
        workStationLocation = input.nextLine();
        setWorkStationLocation(workStationLocation);
        System.out.println("Enter the skill of that employee : ");
        skills = input.nextLine();
        setSkills(skills);


    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department of that employee : " + department);
        System.out.println("Work Station of that employee : " + workStationLocation );
        System.out.println("Skills of that employee : " + skills );
    }
}