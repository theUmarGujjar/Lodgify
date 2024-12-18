package Administration;

import java.util.Scanner;

public class Room{
    private static final Scanner scanner = new Scanner(System.in);

    // Encapsulated instance variables..
    private int rNumber;
    private int rPrice;
    private String rType;
    private int rBeds;
    private String rStatus;
    private String rFloor;
    private String rAvailability;

    public Room(){

    }


    //constructor..
    public Room(int rNumber , int rPrice , String rType , int rBeds , String rStatus , String rFloor ,String rAvailability){
        setrNumber(rNumber);
        setrPrice(rPrice);
        setrType(rType);
        setrBeds(rBeds);
        setrStatus(rStatus);
        setrFloor(rFloor);
        setrAvailability(rAvailability);

    }

    // setter functions..

    void setrInfo(int rNumber , int rPrice , String rType , int rBeds , String rStatus , String rFloor){
        setrNumber(rNumber);
        setrPrice(rPrice);
        setrType(rType);
        setrBeds(rBeds);
        setrStatus(rStatus);
        setrFloor(rFloor);
        setrAvailability(rAvailability);

    }

    void setrNumber(int rNumber){
        this.rNumber = rNumber;
    }
    void setrPrice(int rPrice){
        this.rPrice = rPrice;
    }
    public void setrType(String rType) {
        if (rType != null && rType.matches("[a-zA-Z ]+")) {
            this.rType = rType;
        } else {
            System.out.println("Invalid input: only alphabetic characters are allowed.");
            System.out.print("Please enter a valid rType: ");
            String newInput = scanner.nextLine();
            setrType(newInput);
        }
    }
    void setrBeds(int rBeds){
        this.rBeds = rBeds;
    }
    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }

    void setrFloor(String rFloor) {
        if (rFloor != null && rFloor.matches("[a-zA-Z ]+")) {
            this.rFloor = rFloor;
        } else {
            System.out.println("Invalid input for rFloor: only alphabetic characters are allowed.");
            System.out.print("Please enter a valid rFloor: ");
            String newInput = scanner.nextLine();
            setrFloor(newInput);
        }
    }

    public void setrAvailability(String rAvailability) {
        this.rAvailability = rAvailability;
    }



    //getters functions..
    public int getrNumber(){
        return rNumber;
    }
    public int getrPrice(){
        return rPrice;
    }
    public String getrType(){
        return rType;
    }
    public int getrBeds(){
        return rBeds;
    }
    public String getrStatus(){
        return rStatus;
    }
    public String getrFloor(){
        return rFloor;
    }
    public String getrAvailability(){
        return rAvailability;
    }

    public void show(){
        System.out.println("Room number is : " + rNumber);
        System.out.println("Room price is : " + rPrice);
        System.out.println("Room type is : " + rType);
        System.out.println("Room beds is : " + rBeds);
        System.out.println("Room status is : " + rStatus);
        System.out.println("Room floor is : " + rFloor);
        System.out.println("Room avaialbility is : " + rAvailability);

        System.out.println();
    }

}