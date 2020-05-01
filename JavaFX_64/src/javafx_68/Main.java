package javafx_68;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = fib();
//        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if(num <= list.get(i)){
                    index = i;
                    break;
                }
            }
            if (index == 0){
                System.out.println(0);
            }else {
                int ret1 = num - list.get(index - 1);
                int ret2 = list.get(index) - num;
                System.out.println(Math.min(ret1, ret2));
            }
        }
        scanner.close();
    }
    public static List<Integer> fib(){
        List<Integer> fibList = new ArrayList<>();
        int f1 = 1;
        int f2 = 1;
        int fn = f1 + f2;
        fibList.add(f1);
        fibList.add(f2);
        while(fn <= 1000000){
            f1 = f2;
            f2 = fn;
            fn = f1 + f2;
            fibList.add(fn);
        }
        return fibList;
    }
}
