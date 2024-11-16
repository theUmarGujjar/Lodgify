package Administration;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeManager {

    Scanner input = new Scanner(System.in);


    // Static arraylists of different type 
    public static ArrayList<ReceptionistHotel> hotelReceptionistList=new ArrayList<ReceptionistHotel>(10);
    public static ArrayList<ReceptionistResturant> resturantReceptionistList=new ArrayList<ReceptionistResturant>(10);
    public static  ArrayList<DriverM> driverList=new ArrayList<DriverM>(10);
    public static ArrayList<SweeperM> sweeperList=new ArrayList<SweeperM>(10);


    // Objects of different datatype..
    Employee hotelReceptionist = new ReceptionistHotel();
    Employee driver = new DriverM();
    Employee sweeper = new SweeperM();
    Employee resturnatReceptionist = new ReceptionistResturant();


    public  void selectEmployee(String purpose){


        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Please select which type of Employee : ");
            System.out.println(" Driver");
            System.out.println(" Sweeper");
            System.out.println(" Resturant receptionist");
            System.out.println(" Hotel receptionist");
            String empType = input.nextLine();
            empType = empType.toLowerCase();
    
            if(empType.equals("driver") ){
                selectPurpose(purpose , driver);
                break;
            }
            else if(empType.equals("sweeper")){
                selectPurpose(purpose , sweeper);

                break;
            }
            else if(empType.equals("resturant receptionist") || empType.equals("resturantreceptionist")){
                selectPurpose(purpose , resturnatReceptionist);


                break;
            }
            else if(empType.equals("hotel receptionist")|| empType.equals("hotelreceptionist")){
                selectPurpose(purpose , hotelReceptionist);

                break;
            }
            else{
                System.out.println("Wrong input ...");
                System.out.println("Enter right input ...");
         
            }
    
        }
    }

    public void selectPurpose(String purpose , Employee emp){
        if(purpose.equals("add")){
            addEmp(emp);
        }
        else if(purpose.equals("remove")){
            removeAndUpdateEmp(emp , purpose);
        }
        else if(purpose.equals("update")){
            removeAndUpdateEmp(emp, purpose);
        }
    }



 // POLYMORPHISIM ..
 public  void addEmp(Employee emp){

    //check that emp refernce is instance of which class..

    if(emp instanceof DriverM){
        DriverM d1 = new DriverM();
        d1.loadEmp();
        driverList.add(d1);
    }
    else if( emp instanceof SweeperM){
        SweeperM sweeper1 = new SweeperM();
        sweeper1.loadEmp();
        sweeperList.add(sweeper1);
    }

    else if( emp instanceof ReceptionistHotel ){
        ReceptionistHotel hotelReceptionist1 = new ReceptionistHotel();
        hotelReceptionist1.loadEmp();// for testing
        hotelReceptionistList.add(hotelReceptionist1);
    }

    else if( emp instanceof ReceptionistResturant){
        ReceptionistResturant resturnatReceptionist1 = new ReceptionistResturant();
        resturnatReceptionist1.loadEmp();// for testing
        resturantReceptionistList.add(resturnatReceptionist1);
    }
}



    
    public void removeAndUpdateEmp(Employee emp , String purpose){
        String cnic;
        System.out.println("Enter the CNIC of the employee : ");
        cnic = input.nextLine();

         // testing phase..
        if(emp instanceof DriverM){
            if(purpose.equals("remove")){
                delete(driverList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(driverList,cnic);     
            }
        }


        else if( emp instanceof SweeperM){
            if(purpose.equals("remove")){
                delete(sweeperList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(sweeperList,cnic);     
            }
        }


        else if( emp instanceof ReceptionistHotel ){
            if(purpose.equals("remove")){
                delete(hotelReceptionistList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(hotelReceptionistList,cnic);     
            }        }


        else if( emp instanceof ReceptionistResturant){
            if(purpose.equals("remove")){
                delete(resturantReceptionistList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(resturantReceptionistList,cnic);     
            }      
        }
    }
    public void updateEmp(Employee emp){

        System.out.println("......You can reset the gmail , phonenumber and salary after giving the cnic ......");
        System.out.println("Enter new details");

        System.out.println();
        System.out.println();

        System.out.println("Enter new gmail");
        String gmail=input.nextLine();
        emp.setGmail(gmail);

        System.out.println("Enter new salary");

        if(!(input.hasNextInt())){
            System.out.println();
            System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
            System.out.println();
            input.nextLine();
        
        }
        int salary=input.nextInt();

       emp.setSalary(salary);
       input.nextLine();

        System.out.println("enter new phone number");
        String phoneNumber=input.nextLine();
        emp.setPhoneNumber(phoneNumber);
        
    }


    public <T extends Employee>void updateEmployee(ArrayList<T> emp ,String cnic){
        Boolean found = false;

        for(int i = 0 ; i< emp.size() ; i++){
            if(cnic.equals(emp.get(i).getCnic())){
                System.out.println("cnic matched");
                updateEmp(emp.get(i));
                found = true;
                System.out.println("employee updated");// testing..

            }
        }
        if(!found){
            System.out.println("No employee in database with that  cnic ");
        }
    }
    


public <T extends Employee>void delete(ArrayList<T> emp ,String cnic){
    Boolean found = false;




    for(int i = 0 ; i< emp.size() ; i++){


        if(cnic.equals(emp.get(i).getCnic())){
            emp.remove(i);
            found = true;
            System.out.println("employee with this cnic is removed");
        }
    }
    if(!found){
        System.out.println("No employee in database with that  cnic ");
    }
}


public <T extends Employee>void setinfo(ArrayList<T> emp ,String cnic,String gmail,int salary,String phoneNumber){
    Boolean found = false;
    for(int i = 0 ; i< emp.size() ; i++){
        if(cnic.equals(emp.get(i).getCnic())){
           
            emp.get(i).setGmail(gmail);
            emp.get(i).setSalary(salary);
            emp.get(i).setPhoneNumber(phoneNumber);
           
           
           
            found = true;
        }
    }
    if(!found){
        System.out.println("No employee in database with that  cnic ");
    }
}



    public void displayEmployee() {

        if (hotelReceptionistList.isEmpty()) {
            System.out.println("                             **No data available for hotel receptionists**");
        } else {
            System.out.println("                             **Displaying hotel receptionists**");
            for (ReceptionistHotel receptionist : hotelReceptionistList) {
                receptionist.displayInfo();
                System.out.println("----------------------------");


            }
        }

        if (resturantReceptionistList.isEmpty()) {



            System.out.println("                         **No data available for restaurant receptionists**");
        } else {
            System.out.println("                         **Displaying restaurant receptionists**");
            for (ReceptionistResturant restaurant : resturantReceptionistList) {
                restaurant.displayInfo();
                System.out.println("----------------------------");

            }
        }

        if (driverList.isEmpty()) {
            System.out.println("                            **No data available for driver**");
        } else {
            System.out.println("                            **Displaying driver**");
            for (DriverM driver : driverList) {
                driver.displayInfo();
                System.out.println("----------------------------");

            }
        }

        if (sweeperList.isEmpty()) {
            System.out.println("                         **No data available for sweeper** ");
        } else {
            System.out.println("                            **Displaying sweeper** ");
            for (SweeperM sweeper : sweeperList) {
                sweeper.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }

}