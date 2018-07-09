package com.test.inv.http.dao;

import org.springframework.stereotype.Repository;

import com.test.inv.http.entity.UserData;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{
	
	UserData findByName(String name);
}
