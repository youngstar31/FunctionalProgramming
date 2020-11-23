package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Optional.ofNullable("john@gmail.com").ifPresentOrElse(email -> System.out.println("Sending email to " + email), () -> System.out.println("Cannot send email"));

//        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
//        Object value = Optional.ofNullable("Hello").orElseThrow(exception);


//        Object value = Optional.ofNullable("Hello").orElseGet(() -> "default value");
        //If there is a value print "Hello" if value is null print "default value"

//        System.out.println(value);
    }
}
