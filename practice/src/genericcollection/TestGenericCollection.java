package genericcollection;

import java.util.ArrayList;
import java.util.List;

public class TestGenericCollection {
    public static void main(String[] args){

        ArrayList<Double> alist = new ArrayList<Double>();

        alist.add(10.0);
        alist.add(4.4);
//        list.add("hello");

        double sum = 0;
        for(int i = 0; i < alist.size(); i++){
            sum += alist.get(i);
        }

        System.out.println(sum);

        //泛型不可多态
        List<Integer> list = new ArrayList<Integer>();

    }
}


