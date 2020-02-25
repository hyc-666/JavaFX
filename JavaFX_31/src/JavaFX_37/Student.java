package JavaFX_37;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    //将这些属性重新包装
//    private String name;
//    private int age;
//    private double score;

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleDoubleProperty score = new SimpleDoubleProperty();


    public Student(String name, int age, double score) {
        this.name.setValue(name);
        this.age.setValue(age);
        this.score.set(score);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public int getAge() {
        return age.getValue();
    }

    public void setAge(int age) {
        this.age.setValue(age);
    }

    public double getScore() {
        return score.getValue();
    }

    public void setScore(double score) {
        this.score.setValue(score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
    public SimpleStringProperty getNameSimpleStringProperty(){
        return name;
    }

    public Student() {
    }
    //    @Override
//    public String toString() {
//        return  name;
//    }
}
