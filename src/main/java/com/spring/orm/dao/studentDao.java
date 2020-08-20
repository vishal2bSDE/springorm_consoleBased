package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class studentDao {
	private HibernateTemplate hibernateTemplate;
//	@transactional is req where we alter the table
	@Transactional
	public int insert(Student student) {
		int i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
