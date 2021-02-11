package advencedgeneric;

public class TestAdvencedGeneric {

    public static void main(String[] args){

        //实例泛型（创建对象或实现接口时完成指定）
        MyClass<Integer> mc = new MyClass<Integer>();
        mc.m1(111);

        MyClass<Double> mc1 = new MyClass<Double>();
        mc1.m1(2.2);

        MyInterface<Byte> mi = new MyImplClass();
        mi.m2( (byte)123 );

        //静态泛型（方法调用时完成指定）
        MyStaticClass.method(123);
        MyStaticClass.method(2.5);
        MyStaticClass.method("hello");

        MyStaticClass.method3( new Dog() );
//        MyStaticClass.method3( new Cat() );

    }
}

/*
class MyStaticClass<T>{
    public static void method(T t){

    }
}
 */


class MyStaticClass{
    public static <T> void method(T t){//可以接收任何类型

    }

    public static <T extends Number> void method2(T t){//只接收number的子类

    }

    public static <T extends Animal & Comparable> void method3(T t){//用作排序

    }

}

abstract class Animal{}

class Dog extends Animal implements Comparable<Dog>{

    @Override
    public int compareTo(Dog o) {
        return 0;
    }
}

class Cat extends Animal{}



class MyClass<E>{
    public void m1(E e){

    }
}

interface MyInterface<T>{
    public void m2(T t);
}

class MyImplClass implements MyInterface<Byte>{

    @Override
    public void m2(Byte aByte) {

    }
}