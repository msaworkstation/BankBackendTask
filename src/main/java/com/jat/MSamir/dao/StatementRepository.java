package com.jat.MSamir.dao;

import com.jat.MSamir.domain.Statement;
import org.springframework.data.repository.CrudRepository;

public interface StatementRepository extends CrudRepository<Statement, Long> {
}