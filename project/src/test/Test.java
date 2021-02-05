package test;

public class Test {
    public static void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.method1();
    }
}

class Outer{

    private int num = 10;

    class Inner{
        int num = 20;
        public void method1(){
            int num = 30;
            System.out.println(num);//访问局部变量
            System.out.println(this.num);//访问内部类的实例变量
            System.out.println(Outer.this.num);//访问外部类的实例变量
        }
    }
}