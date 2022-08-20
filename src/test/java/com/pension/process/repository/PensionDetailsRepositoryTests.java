package com.pension.process.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pension.process.entity.PensionDetailsEntity;

@DataJpaTest
public class PensionDetailsRepositoryTests {
	
	@Autowired
	private PensionDetailsRepository pensionrepo;

	@Test
	void verifyRepositoryByPersistingPensionerDetails() {
		PensionDetailsEntity pensionDetailsEntity = new PensionDetailsEntity("yash",LocalDate.now(),"ABCDEFGH","self",15000,500);
		pensionrepo.save(pensionDetailsEntity);
	    Assertions.assertNotNull(pensionDetailsEntity.getId());
	  }
	
}
