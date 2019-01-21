package com.web.actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.web.service.DownloadService;

public class DownloadAction extends ActionSupport {
private InputStream is;
private String fileName;
private DownloadService downloadService;


public String download() throws Exception {
	String download_url = ServletActionContext.getRequest().getParameter("download_url");
	System.out.println(download_url);
	String filename = downloadService.getfilename(download_url);
	System.out.println(filename);
	is = new FileInputStream("/usr/local/apache-tomcat-9.0.12/webapps"+download_url);
	System.out.println(download_url.substring(7));
	fileName = new String(filename.getBytes(),"ISO8859-1");
	return "success";
}








public void setDownloadService(DownloadService downloadService) {
	this.downloadService = downloadService;
}




public InputStream getIs() {
	return is;
}

public void setIs(InputStream is) {
	this.is = is;
}

public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}

}
