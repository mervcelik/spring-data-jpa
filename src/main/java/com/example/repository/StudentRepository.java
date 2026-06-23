package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {//CrudRepository de extend edilebilir

	
	//HQL: sınıfın ismi ve değişken isimleri kullanılarak sorgu yazılır.
	//SQL: tablo ismi ve tablo içerisindeki Kolon isimleri ile sorgular yazılır.  nativeQuery true olmalıdır.
	@Query(value = "from Student",nativeQuery = false)
	List<Student> findallStudents();
}
