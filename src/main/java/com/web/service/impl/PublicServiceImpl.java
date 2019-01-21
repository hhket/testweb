package com.web.service.impl;

import java.util.List;

import com.web.dao.PublicDao;
import com.web.domain.Upload;
import com.web.service.PublicService;

public class PublicServiceImpl implements PublicService {
private PublicDao pd;
	@Override
	public List<Upload> sendfileMessage() {
		return (List<Upload>)pd.sendfileMessage();		
	}
	public void setPd(PublicDao pd) {
		this.pd = pd;
	}

}
