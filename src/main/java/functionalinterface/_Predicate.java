package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("WITHOUT PREDICATE");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("078900000"));
        System.out.println(isPhoneNumberValid("02000000000"));


        System.out.println("WITH PREDICATE");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("078900000"));
        System.out.println(isPhoneNumberValidPredicate.test("02000000000"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("09340000000"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("07340000000"));


    }


    //NORMAL JAVA FUNCTION
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    }

    //PREDICATE FUNCTION
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;


    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

}
