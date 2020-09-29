package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+079879879865",
                LocalDate.of(2000, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));



        // if value we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != SUCCESS) {
             throw new IllegalStateException(result.name());
        }

    }
}
