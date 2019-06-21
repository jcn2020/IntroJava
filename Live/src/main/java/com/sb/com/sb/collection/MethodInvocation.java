package com.sb.com.sb.collection;

public class MethodInvocation {

    public void go() {
       Account a = makeAccount();

    }

    public Account makeAccount() {
        for(;;) {
            Account a = new CheckingAccount("Andy", 28282);

            //Use a
        }
    }
}
