package Administration;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomManager {
    static Scanner input=new Scanner(System.in);
    public static int getValidIntInput(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextInt()) { 
          System.out.println("Invalid input.You must enter an integer.");
          input.nextLine(); 
        }
        return input.nextInt();
      }

    public static ArrayList<Room> roomlist=new ArrayList<Room>(10);

    void addRoom(){
    Room r=new Room();
    System.out.println("Enter the details of room");
    while(true){
        boolean cont = false;
  
    int rNumber = getValidIntInput("Room number: ");
    input.nextLine();

    for(int i=0;i<roomlist.size();i++){
  
        if(rNumber==roomlist.get(i).getrNumber()){
            System.out.println("There is another room with this room number.Enter another room number");
            cont = true;
            break;
        }

    }
    if(cont){
        continue;
    }
    r.setrNumber(rNumber);
    break;
    }
    int rPrice = getValidIntInput("Room price : ");
    input.nextLine();
    r.setrPrice(rPrice);
    System.out.println("Room type : ");
    String rType = input.nextLine();
    r.setrType(rType);
    int rBeds = getValidIntInput("Number of beds : ");
    input.nextLine();
    r.setrBeds(rBeds);
    System.out.println("room status : ");
    String rStatus = input.nextLine();
    r.setrStatus(rStatus);
    System.out.println("room Floor : ");
    String rFloor = input.nextLine();
    r.setrFloor(rFloor);
    System.out.println("room availablility : ");
    while(true){    
      System.out.println("You can only enter yes / no");
    
      String rAvailability = input.nextLine().trim(); 
    
      if(!(rAvailability.equals("yes") || rAvailability.equals("no"))){
          
        System.out.println("Invalid input ");
        System.out.println("Enter again");    
      }
    else{
        r.setrAvailability(rAvailability);
      break;
    }
   
    }
    
    roomlist.add(r);
    System.out.println("room added");

    
}

//removing room
        void removeRoom(){
            System.out.println("Enter the number of the you want to remove");
           int  rNumber = getValidIntInput("Room number: ");
            input.nextLine();
        Boolean found = false;
        for(int i = 0 ; i< roomlist.size() ; i++){
            if(rNumber == roomlist.get(i).getrNumber()){
                System.out.println("you want to remove " + roomlist.get(i).getrNumber());
                roomlist.remove(i);
    
                found = true;
                System.out.println("car with id : "+ rNumber + "is removed");
            }
        }
        if(!found){
            System.out.println("No room  in database with that room number ");
        }
    }


    

//updaing rooms after matching room no
void updateRooms(){
    System.out.println("You can reset the room price, room type and number of beds and room availability in a room after giving its room number ");
    System.out.println();    
    int rNumber=getValidIntInput("Enter the number of room you want to update");
   for(Room r:roomlist){
   
    if(r.getrNumber()==rNumber){
        System.out.println("Room number matched ");
        System.out.println("Enter new details");
        int rPrice = getValidIntInput("Room price :");
        input.nextLine();
        System.out.println("Room type : ");
        String  rType = input.nextLine();
        int rBeds = getValidIntInput("Number of beds :");
        input.nextLine();
        System.out.println("room availablility : ");
        while(true){    
          System.out.println("You can only enter yes / no");
        
          String rAvailability = input.nextLine().trim(); 
        
          if(!(rAvailability.equals("yes") || rAvailability.equals("no"))){
              
            System.out.println("Invalid input ");
            System.out.println("Enter again");    
          }
        else{
            r.setrAvailability(rAvailability);
          break;
        }
       
        }
        
      r.setrPrice(rPrice);
      r.setrType(rType);
      r.setrBeds(rBeds);
     System.out.println("Room updated");
     return;
    }
   }System.out.println("There is no room with this number");
}
//displaying room
void displayRooms(){
    if(roomlist.isEmpty()){
        System.out.println("there is no room in the list");
    }else{
        for(Room r:roomlist){
            r.show(); //displayinfo
            System.out.println("----------------------------");

        }
    }
}

}


