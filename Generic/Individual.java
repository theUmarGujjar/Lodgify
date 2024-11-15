package Generic;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Individual {
    public String name;
    private String cnic;
    private String gmail;
    private String phoneNumber;
    private String dob;
    Scanner input=new Scanner(System.in);
    public Authorization aut = new Authorization();

    private static final String NAME_REGEX = "^[a-zA-Z]+(?: [a-zA-Z]+)*$";
    private static final String CNIC_REGEX = "^\\d{5}-\\d{7}-\\d{1}$";
    private static final String PHONE_REGEX = "^\\+?\\d{1,4}[-\\s]?\\(?\\d{3}\\)?[-\\s]?\\d{7}$";
    private static final String GMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String DOB_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    public Individual() {}

    public Individual(String name, String cnic, String phoneNumber, String gmail, String dob) {
        setInfo(name, cnic, phoneNumber, gmail, dob);
    }

    public void setName(String name) {
        while(true){
        if (Pattern.matches(NAME_REGEX, name)) {
            this.name = name;
            break;
        } else {
            System.out.println("Error: Name must contain only alphabetic characters and spaces (e.g., 'Muhammad Zaid Naeem').");
            System.out.println("Name : ");
            name=input.nextLine();
        }
    }
    }
    public void setAuthorization(String userName, String passWord) {
        aut.setAuthorization(userName, passWord);
    }

    public void setCnic(String cnic) {
        while(true){
        if (Pattern.matches(CNIC_REGEX, cnic)) {
            this.cnic = cnic;
            break;
        } else {
            System.out.println("Error: Invalid CNIC format. \nCNIC should be in the format 'XXXXX-XXXXXXX-X' (e.g., '12345-1234567-1').");
            System.out.println("Cnic : ");
           
            cnic=input.nextLine();

        }
    }
    }

    public void setGmail(String gmail) {
        while(true){
        if (Pattern.matches(GMAIL_REGEX, gmail)) {
            this.gmail = gmail;
            break;
        } else {
            System.out.println("Error: Invalid Gmail format.\n A valid Gmail should follow the format 'username@gmail.com' (e.g., 'lodgify@example.com').");
             System.out.println("email : ");
             gmail=input.nextLine();
        }
    }
    }
    public void setPhoneNumber(String phoneNumber) {
        while(true){

        if (Pattern.matches(PHONE_REGEX, phoneNumber)) {
            this.phoneNumber = phoneNumber;
            break;
        } else {
            System.out.println("Error: Invalid phone number format. A valid phone number should follow the pattern '+<country-code> <area-code> <number>' (e.g., '+1 123-4567890').");
            System.out.println("Phone Number : ");
            phoneNumber=input.nextLine();
        }
    }
    }
    public void setDob(String dob) {
        while(true){
        if (Pattern.matches(DOB_REGEX, dob)) {
            this.dob = dob;
            break;
        } else {
            System.out.println("Error: Invalid date of birth format. The date should be in 'YYYY-MM-DD' format (e.g., '1990-12-31').");
            System.out.println("date of birth : ");
            dob=input.nextLine();
        }
    }
    }
    public void setInfo(String name, String cnic, String phoneNumber, String gmail, String dob) {
        setName(name);
        setCnic(cnic);
        setPhoneNumber(phoneNumber);
        setGmail(gmail);
        setDob(dob);
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getGmail() {
        return gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDob() {
        return dob;
    }
}