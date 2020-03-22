package javafx_53;

import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

import java.util.function.BiConsumer;

public class JavaFX_53_SimpleMapProperty {
    public static void main(String[] args) {
        //有list有set那么肯定就有map了
        ObservableMap<String,String> map = FXCollections.observableHashMap();
        map.put("1","A");
        map.put("2","B");
        SimpleMapProperty<String,String> simpleMapProperty = new SimpleMapProperty<>(map);

        simpleMapProperty.addListener(new MapChangeListener<String, String>() {
            @Override
            public void onChanged(Change<? extends String, ? extends String> change) {

            }
        });

        simpleMapProperty.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {

            }
        });
    }
}
