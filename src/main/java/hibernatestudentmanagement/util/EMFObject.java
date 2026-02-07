package hibernatestudentmanagement.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFObject {
	public static EntityManagerFactory getEMF() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahesh");
		return emf;
	}
}
