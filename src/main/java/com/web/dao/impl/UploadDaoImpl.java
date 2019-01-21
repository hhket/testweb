package com.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.UploadDao;
import com.web.domain.Upload;


public class UploadDaoImpl extends HibernateDaoSupport implements UploadDao {

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void savefile(Upload uploads) {
		getHibernateTemplate().save(uploads);
	}


}
