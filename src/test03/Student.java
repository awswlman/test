package test03;

public class Student extends Person{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //学习
    public void study(){
        System.out.println("学习");
    }
}