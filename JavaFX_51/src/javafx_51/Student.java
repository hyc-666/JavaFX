package javafx_51;

import java.beans.PropertyChangeSupport;

public class Student {
    private String name;
    private int age;
    public PropertyChangeSupport pcs = new PropertyChangeSupport(this);//关于对象值改变的监听
    //因为这些成员变量都是私有的，只能通过set方法改变，在set方法里完成属性修改监听的代码

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //需要先将旧的值保存
        String oldValue = this.name;
        this.name = name;
        pcs.firePropertyChange("name_changed",oldValue,this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //同样需要先保存旧值
        int oldValue = this.age;
        this.age = age;
        pcs.firePropertyChange("age_changed",oldValue,this.age);
        //不过我觉得这样写也可以
//        pcs.firePropertyChange("age_changed",this.age,this.age = age);
    }
}
