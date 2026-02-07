package hibernatestudentmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import hibernatestudentmanagement.entity.Student;
import hibernatestudentmanagement.util.EMFObject;

public class StudentDAO {
	EntityManagerFactory emf=EMFObject.getEMF();
	
	public void save(Student st) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(st);
		transaction.commit();

		System.out.println("-----Details Added Successfully✅------");
	}
	
	//Update All
	public boolean update(int id,String name,String email,String course) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student = em.find(Student.class, id);
		if(student!=null) {
			student.setName(name);
			student.setEmail(email);
			student.setCourse(course);
			em.merge(student);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	//Update by Name
	public boolean updateName(int id,String name) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student = em.find(Student.class, id);
		if(student!=null) {
			student.setName(name);
			em.merge(student);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	//Update By Email
	public boolean updateEmail(int id,String email) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student = em.find(Student.class, id);
		if(student!=null) {
			student.setEmail(email);
			em.merge(student);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	//Update By Course
	public boolean updateCourse(int id,String course) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student = em.find(Student.class, id);
		if(student!=null) {
			student.setCourse(course);
			em.merge(student);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	
	//Delete 
	public boolean delete(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student=em.find(Student.class, id);
		if(student!=null) {
			em.remove(student);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	public List<Student> fetchAll() {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		List<Student> students=null;
		students=em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		
		return students;
	}
	public List<Student> fetchByName(String name) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		List<Student> students=null;
		students=em.createQuery("SELECT s FROM Student s where s.name=:n", Student.class).setParameter("n", name).getResultList();
		
		return students;
	}
	public List<Student> fetchByEmail(String email) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		List<Student> students=null;
		students=em.createQuery("SELECT s FROM Student s where s.email=:e", Student.class).setParameter("e", email).getResultList();
		
		return students;
	}
	public List<Student> fetchByCourse(String course) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		List<Student> students=null;
		students=em.createQuery("SELECT s FROM Student s where s.course=:c", Student.class).setParameter("c", course).getResultList();
		
		return students;
	}
	public List<Student> fetchById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		List<Student> students=null;
		students=em.createQuery("SELECT s FROM Student s where s.id=:i", Student.class).setParameter("i", id).getResultList();
		
		return students;
	}
}
