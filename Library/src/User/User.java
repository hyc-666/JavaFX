package User;

public abstract class User {
    String name;//用户名
    String password;//登陆密码
    int identity;//用户身份
    /**
     * 关于用户身份说明：
     * 用户一共有三类：
     * 第一类，超级用户root，只有一个，拥有所有权限，可以操作所有的用户列表,身份的identity是0
     * 第二类，管理员，可以管理书籍等操作，但不能管理其他用户，仅能新增普通用户，身份的identity是1到500
     * 第三类，普通用户，身份的identity是501到Integer.MAXVALUE.
     */
    protected abstract void setPassword(String password);

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getIdentity() {
        return identity;
    }
}
