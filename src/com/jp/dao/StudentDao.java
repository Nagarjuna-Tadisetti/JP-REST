package com.jp.dao;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.jp.model.Student;  
public class StudentDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(Student s){  
		String sql="insert into student(firstname,lastname,location,grade) values('"+s.getFirstname()+"','"+s.getLastname()+"','"+s.getLocation()+"','"+s.getGrade()+"')";  
	    return template.update(sql);  
	}  
	public int update(Student s){  
		String sql="update student set firstname='"+s.getFirstname()+"', lastname="+s.getLastname()+", location='"+s.getLocation()+"', grade='"+s.getGrade()+"' where id="+s.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from student where id="+id+"";  
	    return template.update(sql);  
	}  
	public Student getStudentById(int id){  
	    String sql="select * from student where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
	}  
	public List<Student> getStudents(){  
	    return template.query("select * from student",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	        	Student s=new Student();  
	            s.setId(rs.getInt(1));  
	            s.setFirstname(rs.getString(2));  
	            s.setLastname(rs.getString(3));  
	            s.setLocation(rs.getString(4));
	            s.setGrade(rs.getString(5));
	            return s;  
	        }  
	    });  
	}  
	
}
