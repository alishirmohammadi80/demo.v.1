package com.example.demo.kala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface KalaRepository extends JpaRepository<Kala,Long> {
}
