package local;

public class TestLocalClass {
    public static void main(String[] args){
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer{
    int num = 10;

    public void method(){
        int num1 = 20;
        String local = "hello";

        class Inner{//局部内部类，作用范围和创建对象范围仅限于当前方法
            int num = 30;

            public void method1(){
                int num = 40;
                System.out.println(local);
                System.out.println(num);
                System.out.println(this.num);
                System.out.println(num1);
                System.out.println(Outer.this.num);

            }
        }

        Inner inner = new Inner();
        inner.method1();

    }
}
