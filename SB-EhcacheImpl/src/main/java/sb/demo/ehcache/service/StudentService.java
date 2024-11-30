package sb.demo.ehcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sb.demo.ehcache.entity.Student;
import sb.demo.ehcache.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private EhCacheServiceImpl cacheService;

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	public Student getStudent(Integer id) {
		
		return cacheService.getStudentById(id);
	}
	
	public List<Student> saveStudents(List<Student> students) {
		return studentRepo.saveAll(students);
	}
}
