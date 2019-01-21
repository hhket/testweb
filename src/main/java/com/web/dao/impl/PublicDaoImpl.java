package com.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.web.dao.PublicDao;
import com.web.domain.Upload;


public class PublicDaoImpl extends HibernateDaoSupport implements PublicDao  {

	@Override
	public List<Upload> sendfileMessage() {
		DetachedCriteria dc = DetachedCriteria.forClass(Upload.class);
		return	(List<Upload>) getHibernateTemplate().findByCriteria(dc);
	}



}
