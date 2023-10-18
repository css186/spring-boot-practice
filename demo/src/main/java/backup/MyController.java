package backup;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/detail")
@RestController
public class MyController {

    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        store.setProductList(list);

        return store;

    }

//    @RequestMapping("/user")
//    public Student user() {
//        Student student = new Student();
//        student.setName("John");
//        return student;
//    }

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id) {
        System.out.println("id: " + id);
        return "Hello test1";
    }

    @RequestMapping("/test2")
    public void test2(@RequestParam Integer id,
                      @RequestParam(defaultValue = "Amy") String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
    }

    @RequestMapping("/test3")
    public void test3(@RequestParam int number) {
        System.out.println("number: " + number);
    }

    @RequestMapping("/test4")
    public String test4(@RequestBody Student student) {
        System.out.println("student id: " + student.getId());
        System.out.println("student name: " + student.getName());
        return "test4 Success";
    }

    @RequestMapping("/test5")
    public String test5(@RequestHeader String info) {
        System.out.println("info: " + info);
        return "test5 Success";
    }

    @RequestMapping("/test6/{id}/{name}")
    public String test6(@PathVariable Integer id, @PathVariable String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return "test6 Success";
    }

}



//@RestController
//public class MyController {
//
//    @Autowired
//    // @Qualifier("canonPrinter")
//    @Qualifier("hpPrinter")
//    // @Qualifier("myPrinter")
//    // @Qualifier("yourPrinter")
//    private Printer printer;
//
//    @RequestMapping("/test.json")
//    public String test.json() {
//        // System.out.println("Hi");
//        printer.Print("Hello, world!");
//        return "Hello, world!";
//    }
//
//    @RequestMapping("/greeting")
//    public String greeting() {
//        return "Hi, Welcome";
//    }
//
//}


