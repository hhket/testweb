package com.web.service.impl;

import java.util.List;

import com.web.dao.UploadDao;
import com.web.domain.Upload;
import com.web.service.UploadService;
import com.web.domain.Upload;
public class UploadServiceImpl implements UploadService {
private UploadDao ud;
	public void savefile(Upload uploads) {
		ud.savefile(uploads);
	}
	public void setUd(UploadDao ud) {
		this.ud = ud;
	}




}
