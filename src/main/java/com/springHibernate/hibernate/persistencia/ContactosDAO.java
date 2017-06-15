package com.springHibernate.hibernate.persistencia;

import java.util.List;

import org.hibernate.HibernateException;

import com.springHibernate.hibernate.entidades.Contacto;
import com.springHibernate.hibernate.excepciones.DatabaseException;

public interface ContactosDAO {
	
	void actualizaContacto(Contacto contacto) throws HibernateException;
	
	void eliminaContacto(Contacto contacto) throws HibernateException;
	
	long guardaContacto(Contacto contacto) throws  HibernateException;
	
	Contacto obtenContacto(long idContacto) throws HibernateException;
	
	List<Contacto> obtenListaContactos() throws HibernateException;

}
