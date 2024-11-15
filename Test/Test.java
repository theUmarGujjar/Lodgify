package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Administration.Admin;
import Administration.Car;
import Administration.CarManager;
import Administration.DriverM;
import Administration.EmployeeManager;
import Administration.ReceptionistHotel;
import Administration.ReceptionistResturant;
import Administration.Room;
import Administration.RoomManager;
import Administration.SweeperM;
import HotelReceptionist.Booking;
import HotelReceptionist.PersonWhoBook;
import RestaurantManagement.FoodItem;
import RestaurantManagement.Menu;
import RestaurantManagement.Order;
import RestaurantManagement.OrderItem;
import RestaurantManagement.Restaurant;
import RestaurantManagement.SizePriceQuantity;
import Staff.Run;



public class Test {
 public static void main (String [] args){
    Database read=()->{
    try (BufferedReader reader = new BufferedReader(new FileReader("Database.txt"))) {
        int roomListSize = Integer.parseInt(reader.readLine()); // Read the list size
    
        RoomManager.roomlist.clear(); // Clear the ArrayList before loading data
    
        for (int i = 0; i < roomListSize; i++) {
    
            String rAvailability = reader.readLine();
            int rBeds = Integer.parseInt(reader.readLine()); 
            String rFloor = reader.readLine();
            int rNumber = Integer.parseInt(reader.readLine()); 
            int rPrice = Integer.parseInt(reader.readLine()); 
            String rStatus = reader.readLine();
            String rType = reader.readLine();
            reader.readLine(); 
            Room room = new Room(rNumber,rPrice,rType,rBeds,rStatus,rFloor,rAvailability);
            RoomManager.roomlist.add(room); // Add the room to the ArrayList
        }
        
        
        int carListSize=Integer.parseInt(reader.readLine());
        CarManager.carlist.clear();
        for(int i=0;i<carListSize;i++){
            String model=reader.readLine();
            int id=Integer.parseInt(reader.readLine());
            String L_plateno=reader.readLine();
            String availability=reader.readLine();
            reader.readLine();
            Car car=new Car(id, model, L_plateno, availability);

            CarManager.carlist.add(car);
            
        }
        int driverListSize=Integer.parseInt(reader.readLine());
        EmployeeManager.driverList.clear();
        for(int i=0;i<driverListSize;i++){
            String name=reader.readLine();
            String cnic=reader.readLine();
            String gmail=reader.readLine();
            String phoneNumber=reader.readLine();
            String dob=reader.readLine();
            int salary=Integer.parseInt(reader.readLine());
            String userName=reader.readLine();
            String passWord=reader.readLine();


           reader.readLine();
            DriverM driver=new DriverM(name,cnic,phoneNumber,gmail,dob,salary,userName,passWord);
            EmployeeManager.driverList.add(driver);
         

        }
        int sweeperListSize=Integer.parseInt(reader.readLine());
        EmployeeManager.sweeperList.clear();
        for(int i=0;i<sweeperListSize;i++){
            String name=reader.readLine();
            String cnic=reader.readLine();
            String gmail=reader.readLine();
            String phoneNumber=reader.readLine();
            String dob=reader.readLine();
            int salary=Integer.parseInt(reader.readLine());
            String userName=reader.readLine();
            String passWord=reader.readLine();

           reader.readLine();
            SweeperM sweeper=new SweeperM(name,cnic,phoneNumber,gmail,dob,salary,userName,passWord);
            EmployeeManager.sweeperList.add(sweeper);

        }

       int hotelreceptionistListSize=Integer.parseInt(reader.readLine());
       EmployeeManager.hotelReceptionistList.clear();
       for(int i=0;i<hotelreceptionistListSize;i++){
           String name=reader.readLine();
           String cnic=reader.readLine();
           String gmail=reader.readLine();
           String phoneNumber=reader.readLine();
           String dob=reader.readLine();
           int salary=Integer.parseInt(reader.readLine());
           String department=reader.readLine();
           String workStationLocation=reader.readLine();
           String skills=reader.readLine();
           String userName=reader.readLine();
           String passWord=reader.readLine();
           reader.readLine();
           ReceptionistHotel hrecep=new ReceptionistHotel(name,cnic,phoneNumber,gmail,dob,salary,department,workStationLocation,skills,userName,passWord);
           EmployeeManager.hotelReceptionistList.add(hrecep);
       }
        
      int resturantreceptionistListSize=Integer.parseInt(reader.readLine());
      EmployeeManager.resturantReceptionistList.clear();
      for(int i=0;i<resturantreceptionistListSize;i++){
          String name=reader.readLine();
          String cnic=reader.readLine();
          String gmail=reader.readLine();
          String phoneNumber=reader.readLine();
          String dob=reader.readLine();
          int salary=Integer.parseInt(reader.readLine());
          String department=reader.readLine();
          String workStationLocation=reader.readLine();
          String skills=reader.readLine();
          String userName=reader.readLine();
          String passWord=reader.readLine();
          reader.readLine();
          ReceptionistResturant restRecep=new ReceptionistResturant(name,cnic,phoneNumber,gmail,dob,salary,department,workStationLocation,skills,userName,passWord);
          EmployeeManager.resturantReceptionistList.add(restRecep);
      }


        int allPersonsListSize=Integer.parseInt(reader.readLine());
        Booking.database.clear();
        for(int i=0;i<allPersonsListSize;i++){
            String name=reader.readLine();
            String cnic=reader.readLine();
            String phnNum=reader.readLine();
            String gmail=reader.readLine();
            String dob=reader.readLine();
            int rNum=Integer.parseInt(reader.readLine());
            reader.readLine();
            PersonWhoBook allPersons=new PersonWhoBook(name, cnic, phnNum, gmail, dob, rNum);
            Booking.database.add(allPersons);
        }

        int bookPersListSize=Integer.parseInt(reader.readLine());
        Booking.pBook.clear();
        for(int i=0;i<bookPersListSize;i++){
            String name=reader.readLine();
            String cnic=reader.readLine();
            String phnNum=reader.readLine();
            String gmail=reader.readLine();
            String dob=reader.readLine();
            int rNum=Integer.parseInt(reader.readLine());
            reader.readLine();
            PersonWhoBook bookP=new PersonWhoBook(name, cnic, phnNum, gmail, dob, rNum);
            Booking.pBook.add(bookP);
        }

        int allRoomListSize=Integer.parseInt(reader.readLine());
        Booking.rLs1.clear();
        for(int i=0; i<allRoomListSize;i++){
            String rAvailability = reader.readLine();
            int rBeds = Integer.parseInt(reader.readLine()); 
            String rFloor = reader.readLine();
            int rNumber = Integer.parseInt(reader.readLine()); 
            int rPrice = Integer.parseInt(reader.readLine()); 
            String rStatus = reader.readLine();
            String rType = reader.readLine();
            reader.readLine(); 
            Room room=new Room(rNumber, rPrice, rType, rBeds, rStatus, rFloor, rAvailability);
            Booking.rLs1.add(room);
        }


        int bookedRoomListSize=Integer.parseInt(reader.readLine());
        Booking.rBook.clear();
        for(int i=0; i<bookedRoomListSize;i++){
            String rAvailability = reader.readLine();
            int rBeds = Integer.parseInt(reader.readLine()); 
            String rFloor = reader.readLine();
            int rNumber = Integer.parseInt(reader.readLine()); 
            int rPrice = Integer.parseInt(reader.readLine()); 
            String rStatus = reader.readLine();
            String rType = reader.readLine();
            reader.readLine(); 
            Room room=new Room(rNumber, rPrice, rType, rBeds, rStatus, rFloor, rAvailability);
            Booking.rBook.add(room);
        }



         // Reading Menu Data
            int menuSize = Integer.parseInt(reader.readLine()); // Read number of items in the menu
            // Clear old menu items before reading new ones
            Menu.menuItems.clear();

            for (int i = 0; i < menuSize; i++) {
                String name = reader.readLine().trim(); // Read item name
                int sizeCount = Integer.parseInt(reader.readLine().trim()); // Read size count

                ArrayList<SizePriceQuantity> sizePriceQuantities = new ArrayList<>();
                for (int j = 0; j < sizeCount; j++) {
                    String size = reader.readLine().trim();
                    double price = Double.parseDouble(reader.readLine().trim());
                    int quantity = Integer.parseInt(reader.readLine().trim());
                    reader.readLine(); // To consume the blank line

                    SizePriceQuantity spq = new SizePriceQuantity(size, price, quantity);
                    sizePriceQuantities.add(spq);
                }

                FoodItem foodItem = new FoodItem(name, sizePriceQuantities);
                Menu.menuItems.add(foodItem); // Add food item to the list
            }

                    
            /// Reading Orders
            int orderListSize = Integer.parseInt(reader.readLine().trim());
            Restaurant.orders.clear(); // Clear old orders before reading new ones

            for (int i = 0; i < orderListSize; i++) {
                int fileOrderId = Integer.parseInt(reader.readLine().trim()); // Read order ID
                int itemCount = Integer.parseInt(reader.readLine().trim()); // Number of items in the order

                Order order = new Order(new ArrayList<>(), false); 
                //Order.setId(fileOrderId); // Explicitly set the ID for the order

                for (int j = 0; j < itemCount; j++) {
                    String itemName = reader.readLine().trim();
                    int quantity = Integer.parseInt(reader.readLine().trim());
                    String size = reader.readLine().trim();
                    double price = Double.parseDouble(reader.readLine().trim());

                    OrderItem orderItem = new OrderItem(itemName, size, quantity, price);
                    order.getMyorder().add(orderItem);
                }

                Restaurant.orders.add(order); // Add order to the list
            }

    
        System.out.println("Data has been loaded from database.txt successfully.");
    } catch (IOException e) {
        e.printStackTrace(); // Handle any I/O exceptions
    } catch (NumberFormatException e) {
        System.out.println("Error parsing integer values from the file.");
        e.printStackTrace();
    }
};
    read.data();
    copyRight();
    while (true) {

        //Variables for authentication..
        String username = null;
        String password = null;
        String number;

        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("********************************************************************************************");
            System.out.println();

            
            System.out.println("                                Press 1 to sign in as an admin : ");
            System.out.println("                                Press 2 to sign in as an HotelReceptionist : ");
            System.out.println("                                Press 3 to sign in as an Restutant Receptionist : ");
            System.out.println("                                Press 4 to sign in as staff member : ");
            System.out.println("                                Press 5 write data into file : ");

            System.out.println("                                Press 0 to exit : ");
            System.out.println();
            System.out.println("********************************************************************************************");
    
    
            number = input.nextLine();
            if(number.equals("1")||number.equals("2")||number.equals("3")||number.equals("4")||number.equals("5")||number.equals("0"))
            {
                System.out.println("                                      ***");
                break;
            }
            else{
                System.out.println("                               WRONG INPUT ::: ENTER GIVEN INTEGERS ONLY  ");

            }
            
        }

       

         if(number.equals("0")){

            System.out.println();
            System.out.println("  *********************");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("  *********************");
            break;
        }

        System.out.print("Enter UserName :  ");
        username = input.nextLine();
        username = username.toLowerCase();
        System.out.print("Enter Password :  ");
        password = input.nextLine();
        password = password.toLowerCase();



        Boolean authenticationCheck = false;


        if(number.equals("1")){
            if(username.equals("admin")){
                if(password.equals("lodgify")){
                    authenticationCheck = true;
                    Admin.adminMain();
                }
            }
        }
        else if (number.equals("2")) {
            for(int i = 0 ; i < EmployeeManager.hotelReceptionistList.size() ;i++){
                if(EmployeeManager.hotelReceptionistList.get(i).aut.checkAuthorization(username , password)){
                    Booking.bookingMain();
                }
            }
        }
        else if (number.equals("3")){
            for(int i = 0 ; i < EmployeeManager.resturantReceptionistList.size() ;i++){
                if(EmployeeManager.resturantReceptionistList.get(i).aut.checkAuthorization(username , password)){
                    Restaurant.resturantMain();
                }
            }
        }
        else if(number.equals("4")){
            for(int i = 0 ; i < EmployeeManager.driverList.size() ;i++){
                if(EmployeeManager.driverList.get(i).aut.checkAuthorization(username , password)){
                    Run.staffMain();
                }
            }

            for(int i = 0 ; i < EmployeeManager.sweeperList.size() ;i++){
                if(EmployeeManager.sweeperList.get(i).aut.checkAuthorization(username , password)){
                    Run.staffMain();
                }
            }

        }
   
        

       
        else if(number.equals("5")){
            if(username.equals("database")){
                if(password.equals("database")){
                    authenticationCheck = true;

                    System.out.println("writing to file");

                Database write=()->{

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Database.txt"))) {
                        // Write the size of the room list
                        writer.write(String.valueOf(RoomManager.roomlist.size()));
                        writer.newLine();
                    
                        for (Room room : RoomManager.roomlist) {
                            writer.write(room.getrAvailability() != null ? room.getrAvailability() : "N/A");
                            writer.newLine();
                    
                            writer.write(String.valueOf(room.getrBeds()));
                            writer.newLine();
                    
                            writer.write(room.getrFloor() != null ? room.getrFloor() : "N/A");
                            writer.newLine();
                    
                            writer.write(String.valueOf(room.getrNumber()));
                            writer.newLine();
                    
                            writer.write(String.valueOf(room.getrPrice()));
                            writer.newLine();
                    
                            writer.write(room.getrStatus() != null ? room.getrStatus() : "N/A");
                            writer.newLine();
                    
                            writer.write(room.getrType() != null ? room.getrType() : "N/A");
                            writer.newLine();
                    
                            writer.newLine(); // Move to the next line after each room object
                        }
                    
                        writer.write(String.valueOf(CarManager.carlist.size()));
                        writer.newLine();
                        for (Car car : CarManager.carlist) {
                           
                    
                            writer.write(car.getModel() != null ? car.getModel() : "N/A");
                            writer.newLine();

                            writer.write(String.valueOf(car.getId()));
                            writer.newLine();
                    
                            writer.write(car.getL_plateno() != null ? car.getL_plateno() : "N/A");
                            writer.newLine();
                    
                            writer.write(car.getAvailability() != null ? car.getAvailability() : "N/A");
                            writer.newLine();
                    
                            writer.newLine();
                        }
                        writer.write(String.valueOf(EmployeeManager.driverList.size()));
                        writer.newLine();
                        for(DriverM driver:EmployeeManager.driverList){
                            writer.write(driver.getName() != null ? driver.getName() : "N/A");
                            
                            writer.newLine();
                            writer.write(driver.getCnic() != null ? driver.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(driver.getGmail() != null ? driver.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(driver.getPhoneNumber() != null ? driver.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(driver.getDob() != null ? driver.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(driver.getSalary()));
                            writer.newLine();
                            writer.write(driver.aut.getUserName()  !=null ? driver.aut.getUserName() : "N/A");
                            writer.newLine();
                            writer.write(driver.aut.getPassWord()  !=null ? driver.aut.getPassWord() : "N/A");
                            writer.newLine();;
                           

                            writer.newLine();
                            
                   


                           
                        }
                        writer.write(String.valueOf(EmployeeManager.sweeperList.size()));
                        writer.newLine();
                        for(SweeperM sweeper:EmployeeManager.sweeperList){
                            writer.write(sweeper.getName() != null ? sweeper.getName() : "N/A");
                            writer.newLine();
                            writer.write(sweeper.getCnic() != null ? sweeper.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(sweeper.getGmail() != null ? sweeper.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(sweeper.getPhoneNumber() != null ? sweeper.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(sweeper.getDob() != null ? sweeper.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(sweeper.getSalary()));
                            writer.newLine();
                            writer.write(sweeper.aut.getUserName()  !=null ? sweeper.aut.getUserName() : "N/A");
                            writer.newLine();
                            writer.write(sweeper.aut.getPassWord()  !=null ? sweeper.aut.getPassWord() : "N/A");
                            writer.newLine();

                            writer.newLine();

                            System.out.println("Sweeper written");//testimg
                           
                        }
                        writer.write(String.valueOf(EmployeeManager.hotelReceptionistList.size()));
                        writer.newLine();
                        for(ReceptionistHotel receptionist:EmployeeManager.hotelReceptionistList){
                            writer.write(receptionist.getName() != null ? receptionist.getName() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getCnic() != null ? receptionist.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getGmail() != null ? receptionist.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getPhoneNumber() != null ? receptionist.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getDob() != null ? receptionist.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(receptionist.getSalary()));
                            writer.newLine();
                            writer.write(receptionist.getDepartment() != null ? receptionist.getDepartment() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getWorkStationLocation() != null ? receptionist.getWorkStationLocation() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getSkills() != null ? receptionist.getSkills() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.aut.getUserName()  !=null ? receptionist.aut.getUserName() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.aut.getPassWord()  !=null ? receptionist.aut.getPassWord() : "N/A");
                            writer.newLine();

                            writer.newLine();
                            System.out.println("hotel written");//testimg


                           
                        }

                        writer.write(String.valueOf(EmployeeManager.resturantReceptionistList.size()));
                        writer.newLine();
                        for(ReceptionistResturant receptionist:EmployeeManager.resturantReceptionistList){
                            writer.write(receptionist.getName() != null ? receptionist.getName() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getCnic() != null ? receptionist.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getGmail() != null ? receptionist.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getPhoneNumber() != null ? receptionist.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getDob() != null ? receptionist.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(receptionist.getSalary()));
                            writer.newLine();
                            writer.write(receptionist.getDepartment() != null ? receptionist.getDepartment() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getWorkStationLocation() != null ? receptionist.getWorkStationLocation() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.getSkills() != null ? receptionist.getSkills() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.aut.getUserName()  !=null ? receptionist.aut.getUserName() : "N/A");
                            writer.newLine();
                            writer.write(receptionist.aut.getPassWord()  !=null ? receptionist.aut.getPassWord() : "N/A");
                            writer.newLine();

                            writer.newLine();
                            System.out.println("rst written");//testimg


                           
                        }

                        //person database arraylists 
                        writer.write(String.valueOf(Booking.database.size()));
                        writer.newLine();
                        for(PersonWhoBook bookedPerson:Booking.database){
                            writer.write(bookedPerson.getName() !=null ? bookedPerson.getName() : "N/A");
                            writer.newLine();
                            writer.write(bookedPerson.getCnic() !=null ? bookedPerson.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(bookedPerson.getPhoneNumber() !=null ? bookedPerson.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(bookedPerson.getGmail() !=null ? bookedPerson.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(bookedPerson.getDob() !=null ? bookedPerson.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(bookedPerson.getrNumber()));
                            writer.newLine();

                            writer.newLine();
                        }

                        //pBook arraylist
                        writer.write(String.valueOf(Booking.pBook.size()));
                        writer.newLine();
                        for(PersonWhoBook bookingPerson:Booking.pBook){
                            writer.write(bookingPerson.getName() !=null ? bookingPerson.getName() : "N/A");
                            writer.newLine();
                            writer.write(bookingPerson.getCnic() !=null ? bookingPerson.getCnic() : "N/A");
                            writer.newLine();
                            writer.write(bookingPerson.getPhoneNumber() !=null ? bookingPerson.getPhoneNumber() : "N/A");
                            writer.newLine();
                            writer.write(bookingPerson.getGmail() !=null ? bookingPerson.getGmail() : "N/A");
                            writer.newLine();
                            writer.write(bookingPerson.getDob() !=null ? bookingPerson.getDob() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(bookingPerson.getrNumber()));
                            writer.newLine();

                            writer.newLine();
                        }

                        //arraylist of allRooms
                        writer.write(String.valueOf(Booking.rLs1.size()));
                        writer.newLine();
                        for(Room rooms:Booking.rLs1){
                            writer.write(rooms.getrAvailability() != null ? rooms.getrAvailability() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(rooms.getrBeds()));
                            writer.newLine();   
                            writer.write(rooms.getrFloor() != null ? rooms.getrFloor() : "N/A");
                            writer.newLine();                
                            writer.write(String.valueOf(rooms.getrNumber()));
                            writer.newLine();                    
                            writer.write(String.valueOf(rooms.getrPrice()));
                            writer.newLine();                    
                            writer.write(rooms.getrStatus() != null ? rooms.getrStatus() : "N/A");
                            writer.newLine();                    
                            writer.write(rooms.getrType() != null ? rooms.getrType() : "N/A");
                            writer.newLine();
                    
                            writer.newLine(); // Move to the next line after each room object

                        }

                        //array list of bookedRooms
                        writer.write(String.valueOf(Booking.rBook.size()));
                        writer.newLine();
                        for(Room bookedRooms:Booking.rBook){
                            writer.write(bookedRooms.getrAvailability() != null ? bookedRooms.getrAvailability() : "N/A");
                            writer.newLine();
                            writer.write(String.valueOf(bookedRooms.getrBeds()));
                            writer.newLine();   
                            writer.write(bookedRooms.getrFloor() != null ? bookedRooms.getrFloor() : "N/A");
                            writer.newLine();                
                            writer.write(String.valueOf(bookedRooms.getrNumber()));
                            writer.newLine();                    
                            writer.write(String.valueOf(bookedRooms.getrPrice()));
                            writer.newLine();                    
                            writer.write(bookedRooms.getrStatus() != null ? bookedRooms.getrStatus() : "N/A");
                            writer.newLine();                    
                            writer.write(bookedRooms.getrType() != null ? bookedRooms.getrType() : "N/A");
                            writer.newLine();
                    
                            writer.newLine(); // Move to the next line after each room object
                        }

                        // Writing Menu Data
                        writer.write(String.valueOf(Menu.menuItems.size())); // Write the number of items in the menu
                        System.out.println("Soize: "+ Menu.menuItems.size());
                        writer.newLine();

                        for (FoodItem foodItem : Menu.menuItems) {
                            writer.write(foodItem.getName() != null ? foodItem.getName() : "N/A"); // Write the name
                            writer.newLine();

                            writer.write(String.valueOf(foodItem.getSizePriceQuantities().size())); // Write the number of sizes
                            writer.newLine();

                            for (SizePriceQuantity spq : foodItem.getSizePriceQuantities()) {
                                writer.write(spq.getSize() != null ? spq.getSize() : "N/A"); // Write the size
                                writer.newLine();
                                writer.write(String.valueOf(spq.getPrice())); // Write the price
                                writer.newLine();
                                writer.write(String.valueOf(spq.getQuantity())); // Write the quantity
                                writer.newLine();

                                writer.newLine();
                            }
                        
                        }
                                                
                        // Writing Orders
                        writer.write(String.valueOf(Restaurant.orders.size())); // Number of orders
                        writer.newLine();

                        for (Order order : Restaurant.orders) {
                            writer.write(String.valueOf(order.getid())); // Order ID
                            writer.newLine();
                            writer.write(String.valueOf(order.getMyorder().size())); // Number of items in the order
                            writer.newLine();

                            for (OrderItem orderItem : order.getMyorder()) {
                                writer.write(orderItem.getItemName() != null ? orderItem.getItemName() : "N/A");
                                writer.newLine();
                                writer.write(String.valueOf(orderItem.getQuantity()));
                                writer.newLine();
                                writer.write(orderItem.getSize() != null ? orderItem.getSize() : "N/A");
                                writer.newLine();
                                writer.write(String.valueOf(orderItem.getPrice()));
                                writer.newLine();

                            }
                        }


                        System.out.println("Data has been written to database.txt successfully.");
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle any I/O exceptions
                    }
                };
            write.data();
                   
                }
            }
         
        }
        if(authenticationCheck == false){
            System.out.println("Your Username or Password is wrong ...");
            System.out.println("Try again..");
        }
    }
 }    
    

     //printing of LODGIFY......
     public static void copyRight(){

    
    
        int width = 50;  // Width of the box
        int height = 7;  // Height of the box
        String text = " WELCOME TO LODGIFY ";
        
        // Calculate the row and starting column for the text
        int textRow = height / 2;  // Middle row for the text
        int textStartCol = (width - text.length()) / 2;  // Center text horizontally

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("#");
                } 
                else if (i == textRow && j >= textStartCol && j < textStartCol + text.length()) {
                    System.out.print(text.charAt(j - textStartCol));
                } 
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();  // Move to the next line after each row
        }
System.out.println();

System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Check In for a Stay, Dine In for Delight! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
System.out.println();
System.out.println("((This property is owned by The Mavericks))                           ");
System.out.println("(( 2024 lodgify.All rights reserved))                           ");

    }
}