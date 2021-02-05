package anonymity;

public class TestAnonymity {
    public static void main(String[] args){

        int num = (int)(Math.random()*10);
        Teacher tea = School.getTeacher(num);
        System.out.println(num);
        tea.teach();
    }
}

class School{

    public static Teacher getTeacher(int chooseNo){


        class BeginnerTeacher extends Teacher{

            @Override
            void teach() {
                System.out.println("初级老师、、、");
            }
        }
        /*
        class AdvancedTeacher extends Teacher{


            @Override
            void teach() {
                System.out.println("高级老师、、、");
            }
        }*/

        Teacher t;

        if(chooseNo % 2 == 0){
            t = new BeginnerTeacher();
        }else{
            t = new Teacher(){

                @Override
                void teach() {
                    System.out.println("高级老师、、、");
                }
            };


        }

        return t;

    }
}



abstract class Teacher{
    abstract void teach();
}