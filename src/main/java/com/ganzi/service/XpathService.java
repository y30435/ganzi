package com.ganzi.service;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * XML 파싱을 위한 service 
 * - Xpath 사용
 * 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 */
public class XpathService {
	
	/**
	 * xml을 Document 객체로 파싱한후 Xpath를 이용하여 재처리
	 * 
	 * @author 개발지원 2팀 - 한주희 과장 
	 * @when   2014.3.25
	 */
	public String XpathParsing(String xml) throws Exception {
		
		Document xmlDocument = null;
		String strRslt = "";
         
        // XML Document 객체 생성
        InputSource is = new InputSource(new StringReader(xml));
        xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
 
        // 인터넷 상의 XML 문서는 요렇게 생성하면 편리함.
        //Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        //                               .parse("http://www.example.com/test.xml");
         
        //error가 있는지 체크
        strRslt = XpathParsingDetail("/error", xmlDocument);
        if("".equals(strRslt)) {
        	strRslt = XpathParsingDetail("//item", xmlDocument);
        }
        
        return strRslt;
    }
	
	
	/**
	 * Document 타입의 파싱 결과값을 Xpath를 이용하여 각 element에 
	 * 대한 정보를 view 페이지에 맞게 제처리함
	 * 
	 * @author 개발지원 2팀 - 한주희 과장 
	 * @when   2014.3.25
	 * 
	 */
	private static String XpathParsingDetail(String expression, Document xmlDocument) throws Exception {
		
		String strRslt = "";
        String contentsRslt = "";
		
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList itemList = (NodeList) xPath.evaluate(expression, xmlDocument, XPathConstants.NODESET);
		
		if(itemList != null) {
			for(int $i=0; $i<itemList.getLength(); $i++) {
				NodeList itemChild = itemList.item($i).getChildNodes();
				
				strRslt = setTag(strRslt, contentsRslt, itemChild);
			}
		}
		
		return strRslt;
	}


	private static String setTag(String strRslt, String contentsRslt, NodeList itemChild) {
		strRslt += "<div class='item'>";
		for(int $j=0; $j<itemChild.getLength(); $j++) {
		    String title = itemChild.item($j).getNodeName();
		    String contents = itemChild.item($j).getTextContent();
		    
		    contentsRslt = setContents(contentsRslt, title, contents);
		}
		strRslt += contentsRslt;
		strRslt += "</div>";
		return strRslt;
	}


    private static String setContents(String contentsRslt, String title, String contents) {
        contentsRslt += "<span class='element'>";
        contentsRslt += "<span class='el_name'>" + title + "</span>";
        
        if(title.equals("link"))
            contentsRslt += "<span class='el_text'><a href='"+ contents + "' target='_blank'>"+ contents + "</a></span>";
        else if(title.equals("thumbnail"))
            contentsRslt += "<span class='el_text'><image src='"+ contents + "'></span>";
        else
            contentsRslt += "<span class='el_text'>"+ contents + "</span>";
        
        contentsRslt += "</span>";
        return contentsRslt;
    }
}
