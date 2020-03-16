package User;

public class NormalUser extends User {
    static int id = 500;
    public NormalUser(String name,int identity) {
        this.name = name;
        this.identity = ++id;
        this.password = "0";
    }

    @Override
    protected void setPassword(String password) {
        this.password = password;
    }
}
