//By Zhongsheng Li
public class LMSApplicationFacede {
    private User user;
    public LMSApplicationFacede(){
        user = null;
    }
    public void Login(String name, String password){
        user.setUserName(name);
        user.setPassword(password);
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
