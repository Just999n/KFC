package src;
import org.json.simple.JSONObject;

import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class User {
  private String userName;
  private UUID userID;
  private Type type;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Date birthdate;

  public User(String userName, Type type, String firstName, String lastName,
                String email, String password, Date birthdate) {
    this.userName = userName;
    this.userID = UUID.randomUUID();
    this.type = type;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.birthdate = birthdate;
  }

  public String getUserName() {
    return userName;
  }

  public User getUserByID(int userID) {
    return null;
  }

  public Type getType() {
    return type;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String toString() {
    return "Name: "+firstName+" "+lastName+"\nUsername: "+userName
              +"\nBirthday: "+birthdate+"\nEmail: "+email;
  }
  
  public void writeToJson(JSONObject save){
    save.put("userName", userName);
    save.put("password", password);
    save.put("firstName", firstName);
    save.put("lastName", lastName);
    save.put("birthday", birthdate.toString());
    save.put("email", email);
    save.put("type", type.name().toLowerCase());
  }
  
  public void editData(Scanner scan){
    String input;
    System.out.print("Pleases input firstName: ");
    input = scan.nextLine();
    firstName = input;
    System.out.print("Pleases input lastName: ");
    input = scan.nextLine();
    lastName = input;
    System.out.print("Pleases input birthdate(month/day/year): ");
    input = scan.nextLine();
    birthdate = new Date(input);
    System.out.print("Pleases input userName: ");
    input = scan.nextLine();
    userName = input;
    System.out.print("Pleases input email: ");
    input = scan.nextLine();
    email = input;
    System.out.print("Pleases input password: ");
    input = scan.nextLine();
    password = input;
  }
}
