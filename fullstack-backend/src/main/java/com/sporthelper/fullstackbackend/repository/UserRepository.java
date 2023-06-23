package com.sporthelper.fullstackbackend.repository;

import com.sporthelper.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
