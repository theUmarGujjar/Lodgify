package Staff;

import Administration.Car;
import Administration.CarManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends StaffFunctions {

    Scanner input = new Scanner(System.in);

    public void showCarData() {
        while (true) {
            System.out.println();
            System.out.println("Press 1 to check all cars' information");
            System.out.println("Press 2 to check a specific car's information");
            System.out.println("Press 3 to update a specific car's status");
            System.out.println("Press 0 to exit");
            System.out.println("############################################################################################");

            int choice;
            if (!(input.hasNextInt())) {
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                System.out.println();
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();
            ProgramStatus programStatus = ProgramStatus.chooseStatus(choice);
            switch (programStatus) {
                case EXIT:
                    System.out.println();
                    System.out.println("Exited Succcessfully!");
                    System.out.println("############################################################################################");

                    return;
                case SHOW_INFORMATION_OF_ALL:
                    ArrayList<Car> carlist = CarManager.getCarList();
                    System.out.println("------------------------Displaying Cars Information-------------------------");
                    for (Car car : carlist) {
                        car.displayinfo();
                    }
                    System.out.println("*******************************************************************************");
                    break;

                case SHOW_INFORMATION_OF_ONE:
                    System.out.println("------------------------Displaying Selected Car's Information-------------------------");
                    showDataForOne();
                    System.out.println("*******************************************************************************");
                    break;

                case UPDATE_STATUS_OF_ONE:
                    System.out.println("------------------------Updating Status-------------------------");
                    updateStatus();
                    System.out.println("*******************************************************************************");
                    break;

                default:
                    System.out.println("Invalid Choice!!");
                    input.nextLine();
                    System.out.println("Try Again...");
                    System.out.println();
                    break;
            }
        }

    }

    //overriding absract method to show data of selected car
    @Override
    public void showDataForOne() {

        while (true) {
            int carNumber;
            System.out.println("Enter the Car ID whose information you want to check : ");
            System.out.println("Enter 0 to go back : ");
            if (!(input.hasNextInt())) {
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                System.out.println();
                input.nextLine();
                continue;
            }
            carNumber = input.nextInt();
            input.nextLine();

            if (carNumber == 0) {
                return;
            }
            System.out.println("((((((((((((((Result: ))))))))))))))");
            for (Car car1 : CarManager.carlist) {
                if (carNumber == car1.getId()) {
                    System.out.println("Information of Car ID : " + car1.getId() + " is :");
                    car1.displayinfo();
                }
                System.out.println("There is no such car...");
            }
        }
    }

    //overriding abstract method for updating status
    @Override
    public void updateStatus() {

        while (true) {
            int number;
            System.out.println("Enter the car ID whose status you want to update : ");
            System.out.println("Enter 0 to go back : ");

            if (!(input.hasNextInt())) {
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY   ");
                System.out.println();
                input.nextLine();
                continue;
            }

            number = input.nextInt();
            input.nextLine();

            if (number == 0) {
                break;
            }
            for (Car car1 : CarManager.carlist) {
                if (number == car1.getId()) {
                    System.out.println();
                    System.out.println("Current Status of Car " + car1.getId() + " is " + car1.getAvailability());
                    String availibility;
                    System.out.println("Enter the updated status of that Car : ");
                    availibility = input.nextLine();
                    car1.setAvailability(availibility);
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("Status Updated to : " + car1.getAvailability());
                    return;
                } else {
                    System.out.println("There is no such car...");
                }
            }
        }
    }
}
