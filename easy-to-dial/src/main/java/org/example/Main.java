package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        String retry;

        do {
            System.out.print("Please enter a phone number: ");
            phoneNumber = scanner.nextLine();

            try {
                var isEasyToDial = PhoneNumberProcessor.isEasyToDial(phoneNumber);

                if (isEasyToDial) {
                    System.out.println("You entered: " + phoneNumber + ". This phone number is easy to dial!");
                }
                else {
                    System.out.println("You entered: " + phoneNumber + ". This phone number is NOT easy to dial!");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Do you want to enter another phone number? (yes/no): ");
            retry = scanner.nextLine();

        } while (retry.equalsIgnoreCase("yes"));

        scanner.close();
    }
}