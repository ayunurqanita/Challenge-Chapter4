package com.chapter4.chapter4.Repository;

import com.chapter4.chapter4.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
