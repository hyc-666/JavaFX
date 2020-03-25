package javafx_55;

import javafx.beans.property.SimpleIntegerProperty;

public class JavaFX_55 {
    public static void main(String[] args) {
        SimpleIntegerProperty x = new SimpleIntegerProperty(3);
        SimpleIntegerProperty y = new SimpleIntegerProperty(6);

        //单向绑定
        x.bind(y);//将x绑定在y上，x会跟随y的值变化
//        x.set(8);//此后不能再给x设置值，会抛出异常

        System.out.println(x.get());
        System.out.println(y.get());
        //这个方法并不是检查x是否被绑定，而是检查x的值是否被束缚，也就是说x的值能不能被更改
        //又由于x与y单向绑定，因此，x的值只能跟随y而变化，自己的值并不能被修改
        System.out.println(x.isBound());
        System.out.println(y.isBound());


        //双向绑定
        SimpleIntegerProperty a = new SimpleIntegerProperty(5);
        SimpleIntegerProperty b = new SimpleIntegerProperty(10);
        a.bindBidirectional(b);//a与b双向绑定，修改一个，另一个也会随着变化，初始时以后面参数的值为主
        System.out.println(a.isBound());
        System.out.println(b.isBound());//a与b的值都不会受到限制，都能够自由修改
        a.set(20);
        System.out.println(a.get());
        System.out.println(b.get());
    }
}
