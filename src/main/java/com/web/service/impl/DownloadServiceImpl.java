package com.web.service.impl;

import java.util.List;

import com.web.dao.DownloadDao;
import com.web.service.DownloadService;


public class DownloadServiceImpl implements DownloadService {
private DownloadDao dd;
	@Override
	public String getCatalog(String filename) {
		String result = dd.getCatalog(filename);
		return  result;
	}
	public void setDd(DownloadDao dd) {
		this.dd = dd;
	}
	public String getfilename(String download_url) {
		String result = dd.getfilename(download_url);
		return result;
	}

}
