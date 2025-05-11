package test01;

public class Person {
    //特性-属性-名词
    String name;
    int age;
    double height;


    //行为-方法-动作
    //定义一个学习的方法
    public void study() {
        System.out.println("青，取之于蓝，而胜于蓝，冰，取之于水，而寒于水。");
    }

    //显示编写空构造器
    public Person() {
    }

    //显示编写带参构造器
    //构造器的参数名字，如果和属性名字重名，就会发生就近原则
    //如果重名你想要给属性赋值，那么就在想要表达的属性前加this.来修饰
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}