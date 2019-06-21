package com.sb.springbootdemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class App {

    public static void main(String[] args) {
        App app = new App();
        //app.go();
        app.sorting();
    }

    private String currentName = "xyz";
    private JTextField query;

    public void sorting() {
        List<Account> accounts = new ArrayList<>();
        Account ac = new CheckingAccount("Bob", 38383, Status.ABANDONED);
        accounts.add(ac);

        ac = new SavingsAccount("Sammy", 93939);
        accounts.add(ac);

        ac = new SavingsAccount("Bobery", 93939);
        accounts.add(ac);


        ac = new SavingsAccount("Rahul", 50000);
        accounts.add(ac);

        ac = new SavingsAccount("Zoey", 383989393);
        accounts.add(ac);

        Collections.sort(accounts);

        for (Account account : accounts) {
            System.out.println(account);
        }


        NameComparator nc = new NameComparator();
        BalanceComp balanceComp88 = new BalanceComp();


        //BalanceAndThenName ban = new BalanceAndThenName();
        Comparator<Account> ban = balanceComp88.thenComparing(nc);


        //NameComparator nc = new NameComparator();
        //Collections.sort(accounts, nc);
        Comparator<Account> balanceComp = new Comparator<Account>() {
            @Override
            public int compare(Account account1, Account account2) {
                return (int) (account1.getBalance() - account2.getBalance());
            }
        };

        Comparator<Account> balanceComp2 = (Account account1, Account account2) -> {
            return (int) (account1.getBalance() - account2.getBalance());
        };

        Comparator<Account> balanceComp3 = (account1, account2) -> {
            return (int) (account1.getBalance() - account2.getBalance());
        };

        Comparator<Account> balanceComp4 =
                (account1, account2) ->
                        (int) (account1.getBalance() - account2.getBalance());

        //Collections.sort(accounts, com.sb.springbootdemo.Account.nameComp);
        Collections.sort(accounts, ban);

        System.out.println("After sort");
//        for (com.sb.springbootdemo.Account account : accounts) {
//            System.out.println(account);
//        }

        MyConsumer mc = new MyConsumer();
        //accounts.forEach(mc);
        accounts.forEach(a -> System.out.println(a));
    }

    class MyConsumer implements Consumer<Account>
    {
        @Override
        public void accept(Account account) {
            System.out.println(account);
        }
    }

    class BalanceAndThenName implements Comparator<Account> {
        @Override
        public int compare(Account account1, Account account2) {
            int result = (int) (account1.getBalance() - account2.getBalance());
            if(result == 0) {
                result = account1.getName().compareTo(account2.getName());
            }

            return result;
        }
    }

    class BalanceComp implements Comparator<Account> {
        @Override
        public int compare(Account account1, Account account2) {
            return (int) (account1.getBalance() - account2.getBalance());
        }
    }

    class NameComparator implements Comparator<Account> {
        @Override
        public int compare(Account account1, Account account2) {
            return account2.getName().compareTo(account1.getName());
        }
    }

    public void go() {
        JFrame jFrame = new JFrame("Our com.sb.springbootdemo.App");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("OK");
        jFrame.add(button, BorderLayout.CENTER);

        query = new JTextField(10);
        jFrame.add(query, BorderLayout.NORTH);

        jFrame.setSize(new Dimension(300, 300));
        jFrame.setVisible(true);

        ActionListener myListener = new MyActionListener();

        ActionListener myListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());

            }
        };

        //Verbose Lambda, With argument type and curly braces
        ActionListener myListener3 = (ActionEvent e) -> {
            System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());
        };
        //Without the argument type
        ActionListener myListener4 = (e) -> {
            System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());
        };

        //Without the braces
        ActionListener myListener5 = (e) ->
                System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());

        //Only 1 argument, so no parentheses needed on argument
        ActionListener myListener6 = e ->
                System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());


        button.addActionListener(myListener2);

    }


    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Current Name is " + query.getText());

        }
    }
}
