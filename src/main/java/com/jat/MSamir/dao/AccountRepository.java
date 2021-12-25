package com.jat.MSamir.dao;

import com.jat.MSamir.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}