package com.web.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.web.domain.Upload;
import com.web.service.PublicService;
import com.web.service.UploadService;

public class PublicAction extends ActionSupport {
	private PublicService publicService;
	public void sendfileMessage() throws Exception {
		List<Upload> list = publicService.sendfileMessage();
		JSONArray json = new JSONArray();
		for(Upload i :list) {
			JSONObject jso1 = new JSONObject();
			jso1.put("file_content", i.getFileContent());
			jso1.put("download_url", i.getFile_url());
			jso1.put("file_name", i.getFile_name());
			json.put(jso1);
		}
		ServletActionContext.getResponse().getWriter().println(json);
	}

	
	
	
	
	
	
	
	









	public void setPublicService(PublicService publicService) {
		this.publicService = publicService;
	}
	
	
}
