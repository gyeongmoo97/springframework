package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);

	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	} 
	@PostMapping("/fileupload")
    public String fileUpload(String title, String desc, MultipartFile attach) throws IOException {
        logger.info("실행");

        //문자 파트 내용 읽기
        logger.info("title : " + title);
        logger.info("desc : " + desc);

        //파일 파트 내용 읽기
        //클라이언트측에서 보낸 파일 이름, 
        logger.info("file original name : " + attach.getOriginalFilename());
        logger.info("file contentType : " + attach.getContentType());
        logger.info("file size : " + attach.getSize());

        //파일 파트 데이터를 서버의 파일로 저장
        //저장 이름과 originalname은 다르게 만들어주는 게 좋음
        String savedname = new Date().getTime() +"-"+attach.getOriginalFilename(); //현재시간을 붙임 
        File file = new File("C:/hyndai_it&e/uploadfiles/"+savedname);
        attach.transferTo(file);

        return "redirect:/ch09/content";
    }
	/*	@PostMapping("/fileupload")
		public String fileupload(String title, String desc, MultipartFile attach) throws Exception {
			logger.info("실행");
	
			// 문자 파트 내용 읽기
			
			logger.info("title:" + title);
			logger.info("desc:" + desc);
			logger.info("attach : "+ attach);
			// 파일 파트 내용 읽기
	  logger.info("file originalname: "+ attach.getOriginalFilename());
			logger.info("file contenttype: " + attach.getContentType());
			logger.info("file size: " + attach.getSize());
	
			// 파일 파트 데이터를 서버의 파일로 저장
			// 가능하면 저장이름과 orginal name은 다르게 설정하는게 좋다.
			// 아래처럼 시간을 등록하면 절대 중복될수가 없다.
			String savedname = new Date().getTime() + "-" + attach.getOriginalFilename();
			File file = new File("C:/hyundai_it&e/upload_files/" + savedname);
			attach.transferTo(file);
	
			return "redirect:/ch09/content";
		}*/

	@PostMapping(value = "/fileuploadAjax", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String fileuploadAjax(String title, String desc, MultipartFile attach) throws Exception {
		logger.info("실행");

		// 문자 파트 내용 읽기
		logger.info("title:" + title);
		logger.info("desc:" + desc);

		// 파일 파트 내용 읽기
		logger.info("file originalname: " + attach.getOriginalFilename());
		logger.info("file contenttype: " + attach.getContentType());
		logger.info("file size: " + attach.getSize());

		// 파일 파트 데이터를 서버의 파일로 저장
		// 가능하면 저장이름과 orginal name은 다르게 설정하는게 좋다.
		// 아래처럼 시간을 등록하면 절대 중복될수가 없다.
		String savedname = new Date().getTime() + "-" + attach.getOriginalFilename();
		File file = new File("C:/hyndai_it&e/uploadfiles/" + savedname);
		attach.transferTo(file);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("savedname", savedname);
		String json = jsonObject.toString();
		return json;
	}

//   @GetMapping(value="/filedownload", produces="image/jpeg")
//   @ResponseBody
//   public byte[] filedownload(String savedname) throws Exception {
//	   String filePath = "C:/hyndai_it&e/uploadfiles/"+savedname;
//	   //특정경로에 있는 파일을 읽어서
//	   InputStream is = new FileInputStream(filePath);
//	   //inputStream에 넣어주고
//	   byte[] data= IOUtils.toByteArray(is);
//	   //바이트 배열로 만들어서
//	   return data;
//	   //리스폰스 바디에 넣는다.
//   }
//}

//위의파일에서 개선할점, 1. 파일형식고정하면 안됨 2. 바이트배열을 만드는것 비효율적
//db에 content  타입을 저장한다, 실제로는 savedname 이 아니라 db의 키값을 통해서 받을거다

	@GetMapping(value = "/filedownload")
	@ResponseBody
	//매개변수로 헤더 값 받기도 가능
	public void filedownload(
			int fileNo , 
			HttpServletResponse response,
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		//아래 값은 fileNo를 이용하여 db 에서 불러온 것으로 간주
		String contenttype = "image/jpeg";
		String origianfileename = "photo14.jpg";
		String savedName = "photo14.jpg";
		
		//응답 바디의 데이터의 형식 설정
		response.setContentType(contenttype);
		if (userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			logger.info("client browser : IE11이하");
			origianfileename=URLEncoder.encode(origianfileename,"UTF-8");
		} else {
			//크롬 브라우저에서 한글 파일명을 변환
			logger.info("client browser : 크롬 엣지 사파리");

			origianfileename = new String(origianfileename.getBytes("UTF-8"), "ISO-8859-1");
			
		}
//		브라우저 별 한글파일명 변환
		
	
		
		
		//파일을 첨부로 다운로드 하게 설정 -> 이 설정을 하면 파일을 보여주는게 아닌 바로 다운로드함
		//응답헤더에 값을 추가한다. 아래의 내용은 그냥 외우거나 보관해서 복붙해야할듯
		response.setHeader("Content-Disposition", "attachment; filename=\""+origianfileename+ "\"");
		
		//파일로부터 데이터를 읽는 입력스트림 생성
		String filePath = "C:/hyndai_it&e/uploadfiles/" + savedName;
		InputStream is = new FileInputStream(filePath);
		// 
		//응답 바디에 출력하는 출력스트림 얻기
		OutputStream os = response.getOutputStream();
		
		//입력스트림 -> 출력스트림
		//파일이 커도 상관이 없음 파일이 1GB짜리 파일을 읽는데 1GB는 필요없다. 1MB 로 1024번 옮기는 거랑 비슷한 방식으로 옮김
		FileCopyUtils.copy(is, os);
		is.close();
		os.flush();
		os.close();
		// inputStream에 넣어주고

	}
}

/*package com.mycompany.webapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);	
	
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	
	   @PostMapping("/fileupload")
	   public String fileupload(String title, String desc, MultipartFile attach) throws Exception {
	      logger.info("실행");
	      
	      //문자 파트 내용 읽기
	      logger.info("title:"+title);
	      logger.info("desc:"+desc);
	       
	      //파일 파트 내용 읽기
	      logger.info("file originalname: "+ attach.getOriginalFilename());
	      logger.info("file contenttype: "+attach.getContentType());
	      logger.info("file size: "+attach.getSize());
	      
	      //파일 파트 데이터를 서버의 파일로 저장
	      //가능하면 저장이름과 orginal name은 다르게 설정하는게 좋다.
	      //아래처럼 시간을 등록하면 절대 중복될수가 없다.
	      String savedname = new Date().getTime() +"-"+ attach.getOriginalFilename();
	      File file = new File("C:/hyundai_it&e/upload_files/"+savedname);
	      attach.transferTo(file);
	      
	      return "redirect:/ch09/content";
	   }
	   

//	@PostMapping("/fileupload")
//	public String fileupload(String title, String desc, MultipartFile attach) throws IllegalStateException, IOException {
//		logger.info("실행");
//		
//		logger.info("title : "+ title);
//		logger.info("desc : "+ desc);
////		logger.info("title : "+ title);
//		
//		//파일 파트 내용 읽기
////		logger.info("file originalname:" + attach.getOriginalFilename());
//		logger.info("file Size:" + attach.getSize());
//		logger.info("filegetContentType:" + attach.getContentType());
//		
//		//파일 파트 데이터를 서버의 파일로 저장
//		String savedname = new Date().getTime() + "-"+attach.getOriginalFilename();
//		File file = new File("C:/hyndai_it&e/uploadfiles/"+savedname);
//		attach.transferTo(file);
//		
//		return "redirect:/ch09/content";
//	}
//	
	
	@PostMapping(value="/fileuploadAjax", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String fileuploadAjax(String title, String desc, MultipartFile attach) throws IllegalStateException, IOException {
		logger.info("실행");
		
		logger.info("title : "+ title);
		logger.info("desc : "+ desc);
//		logger.info("title : "+ title);
		
		//파일 파트 내용 읽기
//		logger.info("file originalname:" + attach.getOriginalFilename());
		logger.info("file Size:" + attach.getSize());
		logger.info("filegetContentType:" + attach.getContentType());
		
		//파일 파트 데이터를 서버의 파일로 저장
		String savedname = new Date().getTime() + "-"+attach.getOriginalFilename();
		File file = new File("C:/hyndai_it&e/uploadfiles/"+savedname);
		attach.transferTo(file);
		
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		jo.put("savedname", savedname);
		String json = jo.toString();
		
		
		return json;
	}
}
*/