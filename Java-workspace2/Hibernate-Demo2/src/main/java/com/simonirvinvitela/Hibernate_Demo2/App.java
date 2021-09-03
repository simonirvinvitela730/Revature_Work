package com.simonirvinvitela.Hibernate_Demo2;

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
        System.out.println( "Project started..." );
        
        //create a configuration object 
        Configuration cfg = new Configuration();
        
        //read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        //create factory
        SessionFactory sf = cfg.buildSessionFactory();
        
        //open the session
        Session session = (Session)sf.openSession();
        
        //begin transaction
        Transaction t = session.beginTransaction();
        
        //create employee
        Employee employee= new Employee(1, "Mark", "M@gmail.com");
        
        
        //save employee
        session.save(employee);
        
        //commit the transaction
        t.commit();
        
       //close the session
        
        session.close();
        
        
       /* System.out.println(sf);
        System.out.println(sf.isClosed());*/
    }
}
