package backup;

public class MyPrinter implements Printer{

    // @Value("${printer.name}")
    // private String name;

    // @Value("${printer.count}")
    // @Value("${printer.count:5}")
    // private Integer count;

    @Override
    public void Print(String message) {
        // count--;
        // System.out.println(name + " prints " + message);
        // System.out.println("Times left: " + count);
    }
}
