import java.util.Date;

public class User {
    private int id;
    public static int count = 0;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String userName;
    private String email;
    private String password;
    private Type type;
    public User(String name, String email, Date birthdate, String password){
        this.userName = name;
        this.email = email;
        this.birthdate = birthdate;
        this.password = password;
        this.id = count;
        count++;
    }
    public User(){
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.password = "";
        this.email = "";
        this.birthdate = new Date();
        this.type = Type.STUDENT;
        this.id = count;
        count++;
    }
    public User getUserById(int id){
        if(id == this.id){
            return this;
        }
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
}
