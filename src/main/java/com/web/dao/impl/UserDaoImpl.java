package com.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.UserDao;
import com.web.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public User getByCodePassword(String user_name) {
		
		return getHibernateTemplate().execute(new HibernateCallback<User>() {
			private User user=null;
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where user_name=:user_name";
				Query query = session.createQuery(hql);
				query.setParameter("user_name", user_name);
				 user = (User) query.uniqueResult();
				return user;
			}
		});
	}

}
