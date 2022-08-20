package com.pension.process.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionDetailsEntity {
	 public PensionDetailsEntity(String name, LocalDate dateOfBirth, String panNumber, String pensionType,
			double pensionAmount, double bankServiceCharge) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.pensionType = pensionType;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String name;
	 private LocalDate dateOfBirth;
	 private String panNumber;
	 private String pensionType;
	 private double pensionAmount;
	 private double bankServiceCharge;
}
