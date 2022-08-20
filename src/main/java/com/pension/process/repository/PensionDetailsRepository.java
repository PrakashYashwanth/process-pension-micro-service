package com.pension.process.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pension.process.entity.PensionDetailsEntity;

@Repository
public interface PensionDetailsRepository extends JpaRepository<PensionDetailsEntity, Long>{

}
