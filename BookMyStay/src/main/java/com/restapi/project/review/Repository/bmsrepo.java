//This interface is responsible for providing data access and manipulation methods for the "bmsmodel" entity class//
package com.restapi.project.review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//generic interface that provides a set of CRUD (Create, Read, Update, Delete) operations for interacting with entities in a database//

import com.restapi.project.review.Model.bmsmodel;
//includes saving, updating, deleting, and querying entities//

public interface bmsrepo extends JpaRepository<bmsmodel,Integer>{

}
