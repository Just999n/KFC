import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String userName;
    private String email;
    private String password;
    private Type type;
    public User(String name, String password, String firstName, String lastName, String email, Date birthdate, Type type){
        this.userName = name;
        this.email = email;
        this.birthdate = birthdate;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.id = UUID.randomUUID();
    }
    public User getUserById(int id){
        return null;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getUserName() {
        return userName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
    public Type getType() {
        return type;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public String toString(){
        return "name: "+firstName+" "+lastName+"\n"+"user name: "+userName+"\n"+"birthday: "+birthdate+"\n"+"email: "+email;
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
