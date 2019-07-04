package com.dbserver.testFun.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dbserver.testFun.models.TestFunModel;

public interface TestFunRepository extends CrudRepository<TestFunModel, String> {
	
	void deleteById(long id);
	Iterable<TestFunModel> findById(long id);
	

}
