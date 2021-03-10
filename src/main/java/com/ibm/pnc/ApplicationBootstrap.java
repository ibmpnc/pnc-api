package com.ibm.pnc;

import com.ibm.pnc.models.Transactions;
import com.ibm.pnc.services.AccountService;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

//@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = LoggerFactory.getLogger(ApplicationBootstrap.class);

    private final AccountService accountService;
    private String[] type ={"DEPOSIT","WITHDRAW"};
    private String[] accountNum ={"acc1","acc2","acc3"};
    public ApplicationBootstrap( AccountService accountService){
        this.accountService=accountService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if( this.accountService.getTransList().size()==0)
        {
            for (int i = 0; i < 10000; i++) {
                Transactions trans = getRandomTransaction();

                log.info(trans.getAccountNumber());
                log.info(trans.getType());
                log.info("Amount " + trans.getAmount());
                log.info(trans.getType());
                this.accountService.createTransaction(trans);
            }
        }
    }

    private Transactions getRandomTransaction(){
        Transactions newTransactions = new Transactions();
        Integer amount = ThreadLocalRandom.current().nextInt(0,100);
        Date now = new Date();
        Integer typeIndex = ThreadLocalRandom.current().nextInt(0,2);
        Integer accIndex = ThreadLocalRandom.current().nextInt(0,3);
        newTransactions.setType(getType(typeIndex));
        newTransactions.setTransactionTs(now.getTime());
        newTransactions.setAmount(amount);
        newTransactions.setAccountNumber(accountNumber(accIndex));
        return newTransactions;
    }

    String getType(int i){
     return type[i];
    }

    String accountNumber(int i){
        return accountNum[i];
    }
}
