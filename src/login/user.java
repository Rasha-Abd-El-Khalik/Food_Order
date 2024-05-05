package login;
import Cart.*;
import Menu.*;
public  class user {
    private String user_name;
    private String password;
    public String name ;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public user(String user_name, String password, String name) {
        this.user_name = user_name;
        this.password = password;
        this.name = name;
    }

}