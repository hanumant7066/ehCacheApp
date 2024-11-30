package sb.demo.ehcache.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sb.demo.ehcache.entity.Student;
import sb.demo.ehcache.repository.StudentRepository;

@Service
public class EhCacheServiceImpl {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Cacheable(cacheNames = "GET_STUDENT", key = "#root.methodName + ':' + #id")
	public Student getStudentById(Integer id) {
		
		System.out.println("EhCacheServiceImpl: getStudentById starts with Id: "+ id );
		
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		System.out.println("EhCacheServiceImpl: getStudentById ends, student not found with Id: "+ id );
		return null;
	}

}
