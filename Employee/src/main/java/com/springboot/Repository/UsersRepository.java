package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Users_;


public interface UsersRepository extends JpaRepository<Users_,Long> {

}
