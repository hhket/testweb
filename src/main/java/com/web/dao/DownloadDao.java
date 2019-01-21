package com.web.dao;

import java.util.List;


public interface DownloadDao {

	String getCatalog(String filename);

	String getfilename(String download_url);


}
