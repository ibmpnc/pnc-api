package com.ibm.pnc.controllers;

import com.google.gson.Gson;
import com.ibm.pnc.models.Transactions;
import com.ibm.pnc.models.TransactionsDto;
import com.ibm.pnc.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account/v1")
public class AccountController {
private final AccountService accountServices;

    public AccountController(AccountService accountServices){
        this.accountServices=accountServices;
    }

    @GetMapping("/trans")
    public String getTransaction(){

        return "OK";
    }

    @PostMapping("/new/trans")
    public ResponseEntity createTrans(@RequestBody TransactionsDto transaction){
        Transactions newTransaction = new Transactions();
        newTransaction.setAccountNumber(transaction.getAccountNumber());
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setTransactionTs(transaction.getTransactionTs().getTime());
        newTransaction.setType(transaction.getType());
        this.accountServices.createTransaction(newTransaction);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/trans/{pageNo}/{pageSize}")
    public List<Transactions> getTransactionByPage(@PathVariable int pageNo, @PathVariable int pageSize){
        return this.accountServices.findByPage(pageNo,pageSize);
    }
}
