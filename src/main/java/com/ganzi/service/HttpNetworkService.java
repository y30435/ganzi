package com.ganzi.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	public String strGetData(NaverRequest naverRequest) {
		  
        BufferedReader    oBufReader = null;
        HttpURLConnection httpConn   = null;
        String strBuffer = "";
        String strRslt   = "";
      
        try
        {
        	//TODO url 파라미터 이름을 정의 하는 좋은 방법 없을까?
            String strEncodeUrl = naverRequest.getRegUrl();
            strEncodeUrl += "?key=" + naverRequest.getRegKey();
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
}
