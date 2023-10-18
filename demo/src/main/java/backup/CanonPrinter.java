package backup;

import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer {
    @Override
    public void Print(String message) {
        System.out.println("Canon Printer prints " + message);
    }
}
