package com.chapter4.chapter4.Repository;

import com.chapter4.chapter4.Model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, Integer> {
}
