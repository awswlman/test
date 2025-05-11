package test03;

public class Test {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setAge(19);
        s1.setName("张三");
        s1.setHeight(172.3);
        s1.setId(120034);
        s1.study();
        System.out.println(s1.getId());
    }
}
