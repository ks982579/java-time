public class App {
    public static void main(String[] args) throws Exception {
        Neanderthal Tom = new Neanderthal();
        Tom.name = "Tom";
        Tom.age = 40;
        Tom.height = 1.88f;

        Neanderthal Joe = new Neanderthal();
        Joe.count++;
        System.out.println(Tom.count);
    }
}

class Neanderthal extends Object {
    static final int LIFESPAN = 50;
    static int count = 0;
    String name;
    int age;
    float height;
}