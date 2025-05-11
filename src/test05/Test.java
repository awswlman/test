package test05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 书籍信息：
 书籍编号  书籍信息   书籍作者
  1  Java编程思想   Bruce Eckel
 */
public class Test {
    public static void main(String[] args) {
        //创建一个集合存储书籍对象
        ArrayList list=new ArrayList();
       while (true){
           System.out.println("------欢迎来到图书管理系统------");
           System.out.println("1.展示书籍");
           System.out.println("2.上新书籍");
           System.out.println("3.下架书籍");
           System.out.println("4.退出应用");
           //借助Scanner类获取用户输入的选项
           Scanner sc = new Scanner(System.in);
           //给提示
           System.out.println("请输入您的选项：");
           //获取用户输入的选项
           int choice = sc.nextInt();
           //根据用户输入的选项进行不同的操作
           if(choice == 1){
               System.out.println("图书管理系统>>>>>>1.展示书籍");
               System.out.println("编号 ----- 名称 ----- 作者 ");
               for (int i = 0; i < list.size() ; i++) {
                   Book book=(Book) (list.get(i));
                   System.out.println(book.getId()+" ----- "+book.getName()+" ----- "+book.getAuthor());
               }
           }
           if(choice == 2){
               System.out.println("图书管理系统>>>>>>2.上新书籍");
               System.out.println("书籍编号:");
               int bookId = sc.nextInt();
               System.out.println("书籍名称:");
                String bookName = sc.next();
                System.out.println("书籍作者:");
                String bookAuthor = sc.next();
                //创建书籍对象
                Book book = new Book(bookId,bookName,bookAuthor);
                book.setId(bookId);
                book.setName(bookName);
                book.setAuthor(bookAuthor);
                //将书籍对象添加到集合中
                list.add(book);


           }
           if(choice == 3){
               System.out.println("图书管理系统>>>>>>3.下架书籍");
                //录入下架书籍编号
                System.out.println("请输入要下架的书籍编号：");
                int delId = sc.nextInt();
                //下架编号对应的书籍
               for (int i = 0; i < list.size(); i++) {
                   Book book= (Book) (list.get(i));
                   if (book.getId()==delId){//如果找到了，则删除
                       list.remove(book);
                       System.out.println("下架成功");
                       break;//跳出循环

               }
           }
           if(choice == 4){
               System.out.println("图书管理系统>>>>>>4.退出应用");
                break;//退出循环
           }
       }
    }
}
}
