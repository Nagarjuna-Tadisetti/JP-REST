package com.jp.controller;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.jp.model.Student;  
import com.jp.dao.StudentDao;  
@Controller
public class StudentController {
	 @Autowired  
	    StudentDao dao;//will inject dao from xml file  
	 	
	 	@RequestMapping(value="/")
	 	public List hello(){
	 		List<String> list = new ArrayList<String>();
	    	list.add("Hello");
	        return list;
	 	}
	       
	    @RequestMapping(value="/students")  
	    public List studentList(){  
	    	List<Student> list=dao.getStudents();
	    	return list;
	    }  
	    
	    @RequestMapping(value="/student",method = RequestMethod.POST)  
	    public List save(@RequestBody Student s){  
	        dao.save(s);
	        List<String> list = new ArrayList<String>();
	        return list;
	    }    
	 
	    @RequestMapping(value="/student/{id}")  
	    public List getStudent(@PathVariable int id){  
	    	Student s=dao.getStudentById(id);
	    	List<Student> list = new ArrayList<Student>();
	    	list.add(s);
	        return list;  
	    }    
	    
	    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
	    public List delete(@PathVariable int id){  
	        dao.delete(id);
	        List<String> list = new ArrayList<String>();
	        return list;
	    }  
}
