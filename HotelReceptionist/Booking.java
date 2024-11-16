package HotelReceptionist;

import Administration.Room;
import Administration.RoomManager;
import Staff.Driver;
import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    //define arraylist Room class..
    public static ArrayList<Room> rLs1 = RoomManager.roomlist; // arraylist of allRooms import by administration package..
    public static ArrayList<Room> rAvailable = new ArrayList<>(); // array list of availableRooms
    public static ArrayList<Room> rBook = new ArrayList<>(); // array list of bookedRooms

    //define arraylist of person class..
    public static ArrayList<PersonWhoBook> database = new ArrayList<>(); //arraylist of all persons
    public static ArrayList<PersonWhoBook> pBook = new ArrayList<>(); //arraylist of person who booked tRoom.

    public static void bookingMain() {

        //code to load availabRoom arraylist..
        for (int i = 0; i < rLs1.size(); i++) {
            if (rLs1.get(i).getrAvailability().equals("yes")) {
                rAvailable.add(rLs1.get(i));
            }
        }

        Scanner input = new Scanner(System.in);
        String opt1;
        System.out.println("##################################### Welcome to Receptionist Portal #####################################");

        while (true) {

            System.out.println();
            System.out.println("Press The Number Carefully : ");
            System.out.println();
            System.out.println("Press 1 to Book the Room : ");
            System.out.println("Press 2 to Check the Available Rooms: ");
            System.out.println("Press 3 to Checkout from the Room : ");
            System.out.println("Press 4 to View the Booked Rooms : ");
            System.out.println("Press 5 to Update the booked details : ");
            System.out.println("Press 6 to Change the Room's hygenic status : ");
            System.out.println("Press 7 to Check the Room's hygenic status : ");
            System.out.println("Press 8 to Change booking status of cars : ");
            System.out.println("Press 0 to Exit the program : ");
            System.out.println("############################################################################################");
            System.out.println();

            opt1 = input.nextLine();

            // For booking rooms
            if (opt1.equals("1")) {
                System.out.println("------------------------Booking Rooms-------------------------");
                while (true) {
                    int rNumber;
                    System.out.println("Enter the Room number you want to book : ");
                    System.out.println("Enter 0 to go back : ");

                    if (!(input.hasNextInt())) {
                        System.out.println();
                        System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY   ");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }
                    rNumber = input.nextInt();
                    input.nextLine();
                    Boolean found = false;
                    if (rNumber == 0) {
                        System.out.println("*******************************************************************************");
                        break;
                    }
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println();

                    for (int i = 0; i < rAvailable.size(); i++) {
                        if (rAvailable.get(i).getrNumber() == rNumber) {
                            rBook.add(rAvailable.get(i));
                            PersonWhoBook p = new PersonWhoBook(rNumber);
                            pBook.add(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("This Room is not available...");
                        System.out.println();
                    }

                    for (int i = 0; i < rAvailable.size(); i++) {
                        if (rAvailable.get(i).getrNumber() == rNumber) {
                            rAvailable.remove(i);
                        }
                    }
                    for (int i = 0; i < rLs1.size(); i++) {
                        if (rLs1.get(i).getrNumber() == rNumber) {
                            rLs1.get(i).setrAvailability("no");
                        }
                    }

                    if (found) {
                        System.out.println();
                        System.out.println("Room booked Successfully....");
                        System.out.println();

                    }

                }

            } // option to see available Rooms.
            else if (opt1.equals("2")) {
                System.out.println("------------------------Available Rooms-------------------------");
                if((rAvailable.size())==0){
                    System.out.println("There is no room in database...");
                }
                for (int i = 0; i < rAvailable.size(); i++) {
                    rAvailable.get(i).show();
                }
                System.out.println("*******************************************************************************");

            } // option to checkout the Rooms
            else if (opt1.equals("3")) {
                System.out.println("------------------------Checking Out-------------------------");
                while (true) {
                    int rNumber;
                    System.out.println();
                    System.out.println("Booked Rooms are : ");
                    System.out.println();
                    for (int i = 0; i < rBook.size(); i++) {
                        System.out.println(rBook.get(i).getrNumber() + " booked by : " + pBook.get(i).getName());
                    }
                    System.out.println();
                    System.out.println("Enter any of the above Room number you want to check out : ");
                    System.out.println("Enter 0 to go back : ");

                    if (!(input.hasNextInt())) {
                        System.out.println();
                        System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }
                    rNumber = input.nextInt();
                    input.nextLine();

                    if (rNumber == 0) {
                        System.out.println("*******************************************************************************");
                        break;
                    }

                    //boolean to control Rooms availability..
                    Boolean remove = false;

                    for (int i = 0; i < rBook.size(); i++) {
                        if (rBook.get(i).getrNumber() == rNumber) {
                            rBook.remove(i);
                            pBook.remove(i);
                            remove = true;
                        }
                    }
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println();
                    if (remove == true) {
                        for (int i = 0; i < rLs1.size(); i++) {
                            if (rLs1.get(i).getrNumber() == rNumber) {
                                rAvailable.add(rLs1.get(i));
                            }
                        }

                        for (int i = 0; i < rLs1.size(); i++) {
                            if (rLs1.get(i).getrNumber() == rNumber) {
                                rLs1.get(i).setrAvailability("yes");
                            }
                        }
                        System.out.println("CHECKOUT SUCCESSFULLY..");

                        remove = false;
                    } else {
                        System.out.println();
                        System.out.println("This Room was not Booked....");
                        System.out.println();
                    }
                }

            } // option to see bookRooms
            else if (opt1.equals("4")) {
                System.out.println("------------------------Viewing Booked Rooms-------------------------");
                if (rBook.size() == 0) {
                    System.out.println("None of the Room is booked");
                }
                for (int i = 0; i < rBook.size(); i++) {
                    System.out.println();
                    System.out.println("Detail of the " + (i + 1) + " # person");
                    System.out.println();
                    System.out.println("Person who booked the Room : " + pBook.get(i).getName());
                    System.out.println("CNIC of that person : " + pBook.get(i).getCnic());
                    rBook.get(i).show();
                    System.out.println();

                    while (true) {
                        int opt2;
                        System.out.println("Press 1 to get details of that person : ");
                        System.out.println("Press 2 to go back : ");

                        if (!(input.hasNextInt())) {
                            System.out.println();
                            System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                            System.out.println();
                            input.nextLine();
                            continue;
                        }
                        opt2 = input.nextInt();
                        input.nextLine();

                        if (opt2 == 1) {
                            System.out.println("((((((((((((((Result: ))))))))))))))");
                            System.out.println();
                            pBook.get(i).displayData();
                            break;
                        } else if (opt2 == 2) {
                            System.out.println("*******************************************************************************");
                            break;
                        } else {
                            System.out.println("Invalid Choice!!");
                            input.nextLine();
                            System.out.println("Try Again...");
                            System.out.println();
                        }

                    }
                }
            } // option to update the person details who book the Room
            else if (opt1.equals("5")) {
                System.out.println("------------------------Updating The Customer's Details-------------------------");
                while (true) {
                    int num;
                    System.out.println("Press 1 to update details by the Room Number : ");
                    System.out.println("Press 2 to update details by the Person's CNIC : ");
                    System.out.println("Press 0 to go back : ");

                    if (!(input.hasNextInt())) {
                        System.out.println();
                        System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }

                    num = input.nextInt();
                    input.nextLine();

                    if (num == 0) {
                        System.out.println("*******************************************************************************");
                        break;
                    }

                    if (num == 1) {
                        int RoomN;
                        while (true) {
                            System.out.println();
                            System.out.println("Enter the Room number which details you want to update : ");

                            if (!(input.hasNextInt())) {
                                System.out.println();
                                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY   ");
                                System.out.println();
                                input.nextLine();
                                System.out.println();
                                continue;
                            }
                            RoomN = input.nextInt();
                            input.nextLine();

                            break;

                        }

                        for (int i = 0; i < rBook.size(); i++) {
                            if (rBook.get(i).getrNumber() == RoomN) {
                                PersonWhoBook p = new PersonWhoBook(RoomN);
                                pBook.set(i, p);
                            }
                        }
                        break;
                    } else if (num == 2) {
                        String updateCnic;
                        System.out.println("Enter the CNIC of the person whose details you want to update : ");
                        updateCnic = input.nextLine();

                        Boolean found = false;
                        for (int i = 0; i < pBook.size(); i++) {
                            if (updateCnic.equals(pBook.get(i).getCnic())) {
                                System.out.println(pBook.get(i).getCnic());
                                int RoomN = rBook.get(i).getrNumber();
                                PersonWhoBook p = new PersonWhoBook(RoomN);
                                pBook.set(i, p);
                                found = true;

                            }

                        }
                        if (!found) {
                            System.out.println("NO DATA OF SUCH CNIC...");
                        }

                    } else {
                        System.out.println("Invalid Choice!!");
                        input.nextLine();
                        System.out.println("Try Again...");
                        System.out.println();
                    }

                }
            } //option to update the hygienic status of the Rooms..
            else if (opt1.equals("6")) {
                System.out.println("------------------------Updating the Hygienic Status of the Rooms-------------------------");

                while (true) {
                    int number;
                    System.out.println("Enter the Room number which status you want to update : ");
                    System.out.println("Enter 0 to go back : ");

                    if (!(input.hasNextInt())) {
                        System.out.println();
                        System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }

                    number = input.nextInt();
                    input.nextLine();

                    if (number == 0) {
                        System.out.println("*******************************************************************************");
                        break;
                    }

                    //loop to show the status of thRoom.
                    Boolean rStatusFind = false;
                    for (int i = 0; i < rLs1.size(); i++) {
                        if (rLs1.get(i).getrNumber() == number) {
                            rStatusFind = true;
                            System.out.println("Current Room status is : " + rLs1.get(i).getrStatus());

                            String rStatus;
                            System.out.println("Enter the new hygienic status of that Room : ");
                            rStatus = input.nextLine();
                            rLs1.get(i).setrStatus(rStatus);
                        }
                    }
                    if(rStatusFind == false){
                        System.out.println("There is no such room in database..");
                    }

                }
            } //option to see the hygienic status of the Room..    
            else if (opt1.equals("7")) {
                System.out.println("------------------------Checking the Hygienic Status Of the Rooms-------------------------");

                while (true) {
                    int choice;
                    System.out.println("Press 1 to see the hygenic status of all Rooms : ");
                    System.out.println("Press 2 to see the hygenic status of specifRoom : ");
                    System.out.println("Press 0 to go back : ");

                    if (!(input.hasNextInt())) {
                        System.out.println();
                        System.out.println("WRONG INPUT ::: It can only integer : ");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }
                    choice = input.nextInt();
                    input.nextLine();

                    if (choice == 0) {
                        System.out.println("*******************************************************************************");
                        break;
                    }

                    if (choice == 1) {
                        System.out.println("((((((((((((((Result: ))))))))))))))");
                        System.out.println();
                        if(rLs1.size()==0){
                            System.out.println("There is no room in database..");
                        System.out.println();
                        }
                        for (int i = 0; i < rLs1.size(); i++) {
                            System.out.println("Room status Room number : " + rLs1.get(i).getrNumber() + " is : " + rLs1.get(i).getrStatus());
                        }
                    } else if (choice == 2) {
                        while (true) {
                            int rNumber;
                            System.out.println("Enter the Room number whose status you want to check : ");
                            System.out.println("Enter 0 to go back : ");
                            if (!(input.hasNextInt())) {
                                System.out.println();
                                System.out.println("WRONG INPUT ::: It can only integer : ");
                                System.out.println();
                                input.nextLine();
                                continue;
                            }
                            rNumber = input.nextInt();
                            input.nextLine();

                            if (rNumber == 0) {
                                System.out.println("*******************************************************************************");
                                break;
                            }
                            for (int i = 0; i < rLs1.size(); i++) {
                                System.out.println("((((((((((((((Result: ))))))))))))))");
                                System.out.println();
                                if (rNumber == rLs1.get(i).getrNumber()) {
                                    System.out.println("Room status of Room number : " + rLs1.get(i).getrNumber() + " is : " + rLs1.get(i).getrStatus());
                                }
                            }
                        }

                    }
                }
            } //option to redirect on driver portal..
            else if (opt1.equals("8")) {
                System.out.println("------------------------Driver Portal-------------------------");
                Driver driver = new Driver();
                driver.showCarData();

            } //option to end the programme
            else if (opt1.equals("0")) {
                System.out.println("############################################################################################");
                break;
            } //For input validation..
            else {
                System.out.println();
                System.out.println("Enter the right number.");
                System.out.println();
            }
        }
    }
}
