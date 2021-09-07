package com.mycompany.webapp.view;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class Ch12FileListView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(Ch12FileListView.class);
	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("View 실행");
		//이 메서드의 목표 : 파일의 총 수 및 파일의 이름 목록 얻기
		String fileDir =  "C:/hyndai_it&e/uploadfiles";
		File file = new File(fileDir);
		String[] fileList = file.list();
		int totalFileNum = fileList.length;
		// 응답 생성 및 보내기
		response.setContentType("application/json, charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		////data= {totalFileNum:10, fileList:["photo1.jpg", "photo2.jpg", ...] }
		//중괄호는 json obejct 대괄호는 json Array
		JSONObject jo = new JSONObject();
		jo.put("totalFileNum", totalFileNum);
		
		JSONArray jsonArray = new JSONArray();
		for(String fileName : fileList) {
			jsonArray.put(fileName);
		}
		jo.put("fileList", jsonArray);
//		jo.put("fileList", fileList); // 배열안에 값만 있다면 이렇게 표현가능
		String json =jo.toString();
		
		pw.println(json);
		pw.flush();
		pw.close();
	}

}
