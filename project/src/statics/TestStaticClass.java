package statics;

public class TestStaticClass {

    public static void main(String[] args){
        System.out.println(Outer.num);
        Outer.method();

        Outer.Inner in = new Outer.Inner();
        in.method1();

        System.out.println(Outer.Inner.num2);
        Outer.Inner.method2();
    }
}

class Outer{
    static int num = 10;

    static class Inner{
        int num1 = 20;
        static int num2 = 30;

        public void method1(){
            System.out.println(this.num1);
        }

        public static void method2() {
            System.out.println(num2);
        }
    }

    static void method(){
        System.out.println();
    }

}
