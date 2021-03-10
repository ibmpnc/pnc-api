package com.ibm.pnc.services;

import com.ibm.pnc.models.Transactions;
import com.ibm.pnc.repositories.AccountRepo;
import com.ibm.pnc.repositories.TransactionsRepo;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    Logger log = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepo accountRepo;
    private final TransactionsRepo transactionsRepo;
    public AccountService(AccountRepo accountRepo,TransactionsRepo transactionsRepo){
        this.accountRepo=accountRepo;
        this.transactionsRepo=transactionsRepo;
    }

    public Transactions createTransaction(Transactions transaction) {
        return this.transactionsRepo.save(transaction);

    }


    public List<Transactions> getTransList() {
        return  IteratorUtils.toList(this.transactionsRepo.findAll().iterator()) ;
    }

    public List<Transactions> findByPage(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<Transactions> pageTrans = this.transactionsRepo.findAll(paging);
        Slice<Transactions> sliceTrans = null;
        log.info("Total elements number: "+ pageTrans.getNumberOfElements());
        log.info("Total Elements: "+ pageTrans.getTotalElements());
        log.info("Total pages: "+ pageTrans.getTotalPages());
        return  pageTrans.toList();
    }


}
