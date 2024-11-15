package Administration;
public class SweeperM extends Employee{

    public SweeperM(){
        super();
    }

    public SweeperM(String name , String cnic , String phoneNumber , String gmail , String dob,int salary,String userName,String passWord){
        super(name, cnic, phoneNumber, gmail, dob,salary,userName,passWord);
        
      }

    public void loadEmp(){
        super.loadEmp();
      
    }
}