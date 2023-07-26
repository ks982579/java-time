public class App {
    public static void main(String[] args) throws Exception {
        Person John = new Person();
        John.name = "John";
        John.age = 40;
        John.height = 1.88f;
    }
}

class Person extends Object {
    String name;
    int age;
    float height;
}