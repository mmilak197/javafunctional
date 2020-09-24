package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        String phoneNumber = "07000000003";
        String phoneNumber2 = "09000000300";

        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid(phoneNumber));
        System.out.println(isPhoneNumberValid(phoneNumber2));


        System.out.println("With predicate");
        System.out.println(isPhonNumberValidPredicate.test(phoneNumber));
        System.out.println(isPhonNumberValidPredicate.test(phoneNumber2));

        // We can combine two or more predicates
        // in this case both condition have to be true that final result will be true
        System.out.println("Is phoneNumber valid and contains number 3 : " + phoneNumber2);
        System.out.println(isPhonNumberValidPredicate.and(containsNumber3Predicate).test(phoneNumber2));

        // in this case one of them have to be true that final result will be true
        System.out.println("Is phoneNumber valid or contains number 3 : " + phoneNumber);
        System.out.println(isPhonNumberValidPredicate.or(containsNumber3Predicate).test(phoneNumber));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhonNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07")
            && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains("3");
}
