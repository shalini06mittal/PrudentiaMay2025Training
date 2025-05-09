package hasa;

class A{
    B ob;
    A(){}
    public A(B ob){
        this.ob = ob;
    }
}

class B{}
public class Test {

    public static void main(String[] args) {

        B b1 = new B();
        A a1 = new A();

//        Author a1 = new Author("abc","abc@gmail.com","www.linkedin1");
//        Book b1 = new Book(1, "t1",234,a1);
//        System.out.println(b1.getAuthor().getName());
    }

}

