package hibernatestudentmanagement.main;

import java.util.List;
import java.util.Scanner;

import hibernatestudentmanagement.dao.StudentDAO;
import hibernatestudentmanagement.entity.Student;

public class App {
	public static void main(String[] args) {
		
		StudentDAO dao=new StudentDAO();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("<--------Student Management System--------->");
		
		boolean flag=true;
		while(flag) {
			System.out.println("1. Add Student\n2. View Students Data\n3. UpdateStudent\n4. Delete Studen\n5. Exit");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Student Name: ");
				String name=sc.nextLine();
				System.out.println("Enter Student Email: ");
				String email=sc.nextLine();
				System.out.println("Enter Student Course: ");
				String course=sc.nextLine();
				Student st=new Student();
				st.setName(name);
				st.setEmail(email);
				st.setCourse(course);
				dao.save(st);
				break;
				
				
			case 2:
				System.out.println("1. Fetch By Id\n2. Fetch By Name\n3. Fetch By Email\n4.Fetch By Course\n5. Fetch All Records\n6. None");
				int pick=sc.nextInt();
				sc.nextLine();
				if(pick==5)break;
				
				if(pick==1) {
					System.out.println("Enter Id: ");
					int id=sc.nextInt();
					
					List<Student> students=dao.fetchById(id);
					System.out.printf("%-12s %-15s %-30s %-15s%n","Student Id","Student Name","Student Email","Student Course");
					System.out.println("----------------------------------------------------------------------------------");
					for(Student stu: students) {
						System.out.printf("%-12s %-15s %-30s %-15s%n",stu.getId(),stu.getName(),stu.getEmail(),stu.getCourse());
					}
				}
				else if(pick==2) {
					System.out.println("Enter Name: ");
					String name1=sc.nextLine();
					List<Student> students=dao.fetchByName(name1);
					System.out.printf("%-12s %-15s %-30s %-15s%n","Student Id","Student Name","Student Email","Student Course");
					System.out.println("----------------------------------------------------------------------------------");
					for(Student stu: students) {
						System.out.printf("%-12s %-15s %-30s %-15s%n",stu.getId(),stu.getName(),stu.getEmail(),stu.getCourse());
					}
				}
				else if(pick==3) {
					System.out.println("Enter Email: ");
					String email1=sc.nextLine();
					List<Student> students=dao.fetchByName(email1);
					System.out.printf("%-12s %-15s %-30s %-15s%n","Student Id","Student Name","Student Email","Student Course");
					System.out.println("----------------------------------------------------------------------------------");
					for(Student stu: students) {
						System.out.printf("%-12s %-15s %-30s %-15s%n",stu.getId(),stu.getName(),stu.getEmail(),stu.getCourse());
					}
				}
				else if(pick==4) {
					System.out.println("Enter Course: ");
					String course1=sc.nextLine();
					List<Student> students=dao.fetchByName(course1);
					System.out.printf("%-12s %-15s %-30s %-15s%n","Student Id","Student Name","Student Email","Student Course");
					System.out.println("----------------------------------------------------------------------------------");
					for(Student stu: students) {
						System.out.printf("%-12s %-15s %-30s %-15s%n",stu.getId(),stu.getName(),stu.getEmail(),stu.getCourse());
					}
				}
				else if(pick==5){
					List<Student> students=dao.fetchAll();
					System.out.printf("%-12s %-15s %-30s %-15s%n","Student Id","Student Name","Student Email","Student Course");
					System.out.println("----------------------------------------------------------------------------------");
					for(Student stu: students) {
						System.out.printf("%-12s %-15s %-30s %-15s%n",stu.getId(),stu.getName(),stu.getEmail(),stu.getCourse());
					}
				}
				break;
				
				
			case 3:
				System.out.println("1.Update Name\n2.Update Email\n3.Update Course\n4.Update All\n5.None");
				int pick1=sc.nextInt();
				sc.nextLine();
				if(pick1==5) {
					break;
				}
				System.out.println("Enter which student id details you want to Update:");
				int id1=sc.nextInt();
				if(pick1==1) {
					System.out.println("Enter Updated Student Name: ");
					String name1=sc.next();
					if(dao.updateName(id1, name1)) {
						System.out.println("Name is Updated to "+name1);
					}
					else System.out.println("Invalid Id.....");
				}
				else if(pick1==2) {
					System.out.println("Enter Updated Student Email: ");
					String email1=sc.nextLine();
					if(dao.updateEmail(id1, email1)) {
						System.out.println("Email is Updated to "+email1);
					}
					else System.out.println("Invalid Id.....");
				}
				else if(pick1==3){
					System.out.println("Enter Updated Student Course: ");
					String course1=sc.nextLine();
					if(dao.updateCourse(id1, course1)) {
						System.out.println("Course is Updated to "+course1);
					}
					else System.out.println("Invalid Id.....");
				}
				else if(pick1==4) {
					System.out.println("Enter Updated Student Name: ");
					String name1=sc.next();
					System.out.println("Enter Updated Student Email: ");
					String email1=sc.next();
					System.out.println("Enter Updated Student Course: ");
					String course1=sc.next();
					
					
					if(dao.update(id1,name1,email1,course1)) {
						System.out.println("Details of student id:"+id1+" are updated");
					}
					else System.out.println("Invalid Student Id!!!!");
				}
				break;
			case 4:
				System.out.println("Enter id to delete: ");
				int id2=sc.nextInt();
				if(dao.delete(id2)){
					System.out.println("Student with id="+id2+" is deleted!!");
				}
				else {
					System.out.println("Invalid Student Id!!!!");
				}
				break;
			case 5:
				System.out.println("Thank you.....");
				flag=false;
			}
		}
	}
}
