package sets;

import java.util.HashSet;

public class TestHashSet {

    public static void main(String[] args){

        HashSet<String> hs = new HashSet<String>();

        System.out.println( hs.add("A"));
        hs.add("B");
        hs.add("C");
        System.out.println( hs.add("A"));

        for(String str: hs){
            System.out.println(str);
        }


    }
}
