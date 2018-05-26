package com.altim.banking;

import com.altim.banking.commodity.Gold;
import com.altim.banking.commodity.KARAT;
import com.altim.banking.loan.CustomerType;
import com.altim.banking.loan.Loan;
import com.altim.banking.loan.NewCustomerLoanImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.altim.banking.service", "com.altim.banking.loan");
        applicationContext.refresh();
        Loan loan = applicationContext.getBean(NewCustomerLoanImpl.class);
        Gold g1 = new Gold(KARAT.TWENTYFOUR, 10);
        double e = loan.eligibility(1, CustomerType.NEW, g1, 400);
        System.out.printf("Loan eligibility is : " + e);
    }
}
