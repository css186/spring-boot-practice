package backup;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer {
    private int count;

    @PostConstruct
    public void init() {
        count = 5;
    }

    @Override
    public void Print(String message) {
        // count--;
        System.out.println("HP Printer prints: " + message);
        // System.out.println("Times left: " + count);
    }
}
