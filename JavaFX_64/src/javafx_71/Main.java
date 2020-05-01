package javafx_71;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' '){
                    stringBuilder.append(str.charAt(i));
                }else{
                    if (list.contains(stringBuilder.toString())){
                        continue;
                    }
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
        }
        System.out.println(list.size());
        scanner.close();
    }
}
//u[2207654443578]