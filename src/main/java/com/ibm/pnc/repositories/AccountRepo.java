package com.ibm.pnc.repositories;

import com.ibm.pnc.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends  CrudRepository<Account,String > {
}
