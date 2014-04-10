package com.ganzi.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.ganzi.model.DaumRequest;
import com.ganzi.model.NaverRequest;

/**
 * url HTTP 통신
 * - Xpath 사용
 * 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 */
public class HttpNetworkService {
	
	/**
	 * API에 접속하여 xml 결과를 return 하는 메소드
	 * 
	 * @author 개발지원 2팀 - 한주희 과장  
	 * @when   2014.3.25 
	 */
	public String strGetDataNaver(NaverRequest naverRequest) {
		  
        BufferedReader    oBufReader = null;
        HttpURLConnection httpConn   = null;
        String strBuffer = "";
        String strRslt   = "";
      
        try
        {
        	//TODO url 파라미터 이름을 정의 하는 좋은 방법 없을까?
            String strEncodeUrl = naverRequest.getRegUrl();
            strEncodeUrl += "?key=" + naverRequest.getKey();
            strEncodeUrl += "&target=" + naverRequest.getTarget();
            strEncodeUrl += "&query=" + naverRequest.getQuery();
            strEncodeUrl += "&display=" + naverRequest.getDisplay();
            strEncodeUrl += "&start=" + naverRequest.getStart();
            strEncodeUrl += "&sort=" + naverRequest.getSort();
            
            URL oOpenURL = new URL(strEncodeUrl);
          
            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
            httpConn.setRequestMethod("POST");          
            httpConn.connect();          
            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
  
            //Buffer에 있는 내용을 읽어 차례로 화면에 뿌려준다.
            while((strBuffer = oBufReader.readLine()) != null)
            {
                if(strBuffer.length() > 1)
                {
                    strRslt += strBuffer;
                }
            }
          
        } catch( Exception ee) {
          ee.getMessage();
        }
  
        return strRslt;
    }
	
	public String strGetDataDaum(DaumRequest daumRequest) {

        BufferedReader    oBufReader = null;
        HttpURLConnection httpConn   = null;
        String strBuffer = "";
        String strRslt   = "";
        
        
        try
        {
	        String strEncodeUrl = daumRequest.getRegUrl();
	        strEncodeUrl += daumRequest.getTarget();
	        
	        // daumRequest의 변수이름을 배열로 받아온다.
	        Field[] f = daumRequest.getClass().getDeclaredFields();
	        int index = 0;
	        for(Field temp : f){
	        	// 변수 갯수 만큼 for문을 돌면서 변수이름을 뽑아낸다.
	        	String fname = temp.getName();
	        	//변수이름이 regUrl 과 target이 아니면 strEncodeUrl에 추가해준다.
	        	if(!fname.equals("regUrl") && !fname.equals("target")){
	        		// get 메서드를 추출한다.
	            	Method m = daumRequest.getClass().getMethod("get"+fname.substring(0,1).toUpperCase()+temp.getName().substring(1, temp.getName().length()));
	            	// 위에서 추출한 메서드를 실행 한다. [ m.invoke(daumRequest) ]
	            	strEncodeUrl += (index++ == 0 ? "?" : "&") + fname + "=" + (fname.equals("q") ? URLEncoder.encode((String) m.invoke(daumRequest),"UTF-8") : m.invoke(daumRequest));
	        	}
	        	
	        }
	        System.out.println(strEncodeUrl);
	        URL oOpenURL = new URL(strEncodeUrl);
	          
            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
            httpConn.setRequestMethod("POST");          
            httpConn.connect();          
            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
  
            //Buffer에 있는 내용을 읽어 차례로 화면에 뿌려준다.
            while((strBuffer = oBufReader.readLine()) != null)
            {
                if(strBuffer.length() > 1)
                {
                    strRslt += strBuffer;
                }
            }
            System.out.println(strRslt);
            
        } catch(Exception ee) {
        	ee.getMessage();
        }
		return strRslt;
	}
}
