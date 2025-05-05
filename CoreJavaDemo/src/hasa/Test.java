package hasa;

public class Test {

    public static void main(String[] args) {
        Author a1 = new Author("abc","abc@gmail.com","www.linkedin1");
        Book b1 = new Book(1, "t1",234,a1);
        System.out.println(b1.getAuthor().getName());
    }

}

