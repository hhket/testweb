package com.web.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.web.dao.DownloadDao;
import com.web.domain.Upload;

public class DownloadDaoImpl extends HibernateDaoSupport implements DownloadDao {

	@Override
	public String getCatalog(String filename) {
		Upload resultU = getHibernateTemplate().execute(new HibernateCallback<Upload>() {

			@Override
			public Upload doInHibernate(Session session) throws HibernateException {
				String hql = "from Upload where file_name=:fn";
			return	(Upload) session.createQuery(hql).setParameter("fn", filename).uniqueResult();
			}
		});
		return resultU.getFile_url();
	}

	@Override
	public String getfilename(String download_url) {
		String result =null;
		List<Upload> list = getHibernateTemplate().execute(new HibernateCallback<List<Upload>>() {
			
			@Override
			public List<Upload> doInHibernate(Session session) throws HibernateException {
				String hql = "from Upload where file_url=:fu";
			return	(List<Upload>) session.createQuery(hql).setParameter("fu", download_url).list();
			}
		});
		for(Upload i :list) {
			 result = i.getFile_name();
		}
		return result;
	}

}
