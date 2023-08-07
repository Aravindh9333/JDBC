package com.abc.HibernateDemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.HibernateDemo.model.Emp;

public class DaoImpl implements DaoInterface{

	SessionFactory sf=null;
	public DaoImpl() {
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	
	@Override
	public void addEmployee(Emp e) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(e);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteEmp(int i) {
		Session s=sf.openSession();
		Emp e=getEmployeeById(i);
		Transaction tx=s.beginTransaction();
		s.delete(e);
		tx.commit();
		s.close();
		
		
	}
	public Emp getEmployeeById(int i) {

		Session session=sf.openSession();
		Emp e=session.get(Emp.class, i); 
		session.close();
		return e;

	}

	@Override

	public List<Emp> viewAllEmployee() {
		Session session=sf.openSession();
		List<Emp> el=session.createQuery("from Emp", Emp.class).getResultList();
		session.close();
		return el;

	}

}
