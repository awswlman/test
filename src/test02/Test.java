package test02;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //定义一个集合
        ArrayList list=new ArrayList();
        System.out.println(list);
        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        //删除元素
        list.remove("hello");
        System.out.println(list);
        //修改元素
        list.set(0,"javaee");
        System.out.println(list);
        //获取元素
        System.out.println(list.get(1));
        //遍历集合
        for (int i=0;i<list.size() ;i++){
            System.out.println(list.get(i));
        }
//        增强for
        for (Object obj:list){
            System.out.println(obj);
        }
    }
}
