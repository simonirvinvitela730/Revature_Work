package com.simonirvinvitela.Hibernate_Demo2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Proejct started...");
        
        // create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
               
        // create employee
//        Employee employee  =new Employee();
//        employee.setId(2);
//        employee.setName("Mark");
//        employee.setEmail("m@gmail.com");
//        
        // create address
        Address address = new Address();
        address.setCity("city 1");
        address.setStreet("street 1");
        address.setOpen(true);
        address.setCreated(new Date());
        address.setX(123.456);
        
        // save the employee
        // session.save(employee);
        session.save(address);
        
        
        // Fetch data
        Address address1 = session.get(Address.class, 1);
        System.out.println(address1);
        
        Address address2 = session.get(Address.class, 3);
        System.out.println(address2);
        
        Address address3 = session.load(Address.class, 3);
//        System.out.println(address3);
//        
        
        
        
        
        // commit the transaction
        t.commit();
        // close the session
        session.close();
        
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        
        
    }
}