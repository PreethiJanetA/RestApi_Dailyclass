package com.restapi.project.review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.project.review.Model.paymentmodel;

public interface paymentrepo extends JpaRepository<paymentmodel,Integer> {

}
