package com.cg.mtba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("select u from user u where u.userId =?1")
	User findUser(int userId);

}
