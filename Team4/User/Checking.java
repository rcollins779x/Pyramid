package Team4.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import static Team4.Input.InputValidation.*;

public class Checking {
    Path transactionHistoryPath = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\leo\\database\\Ledger.csv");
    public void showChecking(User customer) throws IOException {
        System.out.println("You have $" + customer.getCheckingBalance() + " in this account.");
        System.out.println("Is there anything else you would like to do?");
        int input;
        do {
            System.out.println("0- Go Back");
            System.out.println("1- Deposit");
            System.out.println("2- Withdrawal");
            System.out.println("3- Transfer to another Account");
            System.out.println("4- Buy NOTAS crypto coins ($100,000 per coin)");
            input = IntChoice();
            if (input == 1) deposit(customer,true);
            if (input == 2) withdraw(customer);
            if (input == 3) transfer(customer);
            if (input == 4) {
                System.out.println("Thank you for your purchase. Delivery of NOTAS estimated in 5 years.");
                withdraw(customer);
            }
        } while (input != 0);
    }

    private void deposit(User customer, boolean verbose) {
        if(verbose) {
            System.out.println("How much would you like to deposit?");
            customer.setCashOnHand(DoubleChoice());
        }
        customer.setCheckingBalance(customer.getCashOnHand());

        if(verbose) System.out.println("$" + customer.getCashOnHand() + " has been successfully added. " +
                "Your new balance is $" + customer.getCheckingBalance());

        try {    //Write info to TransactionalHistory
            appendTransactionToLedger(customer);
        } catch (IOException ignored) {
            System.out.println("Something went wrong with the Ledger. Please try again later");
        }

        //Update checking records with latest information
        String newData = String.format("%d,%s,%s,%s,%s,%s,%s,%s", customer.getIndex(), customer.getFirstName(),
                customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(), customer.getSalary(),
                customer.getCheckingBalance(), customer.getCreditScore());
        try {   //Save checking record to CSV vile
            ArrayList<String> records = ReadCheckingRecords();
            //System.out.println(records.stream().toArray().toString());
            records.set(customer.getIndex(),newData);
            Path file = Paths.get(System.getProperty("user.dir") + "\\src\\Team4\\database\\CheckingRecords.csv");
            Files.write(file,"".getBytes());
            for (String record : records) {Files.write(file, (record + "\n").getBytes(), StandardOpenOption.APPEND);}
            System.out.println(file.toAbsolutePath());
        } catch (IOException ignored) {}
    }

    //Returns the amount withdrawn
    public double withdraw(User customer) throws IOException {
        double cash;
        System.out.println("How much would you like to withdraw?");
        cash = DoubleChoice();

        if (!(customer.getCheckingBalance() >= cash)) {
            System.out.println("You have entered an amount that is greater than your current balance");
            cash = 0;
        }
        else {
            customer.setCheckingBalance(-cash);
            System.out.println("$" + cash + " has been successfully withdrawn. Your new balance is $" + customer.getCheckingBalance());

            //Replace string
            String newData = String.format("%d,%s,%s,%s,%s,%s,%s,%s", customer.getIndex(), customer.getFirstName(),
                    customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(), customer.getSalary(),
                    customer.getCheckingBalance(), customer.getCreditScore());

            //Save new balance
            ArrayList<String> records = ReadCheckingRecords();
            records.set(customer.getIndex(),newData );

            //Write line by line the file
            Path file = Paths.get(System.getProperty("user.dir") + "\\src\\Team4\\database\\CheckingRecords.csv");
            Files.write(file,"".getBytes());
            for (String record : records) {Files.write(file, (record + "\n").getBytes(), StandardOpenOption.APPEND);}
        }
        System.out.println(transactionHistoryPath.toAbsolutePath());
        return cash;
    }

    public void transfer(User customer) throws IOException {
        System.out.println("What is the ID of the person who you want to transfer money too?");
        int id = IntChoice();

        User receive = LoadUserData(id);
        double cash = withdraw(customer);
        deposit(receive,false);
        System.out.println(transactionHistoryPath.toAbsolutePath());
    }
}
