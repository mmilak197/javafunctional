package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(value);

        String hello = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        System.out.println(hello);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        String excep = Optional.ofNullable("Hello")
                .orElseThrow(exception);

        System.out.println(excep);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> {
                    System.out.println("Sending email to " + email);
                });

        Optional.ofNullable(null)
                .ifPresent(it -> {
                    System.out.println("Print value " + it);
                });

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        });
    }
}
