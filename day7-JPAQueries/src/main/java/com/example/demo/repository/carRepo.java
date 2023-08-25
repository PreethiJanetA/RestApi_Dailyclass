package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.car;

import jakarta.transaction.Transactional;

public interface carRepo extends JpaRepository<car,Integer> {

	@Query(value="Select * from car",nativeQuery=true)
	public List<car> getAllRows();
	
	@Query("select h from car h where h.Carname like %?1%")
	public List<car> getByname(@Param("Carname") String Carname);

	@Query(value="select * from car where carname=:carname and carType=:carType",nativeQuery=true)
	public List<car> getSpecRows(@Param("carname") String carname,@Param("carType") String carType);

	//DELETE QUERY
		@Modifying
		@Transactional
		@Query (value="delete from car where id=:id1", nativeQuery=true)
		public int deleteId(@Param("id1") int id);
		
		//UPDATE
		@Modifying
		@Transactional
		@Query(value="Update car set CarType=:CarType where id=:id",nativeQuery=true)
		public Integer updateByid(@Param("CarType") String CarType,@Param("id") int id);
}
