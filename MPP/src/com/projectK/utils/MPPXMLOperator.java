package com.projectK.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class MPPXMLOperator {

	/***
	 * 解析str为xml结构
	 * @param s
	 * @return
	 */
	public static Element parseXML(String s) 
	{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Element root = null;
		try {
			db = factory.newDocumentBuilder();
			StringReader sr = new StringReader(s);
			InputSource is = new InputSource(sr);
			Document xmldoc = db.parse(is);

			root = xmldoc.getDocumentElement();
			
			} catch (ParserConfigurationException e) {
				System.out.println("ParserConfigurationException:"+e.getMessage());
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return root;
	}
	
	/***
	 * 查找节点，并返回第一个符合条件节点
	 * @param express
	 * @param source
	 * @return
	 */
    public static Node selectSingleNode(String express, Object source) {
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /***
     * 查找节点，返回符合条件的节点集。
     * @param express
     * @param source
     * @return
     */
    public static NodeList selectNodes(String express, Object source) {
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }        
        return result;
    }
    
    /** 
    * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。 
    * @param node DOM Node 对象。 
    * @return a XML String from node 
    */ 
	public static String toString(Node node) {
		if (node == null) {
			throw new IllegalArgumentException();
		}
		Transformer transformer = newTransformer();
		if (transformer != null) {
			try {
				StringWriter sw = new StringWriter();
				transformer
						.transform(new DOMSource(node), new StreamResult(sw));
				return sw.toString();
			} catch (TransformerException te) {
				throw new RuntimeException(te.getMessage());

			}

		}
		return "";
	}

	/**
	 * 获取一个Transformer对象，由于使用时都做相同的初始化，所以提取出来作为公共方法。
	 * 
	 * @return a Transformer encoding UTF-8
	 */
	public static Transformer newTransformer() {
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			Properties properties = transformer.getOutputProperties();
			properties.setProperty(OutputKeys.ENCODING, "UTF-8");
			properties.setProperty(OutputKeys.METHOD, "xml");
			properties.setProperty(OutputKeys.VERSION, "1.0");
			properties.setProperty(OutputKeys.INDENT, "no");
			transformer.setOutputProperties(properties);
			return transformer;
		} catch (TransformerConfigurationException tce) {
			throw new RuntimeException(tce.getMessage());
		}
	}
}
