package com.quikapp.test.repository;

import com.quikapp.test.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    public StudentEntity getByName(String name);

    public StudentEntity getByNic(String nic);

    public boolean existsByNic(String nic);

    @Query("SELECT s FROM StudentEntity s WHERE s.id = ?1 and  s.name= ?2")
    public StudentEntity getStudent(Long id,String name);
}
