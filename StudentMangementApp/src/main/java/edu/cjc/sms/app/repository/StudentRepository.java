package edu.cjc.sms.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>
{

	

	List<Student> findAllByBatchNumber(String batchNumber);

	

		
	}

