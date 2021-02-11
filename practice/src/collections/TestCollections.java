package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(3);
        list.add(5);

        //reverse(List<?> list)反转集合中元素的顺序
        Collections.reverse(list);
        print(list);

        //shuffle(List<?> list)随机重置集合元素的顺序
        Collections.shuffle(list);
        print(list);

        //sort(List<T> list)升序排序（元素类型必须实现Comparable）
        Collections.sort(list);
        print(list);
    }

    public static void print(List list){
        for(int i = 0; i < list.size(); i++){
                System.out.print( list.get(i)+"\t" );
        }
        System.out.println();
    }

}
