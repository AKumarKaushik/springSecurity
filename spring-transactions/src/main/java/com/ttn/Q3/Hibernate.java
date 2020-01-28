package com.ttn.Q3;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class Hibernate {
    SessionFactory sessionFactoryBean;

    public Hibernate(SessionFactory sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

   public  Hibernate(){

    }
    void sessionFactoryDemo() {
        String sql = "select count(*) from  user";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println("Results are "+query.uniqueResult());
    }

    public SessionFactory getSessionFactoryBean() {
        return sessionFactoryBean;
    }

    public void setSessionFactoryBean(SessionFactory sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }
}
