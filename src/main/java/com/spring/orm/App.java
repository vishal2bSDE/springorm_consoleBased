package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.studentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        studentDao studentDao= context.getBean("studentDao",studentDao.class);
//        Student student=new Student(1,"Vishal Mishra","Kolkata");
//        int r=studentDao.insert(student);
//        System.out.println(r+" done");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		studentDao studentDao= context.getBean("studentDao",studentDao.class);
		while (go) {
			System.out.println();System.out.println();System.out.println();System.out.println();
			System.out.println("PRESS 1 for add new Student-");
			System.out.println("PRESS 2 for display all Students-");
			System.out.println("PRESS 3 for get detail of single Student-");
			System.out.println("PRESS 4 for delete Student-");
			System.out.println("PRESS 5 for update Student-");
			System.out.println("PRESS 6 for exit-");
			System.out.println();System.out.println();
			try {
				int input=Integer.parseInt(br.readLine());
				switch(input) {
				case 1:
					System.out.println("----insert----");
					System.out.println("student id- ");
					int id=Integer.parseInt(br.readLine());
					System.out.println("student name- ");
					String name=br.readLine();
					System.out.println("student city- ");
					String city=br.readLine();
					Student student=new Student(id,name,city);
					studentDao.insert(student);
					System.out.println("Done Inserting");
					break;
				case 2:
					List<Student> students=studentDao.getAllStudents();
					System.out.println();System.out.println();
					for(Student s: students) {
						System.out.println(s);
					}
					break;
				case 3:
					System.out.println("-----Details_of_single_student----");
					System.out.println("Enter id-");
					int id1=Integer.parseInt(br.readLine());
					Student stu=studentDao.getStudent(id1);
					System.out.println();System.out.println();
					System.out.println(stu);
					break;
				case 4:
					System.out.println("-----Delete----");
					System.out.println("Delete id-");
					int delete=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(delete);
					System.out.println("deleted");
					break;
				case 5:
					System.out.println("-----Details_to_update_student----");
					System.out.println("-----update_student----");
					System.out.println("old_id-");
					int u_id=Integer.parseInt(br.readLine());
					System.out.println("new_name");
					String u_name=br.readLine();
					System.out.println("new_city");
					String u_city=br.readLine();
					stu=new Student(u_id,u_name,u_city);
					studentDao.updateStudent(stu);
					System.out.println("---updated---");
					break;
				case 6:go=false;
					break;
				}
			}catch (Exception e) {
				System.out.println("Invalid input try with another one...");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("****************Thankyou for giving time :) *****************");

	}
}
