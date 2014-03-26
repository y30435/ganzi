package com.ganzi.service;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
		
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList itemList = (NodeList) xPath.evaluate(expression, xmlDocument, XPathConstants.NODESET);
		
		if(itemList != null) {
			for(int $i=0; $i<itemList.getLength(); $i++) {
				NodeList itemChild = itemList.item($i).getChildNodes();
				
				strRslt += "<div id='item'>";
				for(int $j=0; $j<itemChild.getLength(); $j++) {
					strRslt += "<span id='element'>";
					strRslt += "<span id='el_name'>" + itemChild.item($j).getNodeName() + "</span>";
					strRslt += "<span id='el_text'>"+ itemChild.item($j).getTextContent() + "</span>";
					strRslt += "</span>";
				}
				strRslt += "</div>";
			}
		}
		
		return strRslt;
	}
}
