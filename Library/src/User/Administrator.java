package User;

public class Administrator extends User {
    static int id = 1;
    public Administrator(String name,int identity){
        this.name = name;
        this.identity = id++;
        password = "0";
    }
    @Override
    protected void setPassword(String password) {
        this.password = password;
    }
}
