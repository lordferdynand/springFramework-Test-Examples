package com.springHibernate.hibernate;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springHibernate.hibernate.entidades.Contacto;
import com.springHibernate.hibernate.persistencia.ContactosDAO;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    		Logger log = Logger.getLogger(App.class.getName());
    		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/springHibernate/xml/applicationContext.xml");
            ContactosDAO contactoDAO = appContext.getBean(ContactosDAO.class);
            long idContactoGuardado = contactoDAO.guardaContacto(new Contacto("Nombre 1","email1@gmail.com","+(502) 53996661"));
            
            Contacto contactoGuardado = contactoDAO.obtenContacto(idContactoGuardado);
            
            System.out.println("Nombre: " + contactoGuardado.getNombre());
            System.out.println("Email: " + contactoGuardado.getEmail());
            
            ((ClassPathXmlApplicationContext) appContext).close();
             		
            log.info("existe en el programa");
        
    }
}
