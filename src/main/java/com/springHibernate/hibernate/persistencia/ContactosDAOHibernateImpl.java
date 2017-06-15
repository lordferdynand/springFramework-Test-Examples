package com.springHibernate.hibernate.persistencia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.springHibernate.hibernate.entidades.Contacto;
import com.springHibernate.hibernate.excepciones.DatabaseException;

public class ContactosDAOHibernateImpl implements ContactosDAO {
	
	private Session sesion;
	
//	private Transaction transaction;
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public long guardaContacto(Contacto contacto) throws HibernateException {
		long id = 0;
		try{
			iniciaOperacion();
			id = (Long) sesion.save(contacto);
			//if (true){
			//	throw new DatabaseException("Este no contacto se Guardara");
			//}
//			transaction.commit();
		} catch(HibernateException he){
			he.printStackTrace();
//			manejaExcepcion(he);
			throw he;
		} finally{
//			sesion.close();
		}
		return id;
		
	}
	
	public void actualizaContacto(Contacto contacto) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(contacto);
//			transaction.commit();
		} catch (HibernateException he) {
//			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void eliminaContacto(Contacto contacto) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(contacto);
//			transaction.commit();
		} catch (HibernateException he){
//			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Contacto obtenContacto(long idContacto) throws HibernateException {
		Contacto contacto = null;
		try {
			iniciaOperacion();
			contacto = (Contacto) sesion.get(Contacto.class, idContacto);
			
		} finally {
//			sesion.close();
		}
		return contacto;
	}
	
	public List<Contacto> obtenListaContactos() throws HibernateException {
		List<Contacto> listaContactos = null;
		try {
			iniciaOperacion();
			listaContactos = sesion.createQuery("from Contacto").list();
		} finally {
//			sesion.close();
		}
		
		return listaContactos;
	}
	
	private void iniciaOperacion() throws HibernateException {
		
		sesion = sessionFactory.getCurrentSession();
//		transaction = sesion.beginTransaction();
		
	}
	

}
