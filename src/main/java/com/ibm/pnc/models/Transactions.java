    package com.ibm.pnc.models;


    import javax.persistence.*;

    @Entity
    public class Transactions {

         @Id
         @GeneratedValue(strategy= GenerationType.AUTO)
         private Long id;
         private String accountNumber;
         private  Long transactionTs;
         private String type;
         private double amount;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Long getTransactionTs() {
            return transactionTs;
        }

        public void setTransactionTs(Long transactionTs) {
            this.transactionTs = transactionTs;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
