package com.web.actions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.domain.Upload;
import com.web.service.UploadService;

public class UploadAction extends ActionSupport implements ModelDriven<Upload> {
	private Upload uploads = new Upload();
	private UploadService uploadService;
	private File[] upload;
	private String[] uploadFileName;

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public void upload() throws Exception {
		String sort = ServletActionContext.getRequest().getParameter("sort");
		String[] sorts = { "", "t_direction", "t_members","t_live","t_video","t_achieve" };
		int result = 100;
		for (int j = 1; j < sorts.length; j++)
			if (sorts[j].equals(sort)) {
				result = j;
			}
		;
		String path="/usr/local/apache-tomcat-9.0.12/webapps/webfile/"+sort;
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		JSONArray json = new JSONArray();
		for (int i = 0; i < upload.length; i++) {
			String text = uploads.getFileContent();
			Upload uploads = new Upload();
			upload[i].renameTo(new File(file, uploadFileName[i]));
			uploads.setFile_url("/webfile/" + sort + "/" + uploadFileName[i]);
			uploads.setFileContent(text);
			uploads.setFile_name(uploadFileName[i]);
			uploadService.savefile(uploads);
			System.out.println("+++++++++++++");
		}
		ServletActionContext.getResponse().getWriter().print(json);
		return;
	}



	@Override
	public Upload getModel() {
		return uploads;
	}

	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

}
