package User;

import java.util.ArrayList;

public class Root extends User {
    //root用户管理一个用户列表
    private ArrayList<User> users = new ArrayList<User>();
    private Root() {
        name = "root";
        password = "0";//将root用户的密码初始为0
        identity = 0;
        users.add(new Administrator("admin1",1));
        users.add(new Administrator("admin2",2));
        users.add(new NormalUser("user1",501));
        users.add(new NormalUser("user2",502));
    }

    private static Root root = new Root();
    public static Root getRoot(){
        //在返回一个root用户实例的时候先预添加一些用户
        root.addUser(root);
        return root;
    }
    @Override
    public void setPassword(String password){
        this.password = password;
    }

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}