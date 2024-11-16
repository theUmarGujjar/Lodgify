package Administration;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {
    public static ArrayList<Car> carlist=new ArrayList<Car>(10);
    Scanner input=new Scanner(System.in);
    void addCar(){
        Car car=new Car();
     
        System.out.println("Enter the details of car ");
int id=0;
        while(true){
            boolean cont=false;
        System.out.println("Id :");
        if(!(input.hasNextInt())){
          System.out.println();
          System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
          System.out.println();
         input.nextLine();
         continue;
        }
        id = input.nextInt();
        input.nextLine();
            for(int i=0;i<carlist.size();i++){
            if(id==carlist.get(i).getId()){
                System.out.println("there is another car with this id.enter another id");
               cont=true;
               break;
                
                  
                }

               
                  }
            if(cont){
            continue;
            }
            car.setId(id);
            break;
            }
        
        
        System.out.println("Model :");
        String model = input.nextLine();
        car.setModel(model);
        System.out.println("Lisence plate number :");
        String L_plateno = input.nextLine();
        car.setL_plateno(L_plateno);
        System.out.println("car availablility : ");
        while(true){    
          System.out.println("You can only enter yes / no");
        
          String availability = input.nextLine();
        
          if(!(availability.equals("yes") || availability.equals("no"))){
              
            System.out.println("Invalid input ");
            System.out.println("Enter again");    
          }
        else{
            car.setAvailability(availability);
          break;
        }
       
        }
        carlist.add(car);
        System.out.println("car added");
        
    }
    //removing car by matching id
    void removeCar(){
        System.out.println("Enter the id of car that you want to remove");
        while(true){
        if(!(input.hasNextInt())){
            System.out.println();
            System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
            System.out.println();
           input.nextLine();
          }else{
            break;
          }
        }
          int id = input.nextInt();
          input.nextLine();
    Boolean found = false;
    for(int i = 0 ; i< carlist.size() ; i++){
        if(id == carlist.get(i).getId()){
            System.out.println("you want to remove " + carlist.get(i).getId());
            carlist.remove(i);

            found = true;
            System.out.println("car with id : "+ id + "is removed");
        }
    }
    if(!found){
        System.out.println("No car  in database with that id ");
    }
}


    void updateCar(){
        System.out.println("you can update the model and lisence plate numner of car after giving its");

        System.out.println("enter the id of car you want to update");
       while(true){
        if(!(input.hasNextInt())){
          System.out.println();
          System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
          System.out.println();
         input.nextLine();
        }else{
            break;
        }
    }
        int id = input.nextInt();
        input.nextLine();


        for(Car car:carlist){
         if(car.getId()==id){
           System.out.println("id matched..");
           System.out.println("enter the new details of the car ");
           System.out.println("Lisence plate number : ");
           String L_plateno=input.nextLine();
           System.out.println("Model : ");
           String model=input.nextLine();

           car.setL_plateno(L_plateno);
          
           car.setModel(model);
          System.out.println("Car updated");
          return;
         }else{
            System.out.println("There is no car with this id");
         }
        }
     }

    void displayCars(){
        if(carlist.isEmpty()){
            System.out.println("there is no car in the list");
        }else{
            for(Car car:carlist){
                car.displayinfo();
                System.out.println("----------------------------");

            }
        }
    }

    public static ArrayList<Car> getCarList(){
        return carlist;
    }

}
