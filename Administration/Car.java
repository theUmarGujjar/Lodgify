package Administration;

import java.util.Scanner;

public class Car {

    private Scanner sc = new Scanner(System.in);
    private int id;
    private String model;
    private String L_plateno;
    private String availability;

    //constructor to setinfo
    public Car(int id, String model, String L_plateno, String availability) {
        setCar(id, model, L_plateno, availability);

    }

    public Car() {

    }

    //setters
    void setId(int id) {
        this.id = id;

    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setModel(String model) {
        if (model != null && model.matches("[A-Za-z ]+")) {
            this.model = model;
        } else {
            System.out.println("Invalid input for model: only numbers are allowed.");
            System.out.print("Please enter a valid model (only numbers): ");
            String newInput = sc.nextLine();
            setModel(newInput);
        }
    }

    public void setL_plateno(String l_plateno) {
        if (l_plateno != null && l_plateno.matches("[a-zA-Z]{3} \\d{1,4}")) {
            this.L_plateno = l_plateno;
        } else {
            System.out.println("Invalid input for L_plateno: must be 3 letters, a space, and 1 to 4 digits.");
            System.out.print("Please enter a valid L_plateno: ");
            String newInput = sc.nextLine();
            setL_plateno(newInput);
        }
    }

    //setter to set info
    void setCar(int id, String model, String L_plateno, String availability) {
        this.id = id;
        this.model = model;
        this.L_plateno = L_plateno;
        this.availability = availability;

    }

    //getters
    public int getId() {
        return id;

    }

    public String getAvailability() {
        return availability;
    }

    public String getModel() {
        return model;
    }

    public String getL_plateno() {
        return L_plateno;
    }

    public void displayinfo() {
        System.out.println("Car id is : " + id);
        System.out.println("Car lisence plate no is : " + L_plateno);
        System.out.println("Car model is : " + model);
        System.out.println("Car availability is : " + availability);
    }
    // public void setavailability(String availability2) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setavailability'");
    // }

}
