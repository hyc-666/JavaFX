package Javafx_56;
//绑定计算
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;

public class BindCalculate {

    public static void main(String[] args) {
        SimpleIntegerProperty simpleIntegerProperty_a = new SimpleIntegerProperty(1);
        SimpleIntegerProperty simpleIntegerProperty_b = new SimpleIntegerProperty(1);

        //SimpleIntegerProperty直接与一个int型add计算后返回的是一个新的对象类型IntegerBinding
        IntegerBinding integerBinding = simpleIntegerProperty_a.add(3);
        System.out.println(integerBinding.get());

        //而SimpleIntegerProperty与相同类型的对象add之后返回一个NumberBinding
        NumberBinding numberBinding = simpleIntegerProperty_a.add(simpleIntegerProperty_b);
        System.out.println(numberBinding.intValue());
        //除了add方法之外，加减乘除方法是齐全的

        simpleIntegerProperty_a.set(5);//重新给simpleIntegerProperty_a赋值
        //绑定计算的值是实时更新的
        System.out.println(integerBinding.get());
        //同样的，numberBinding的值也是实时计算的
        simpleIntegerProperty_b.set(8);
        System.out.println(numberBinding.intValue());

    }
}
