package edu.cjc.sms.app.serviceI;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentserviceI {

	

	void saveData(Student s);
	public List<Student> getAllStudents();
	public List<Student>searchStudentByBatch(String batchNumber);
	Student getSingleStudent(int id);
	void updateStudentFees(int studentid, float ammount);

}
