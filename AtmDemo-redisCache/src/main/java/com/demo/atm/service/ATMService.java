package com.demo.atm.service;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.demo.atm.entity.ATM;

public interface ATMService {
	
	Set<ATM> getAll();
	
	List<ATM> getAllAtmByCity(@NotNull String city);

	void save(ATM atm);

}
