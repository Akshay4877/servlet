package com.yash.bankingapp.data;
import java.util.Date;
import org.hibernate.Session;

import com.yash.bankingapp.domain.User;

public class Application {
public static void main(String[] args) {
 Session session=HibernateUtil.getSessionFactory().openSession(); 
 session.getTransaction().begin();
 User user=new User();
 user.setFirstName("Akshay");
 user.setLastName("Patil");
 user.setBirthDate(new Date());
 user.setEmailAddress("akshay.patil@yash.com");
 user.setCreatedBy("akshay");
 user.setCreatedDate(new Date());
 user.setLastUpdatedDate(new Date());
 user.setLastUpdatedBy("akshay"); 
 session.saveOrUpdate(user);
 session.getTransaction().commit(); 
 session.close();
}
}
