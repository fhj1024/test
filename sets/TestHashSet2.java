package sets;

import java.util.HashSet;
import java.util.Objects;

public class TestHashSet2 {
    public static void main(String[] args){

        Student s1 = new Student("tom",20,99D,"男");
        Student s2 = new Student("jack",22,96D,"女");
        Student s3 = new Student("marry",21,98D,"男");
        Student s4 = new Student("annie",24,97D,"女");
        Student s5 = new Student("tom",20,99D,"男");

        HashSet<Student> hs = new HashSet<Student>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s1);//插入重复对象（地址重复）
        hs.add(s5);//插入重复对象（地址不同，内容相同）

        for (Student stu: hs) {
            System.out.println(stu);
            //System.out.println(stu.name.hashCode()+"\t"+stu.age.hashCode()+"\t"+stu.sex.hashCode()+"\t"+stu.score.hashCode());
        }

        //System.out.println(s1.equals(s5));


    }
}

class Student{
    String name;
    Integer age;
    Double score;
    String sex;

    public Student() {
        super();
    }

    public Student(String name, Integer age, Double score, String sex) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}'+this.hashCode();
    }

    //先比较哈希码，哈希码相同，调用equals方法，不同则不调用
    @Override
    public boolean equals(Object o) {
        System.out.println("-----Student equals() Exected-----");

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(score, student.score) && Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+this.age+this.sex.hashCode()+this.score.hashCode();
    }
}
