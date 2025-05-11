package test04;

public class Test {
    public static void main(String[] args) {
        Girl g = new Girl();
        Animal an;
        Cat c = new Cat();
        g.play(c);
        //合成一句
        Animal a= new Dog();
        g.play(a);

    }
}
