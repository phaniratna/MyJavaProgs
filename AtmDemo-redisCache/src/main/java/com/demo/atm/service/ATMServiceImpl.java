package com.demo.atm.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.demo.atm.entity.ATM;

@Service
public class ATMServiceImpl implements ATMService {

	private RedisTemplate<ATM, String> redisTemplate;
	private HashOperations hashOperations; // to access Redis cache

	public ATMServiceImpl(RedisTemplate<ATM, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(ATM atm) {
		 hashOperations.put("ATM", atm.getAddress().getCity(), atm);
	}

	@Override
	public Set<ATM> getAll() {
		return (Set<ATM>) hashOperations.entries("ATM").keySet();
	}

	@Override
	public List<ATM> getAllAtmByCity(@NotNull String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
