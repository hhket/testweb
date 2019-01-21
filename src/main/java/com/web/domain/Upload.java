package com.web.domain;

import java.io.File;



public class Upload {
private  Integer upload_id;
private String fileContent;
private String file_url;
private String file_name;






public String getFile_name() {
	return file_name;
}
public void setFile_name(String file_name) {
	this.file_name = file_name;
}

public String getFile_url() {
	return file_url;
}
public void setFile_url(String file_url) {
	this.file_url = file_url;
}
public Integer getUpload_id() {
	return upload_id;
}
public void setUpload_id(Integer upload_id) {
	this.upload_id = upload_id;
}
public String getFileContent() {
	return fileContent;
}
public void setFileContent(String fileContent) {
	this.fileContent = fileContent;
}





}
