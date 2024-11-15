package Administration;

import java.util.Scanner;

public class Admin {


  static EmployeeManager emp = new EmployeeManager();
  static CarManager carManager = new CarManager();
  static RoomManager roomManager = new RoomManager();
  static Scanner input = new Scanner(System.in);
  

  
  public static void adminMain() {
    System.out.println("##################################### Welcome to Admin Portal #####################################");

    boolean mainLoop = true;
    while (mainLoop) {
      System.out.println("which of the following do you want to manage");
      System.out.println("Press 1 for cars");
      System.out.println("Press 2 for employees ");
      System.out.println("Press 3 for rooms ");
      System.out.println("Enter 0 to exit ");
      System.out.println("############################################################################################");


      String num = input.nextLine();

      switch (num) {
        case "1":
         boolean run = true;
          while (run) {

          System.out.println("##################################### Cars #####################################");
          selection();// selection of operation like add remove update
          String choice = input.nextLine();

            if (choice.equals("1")) {
            int n = getValidIntInput("How many cars do you want to add?\nEnter 0 if you want to go back");

            input.nextLine();
              for (int i = 0; i < n; i++) {
              carManager.addCar();
               }
            } 
            else if (choice.equals("2")) {
             // removing car
             int no ;
             while(true){
              no = getValidIntInput("How many cars do you want to remove?\nEnter 0 if you want to go back");
              input.nextLine();
              if(no>carManager.carlist.size()){
                System.out.println("You can't remove " + no + " cars because there are only " + carManager.carlist.size() + "cars available.");
                System.out.println("Select number of cars according to available cars");
               
              }else{
                break;
              }
             }
           
              for (int i = 0; i < no; i++) {
              carManager.removeCar();
               }

            }
             else if (choice.equals("3")) {
            //updating car
              int n;
              while(true){
               n= getValidIntInput("enter the number of cars you want to update \n Enter 0 if you want to go back");
              input.nextLine();
              if(n>carManager.carlist.size()){
                System.out.println("You can't update " + n + " cars because there are only " + carManager.carlist.size() + "cars available.");
                System.out.println("Select number of cars according to available cars");
              }else{
                break;
              }
              }
              for (int i = 0; i < n; i++) {
              carManager.updateCar();
              }
             } 
            else if (choice.equals("4")){
            carManager.displayCars();
            }
            else if (choice.equals("0")) {
              run = false;

            } else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "2":
        System.out.println("##################################### Employees #####################################");

          boolean go = true;
          while (go) {
             selection();
            String choice = input.nextLine();
            if (choice.equals("1")) {
              int no = getValidIntInput("How many employees do you want to add");
              input.nextLine();
              for (int i = 0; i < no; i++) {
                emp.selectEmployee("add");
                 
               
              }

            } else if (choice.equals("2")) {
              // removing employee
              int no = getValidIntInput("How many employees do you want to remove");
              input.nextLine();

              for (int i = 0; i < no; i++) {

                emp.selectEmployee("remove");
              }

            } else if (choice.equals("3")) {
              // updating employee
              int no = getValidIntInput("How many employees do you want to update");
              input.nextLine();

              for (int i = 0; i < no; i++) {
                emp.selectEmployee("update");
              }

            } else if (choice.equals("4")) {
              emp.displayEmployee();

            } else if (choice.equals("0")) {
              go = false;

            } else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "3":
        System.out.println("##################################### Rooms #####################################");

          boolean move = true;
          while (move) {
            selection();
            String choice = input.nextLine();

            if (choice.equals("1")) {
              // adding rooms
              int n = getValidIntInput("How many rooms do you want to add\nEnter 0 if you want to go back");
              input.nextLine();

              for (int i = 0; i < n; i++) {
              
                roomManager.addRoom();
              }

            } else if (choice.equals("2")) {
              // removing rooms
              int no;
              while(true){
                no= getValidIntInput("enter the number of rooms you want to remove\n Enter 0 if you want to go back");
               input.nextLine();
               if(no>roomManager.roomlist.size()){
                 System.out.println("You can't remove " + no + " rooms because there are only " + roomManager.roomlist.size() + "rooms available.");
                 System.out.println("Select number of rooms according to available rooms");
               }else{
                 break;
               }
               }
              for (int i = 0; i < no; i++) {
                roomManager.removeRoom();
              }
            } else if (choice.equals("3")) {
              // updating car
              int n;
               while(true){
               n = getValidIntInput("How many rooms do you want to update \n Enter 0 if you want to go back");
              input.nextLine();
               if(n>roomManager.roomlist.size()){
                 System.out.println("You can't update " + n + " rooms because there are only " + roomManager.roomlist.size() + "rooms  available.");
                 System.out.println("Select number of rooms according to available rooms");
               }else{
                 break;
               }
               }
              for (int i = 0; i < n; i++) {
                roomManager.updateRooms();
              }

            } else if (choice.equals("0")) {
              move = false;
            }
            else if (choice.equals("4")){
              roomManager.displayRooms();
              }
            else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "0": 
          System.out.println("############################################################################################");
          mainLoop = false;
          break;

        default:
          System.out.println("invalid selection.Enter integer");
          break;
      }

    }
  }

  public static void selection() {
    System.out.println("Press 1 to add  ");
    System.out.println("Press 2 to remove ");
    System.out.println("Press 3 to update");
    System.out.println("Press 4 to display");
    System.out.println("Press 0 to exit");
    System.out.println("############################################################################################");

  } 


  public static int getValidIntInput(String prompt) {
    System.out.println(prompt);
    while (!input.hasNextInt()) { 
      System.out.println("Invalid input.You must enter an integer.");
      input.nextLine(); 
    }
    return input.nextInt();
  }


}