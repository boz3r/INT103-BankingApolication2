package bankingapolication2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dol
 */
public class BankingApolication2 {

    public static void main(String[] args) {
        int option = 0, accountNumber;
        String accountName;
        double amount, balanced;

        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank("pluto");

        while (option != 6) {

            System.out.println("Main Menu");
            System.out.println("1. Display all account.");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.print("Enter: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    bank.listAccount();
                    break;
                case 2:
                    accountNumber = generateAccNumber();
                    System.out.print("Enter Account Name: ");
                    accountName = scan.nextLine();
                    System.out.print("Enter Account Balanced: ");
                    balanced = scan.nextDouble();
                    bank.openAccount(accountNumber, accountName, balanced);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    bank.closeAccount(accountNumber);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Amount Number: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(accountNumber, amount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Amount Number: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(accountNumber, amount);
                    break;
            }
            System.out.println();
        }
    }
    
    public static int generateAccNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(9000000);
    }
}
