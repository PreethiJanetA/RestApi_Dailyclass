package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.petrolbunk;

public interface fuelrepo extends JpaRepository<petrolbunk,Integer>{

}
