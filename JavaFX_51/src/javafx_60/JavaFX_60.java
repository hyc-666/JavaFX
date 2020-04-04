package javafx_60;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//List,Map,Set的绑定
public class JavaFX_60 {
    public static void main(String[] args) {

        ObservableList observableList1 = FXCollections.observableArrayList();
        SimpleListProperty<String> list1 = new SimpleListProperty<String>(observableList1);
        list1.add("A");
        list1.add("B");

        ObservableList observableList2 = FXCollections.observableArrayList();
        SimpleListProperty<String> list2 = new SimpleListProperty<>(observableList2);
        list2.add("C");
        list2.add("D");

        System.out.println("list1 = " + list1.getValue());
        System.out.println("list2 = " + list2.getValue());
        System.out.println();
        //现在将list1和list2单向绑定
        list1.bind(list2);
        //会发现其实list1的内容是会跟着list2的内容改变的
        System.out.println("list1 = " + list1.getValue());
        System.out.println("list2 = " + list2.getValue());
        //其实，对于list的绑定，上面两个绑定的对象会共同维护同一个list
        //对于上面代码来说，list1单向绑定了list2，于是就会共同维护list2，而list2就是上面的observableList2
        //维护的内容就是参数里被绑定的那个

        //而经过B站某位up主的测试，这里list的单向绑定和双向绑定是没有差别的
//        list1.bindBidirectional(list2);
        //如果将上面代码复制一份只修改单向绑定与双向绑定的一条，运行结果是一样的

        //还有一个绑定
        list1.bindContent(list2);
        //这个绑定的效果是list1是单独的，修改list1不会影响到list2，
        //但是修改list2会影响到list1
        //也就是说它们只维护各自的一个列表，但是list2会影响到list1

        //而下面这个才是真正意义上的双向绑定
        list1.bindContentBidirectional(list2);
        //两个list是会相互影响的
        //解绑和绑定时对应的
        list1.unbindContentBidirectional(list2);

        //set和map与list的各种绑定用法和效果一样，不多写了
    }
}
