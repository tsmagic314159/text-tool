package cn.KJ.Assignment1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;

import java.net.URL;



public class JsonResourceUtils {     
	private static Logger logger = Logger.getLogger(JsonResourceUtils.class);     
	private JsonResourceUtils() {     }
	
	
	public static JSONObject getJsonObjFromResource(String filename) {
	JSONObject json = null;
	if (!filename.contains(".json")) {
		filename += ".json";
		}
	try {             
		URL url = JsonResourceUtils.class.getResource(filename);
		String path = url.getPath();
		System.out.println(path);
		File file = new File(path);
		System.out.println(file.toString());
		if (file.exists()) {
			String content = FileUtils.readFileToString(file, "UTF-8");
			json = JSON.parseObject(content);
			}
		else {
			logger.info("file not exist!");
			}
		}
	catch (Exception e) {
		e.printStackTrace();
		logger.info("readFileToString" + e.getMessage());
		}
	return json;
	}
}

