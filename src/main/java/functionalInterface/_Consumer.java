package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "9999");

        // Normal java function
        greetCustomer(maria);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);

        getGreetCustomerConsumerV2.accept(maria, true);
        getGreetCustomerConsumerV2.accept(maria, false);
    }

    static BiConsumer<Customer, Boolean> getGreetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("BiConsumer Hello " + customer.customerName + ", thanks for register phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "******"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for register phone number "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for register phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
