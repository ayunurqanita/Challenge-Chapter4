package com.chapter4.chapter4.Repository;

import com.chapter4.chapter4.Model.Scedules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScedulesRepository extends JpaRepository <Scedules, Integer> {
}
