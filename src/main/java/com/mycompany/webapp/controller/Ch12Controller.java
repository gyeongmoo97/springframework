package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.view.Ch12FileListView;

@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch12Controller.class);

	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "/ch12/content";
	}
	
//	@GetMapping("/fileList")
//	public void fileList(HttpServletResponse response) throws IOException {
//		logger.info("실행");
//		//이 메서드의 목표 : 파일의 총 수 및 파일의 이름 목록 얻기
//		String fileDir =  "C:/hyndai_it&e/uploadfiles";
//		File file = new File(fileDir);
//		String[] fileList = file.list();
//		int totalFileNum = fileList.length;
//		// 응답 생성 및 보내기
//		response.setContentType("application/json, charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		
//		////data= {totalFileNum:10, fileList:["photo1.jpg", "photo2.jpg", ...] }
//		//중괄호는 json obejct 대괄호는 json Array
//		JSONObject jo = new JSONObject();
//		jo.put("totalFileNum", totalFileNum);
//		
//		JSONArray jsonArray = new JSONArray();
//		for(String fileName : fileList) {
//			jsonArray.put(fileName);
//		}
//		jo.put("fileList", jsonArray);
////		jo.put("fileList", fileList); // 배열안에 값만 있다면 이렇게 표현가능
//		String json =jo.toString();
//		
//		pw.println(json);
//		pw.flush();
//		pw.close();
//	}
	@GetMapping("/fileList")
	public String fileList() throws IOException {
		logger.info("실행");
		return "ch12FileListView";
	}

//	@GetMapping("/fileDownload")
//	public void fileDownload(
//			String fileName, 
//			HttpServletResponse response, HttpServletRequest requset,
//			@RequestHeader("User-Agent") String userAgent) throws Exception {
//		logger.info("실행");
//
//		
//		//fileNo를 이용해서 DB에서 파일 정보를 가져오기
////		String contentType = "image/jpeg"; MIME타입을 얻어오는 방법이 있다.
//		String contentType = requset.getServletContext().getMimeType(fileName);
//		String origianFilename = fileName;
//		String savedName = fileName;
//		
//		//응답 바디의 데이터의 형식 설정
//		response.setContentType(contentType);
//		
//		//브라우저별로 한글 파일명을 변환
//		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
//			//IE일 경우
//			origianFilename = URLEncoder.encode(origianFilename, "UTF-8");
//		} else {
//			//크롬, 엣지, 사라피일 경우
//			origianFilename = new String(origianFilename.getBytes("UTF-8"), "ISO-8859-1");
//		}
//		
//		//파일을 첨부로 다운로드하도록 설정
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + origianFilename + "\"");
//		
//		//파일로부터 데이터를 읽는 입력스트림 생성		
//		String filePath = "C:/hyndai_it&e/uploadfiles/" + savedName;
//		InputStream is = new FileInputStream(filePath);
//		
//		//응답 바디에 출력하는 출력스트림 얻기
//		OutputStream os = response.getOutputStream();
//		
//		//입력스트림 -> 출력스트림
//		FileCopyUtils.copy(is, os);
//		is.close();
//		os.flush();
//		os.close();
//	}
	
	@GetMapping("/fileDownload")
	public String fileDownload(
			@ModelAttribute("fileName") String fileName,HttpServletRequest request, 

			@ModelAttribute("userAgent")@RequestHeader("User-Agent") String userAgent) throws Exception {
		logger.info("실행");
		 String contentType = request.getServletContext().getMimeType(fileName);
	      String savedName = fileName;
	      String originalFilename = fileName;

		return "ch12FileDownloadView";
	}
	
}
