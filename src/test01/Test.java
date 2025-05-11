package test01;

/**
 * @测试类
 */
public class Test {
    //程序入口
    public static void main(String[] args) {
        //对Person类进行实例化
        Person p1 = new Person();
        //对属性赋值
        p1.name = "张三";
        p1.age = 20;
        p1.height=180.0;
        //属性读取
        System.out.println(p1.name);
        System.out.println(p1.age);
        //调用对象的方法
        p1.study();
    }
}
