package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AdminEntity;
@Repository
public interface AdminRepositary extends JpaRepository<AdminEntity, Integer> {

}
