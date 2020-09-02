public class list区别 {
    public static void main(String arg[]) {
//        Student s1 = new Student("s1", "1");
//        Student s2 = new Student("s2", "1");
//        Student s3 = s1;
//        s1.run();;
short s1=1;
        s1 += s1;//s1=s1+s1

        System.out.println(s1);
//        p(s1, 4);
    }

    public static void p(Object o) {
        System.out.println(o);
    }

    public static void p(Object o, Integer i) {
        for (Integer j = 0; j < i; j++) {
            System.out.println(o);
        }
    }
}

interface animo{
     void sleep();
    public void grow();
}


abstract class Person {
    private String sex;

    public abstract void eat();

    public void run() {
        System.out.printf("我跑步了");
    }

    private String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }
}

class Teacher extends Person implements animo{
    String name;

    public void run() {
        System.out.printf("我到超长跑步了");
    }
    @Override
    public void sleep() {
    }
    @Override
    public void grow() {

    }

    @Override
    public void eat() {
        System.out.printf("到教师办公室吃饭");
    }
}

class Student extends Person {
    String name;
    String age;
    public void run() {
        System.out.printf("我到超长跑步了");
    }
    @Override
    public void eat() {
        System.out.printf("到食堂吃饭");
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return s.getName().equals(this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
