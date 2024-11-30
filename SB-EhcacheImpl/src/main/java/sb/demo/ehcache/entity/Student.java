package sb.demo.ehcache.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Integer studentId;
	
	private Integer courseId;
	
	private String studentName;
	
	private String studentCity;
	
	
	public Student() {
	}
	

	public Student(Integer studentId, Integer courseId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}


	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

		

}

