package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;
import edu.cjc.sms.app.serviceI.StudentserviceI;
@Service
public class Studentserviceimpl implements StudentserviceI {
	
	
	@Autowired
	StudentRepository sr;

	@Override
	public void saveData(Student s) {
		sr.save(s);
		
	}
	
		
	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) sr.findAll();
	}


	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batchStudent=sr.findAllByBatchNumber(batchNumber);
		return batchStudent;
	}


	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent=sr.findById(id);
		
		return opStudent.get();
	}


	@Override
	public void updateStudentFees(int studentid, float ammount) {
	 Optional<Student>opstudent=sr.findById(studentid);
	 Student st=opstudent.get();
	 
	 st.setFeesPaid(st.getFeesPaid() +ammount);
	 sr.save(st);
		
	}

		
		
	

}
