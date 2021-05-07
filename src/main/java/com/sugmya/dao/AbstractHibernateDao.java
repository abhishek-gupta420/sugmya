package com.sugmya.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.sugmya.config.DbConfig;

public abstract class AbstractHibernateDao< T >  {
	
	@Autowired
	private DbConfig dbConfig;
	
	private Class< T > clazz;
	
	protected final Session getCurrentSession() {
		
		return dbConfig.getSessionFactory().getCurrentSession();
	}
	
	public final void setClazz( Class< T > clazzToSet ){
		this.clazz = clazzToSet;
	}
	
	public T findOne( int id ){
		return (T) getCurrentSession().get( clazz, id );
	}
	
	@SuppressWarnings("unchecked")
	public List< T > findAll(){
		return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	}
	
	public int create( T entity ){
		
		Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int id = (Integer)session.save( entity );
            transaction.commit();
            return id;
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            throw e;
        }
		
	}
	
	public void update( T entity ){

		Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge( entity );
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            throw e;
        }
		
	}

	public void delete( T entity ){
		
		Session session = getCurrentSession();
        Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             session.refresh(entity);
             session.delete( entity );
             transaction.commit();
         }
         catch (Exception e) {
             if (transaction!=null) transaction.rollback();
             throw e;
         }
	}
	
	public long count() {
		Session session = getCurrentSession();
		if(clazz != null) {
			return (long) session.createQuery("select count(id) from " +clazz.getName()).uniqueResult();
		}
		return 0;
	}
}
