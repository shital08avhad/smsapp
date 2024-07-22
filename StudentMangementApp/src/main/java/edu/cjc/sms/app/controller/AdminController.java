package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.serviceI.StudentserviceI;

@Controller
public class AdminController {
	@Autowired
	StudentserviceI ssi;
	
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username")String username,@RequestParam("password")String password, Model m) {
		
		if(username.equals("ADMIN") && password.equals("ADMIN")) {
			List<Student>students=ssi.getAllStudents();
			m.addAttribute("data",students);
			return "adminscreen";
		} else {
			m.addAttribute("msg","login invalid");
			return "login";
		}
	}
	@RequestMapping("/enroll_student")
	public String saveStusentData(@ ModelAttribute Student s,Model m) {
		ssi.saveData(s);
		List<Student> students= ssi.getAllStudents();
		m.addAttribute("data",students);
		return "adminscreen";
		
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m) {
		
		List<Student>result=ssi.searchStudentByBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data",result);
		}else {
			List<Student> student=ssi.getAllStudents();
			m.addAttribute("data",student);
			m.addAttribute("message","no records are available for the batch"+batchNumber+"....!");
		}
		return "adminscreen";	
	}
	
	@RequestMapping("/fees")
	public String onFees(@RequestParam int id,Model m)
	{
		Student st=ssi.getSingleStudent(id);
		m.addAttribute("st",st);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid,@RequestParam float ammount,Model m)
	{
		ssi.updateStudentFees(studentid,ammount);
		List<Student>student=ssi.getAllStudents();
		m.addAttribute("data",student);
		return "adminscreen";
	}

}
