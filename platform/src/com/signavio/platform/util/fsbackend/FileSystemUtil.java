/*******************************************************************************
 * Signavio Core Components
 * Copyright (C) 2012  Signavio GmbH
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.signavio.platform.util.fsbackend;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.signavio.warehouse.business.BPMN20XMLFileUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.research.ws.wadl.Response;

public class FileSystemUtil {
	
	public static String getCleanFileName(String rawName) {
		return rawName.replaceAll("/|\\\\|:|\\*|\\?|\\\"|<|>|\\||;|$|%|&", "");
	}
	
	public static boolean isFileExistent(String path) {
		synchronized (path.intern()) {
			File file = new File(path);
			return file.exists();
		}
	}
	
	public static boolean isFileAccessible(String path) {
		synchronized (path.intern()) {
			File file = new File(path);
			return file.canRead() && file.canWrite();
		}
	}
	
	public static boolean isFileDirectory(String path) {
		synchronized (path.intern()) {
			File file = new File(path);
			return file.isDirectory();
		}
	}
	
//	public static File createFile(String path) {
//		synchronized (path.intern()) {
//			File f = new File(path);
//			try {
//				if (f.exists()){
//					return null;
//				} if (f.createNewFile()) {
//					return f;
//				} else {
//					return null;
//				}
//			} catch (IOException e) {
//				return null;
//			}
//		}
//	}
	
	public static File createDirectory(String path){
		synchronized (path.intern()) {
			File f = new File(path);
			if (f.mkdir()) {
				return f;
			} else {
				return null;
			}	
		}
	}
	
	public static boolean renameFile(String path, String newPath) {
		synchronized (path.intern()) {
			File newFile = new File (newPath);
			if (newFile.exists()) {
				return false;
			}
			File oldFile = new File(path);
			return oldFile.renameTo(newFile);
		}
	}

	public static File[] getFileChildren(String path, FilenameFilter filter) {
		synchronized (path.intern()) {
			File file = new File(path);
			if (filter == null) {
				return file.listFiles();
			} else {
				return file.listFiles(filter);
			}
		}
	}
	
	public static void deleteFileOrDirectory(String path) {
		synchronized (path.intern()) {
			File f = new File (path) ;
			deleteFileOrDirectory(f);
		}
	}
	
	private static void deleteFileOrDirectory(File f) {
		if (f.isDirectory()) {
			for (File child : f.listFiles()) {
				deleteFileOrDirectory(child);
			}
		}
		f.delete();
	}

	public static class WriteOperation {
		public String nodeName, attributeName, stringValue;
		public boolean asCData;
		public WriteOperation(String nodeName, String attributeName, String stringValue, boolean asCData) {
			this.nodeName = nodeName;
			this.attributeName = attributeName;
			this.stringValue = stringValue;
			this.asCData = asCData;
		}
	}
	
	public static void saveXml(String path, String xmlString, String axelorPath, String sessionId, Boolean bpmn) {
		WebResource resource = Client.create().resource(axelorPath+"/"+path);
		try {
			JSONObject ji = new JSONObject();
			JSONObject data = new JSONObject();
			String version = getXml(path, axelorPath, sessionId, true);
			if(version == null) version = "1";
			data.put("version", new Integer(version));
			if(bpmn)data.put("bpmn", xmlString);
			else data.put("xmlData", xmlString);
			data.put("id", path);
			ji.put("data", data);
			resource.accept( MediaType.APPLICATION_JSON )
			        .type( MediaType.APPLICATION_JSON )
			        .entity(ji.toString())
			        .cookie(new Cookie("JSESSIONID", sessionId))
			        .post( ClientResponse.class );
			if(bpmn){
				resource = Client.create().resource(axelorPath.split("/ws")[0]+"/ws/action");
				ji = new JSONObject();
				ji.put("model", "com.axelor.wkf.db.Workflow");
				ji.put("action", "wkf-method-import-workflow");
				data = new JSONObject();
				JSONObject context = new JSONObject();
				context.put("_model", "com.axelor.wkf.db.Workflow");
				context.put("bpmn",xmlString);
				data.put("context", context);
				ji.put("data", data);
				ClientResponse rep = resource.accept( MediaType.APPLICATION_JSON )
		        .type( MediaType.APPLICATION_JSON )
		        .entity(ji.toString())
		        .cookie(new Cookie("JSESSIONID", sessionId))
		        .post( ClientResponse.class );
			}
				
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static File createFile(String path, String xmlString, String axelorPath, String sessionId) {
		synchronized (path.intern()) {
			File f = new File(path);
			saveXml(path,xmlString, axelorPath, sessionId, false);
			return f;
		}
	}
	
	public static String getXml(String path, String axelorPath, String sessionId, Boolean version) {
		if(axelorPath == null)
			return null;
		WebResource resource = Client.create()
		        .resource(axelorPath+"/"+path);
		ClientResponse response = resource.accept( MediaType.APPLICATION_JSON )
		        .type( MediaType.APPLICATION_JSON )
		        .cookie(new Cookie("JSESSIONID", sessionId))
		        .get( ClientResponse.class );
		String res = response.getEntity(String.class);
		if(res != null && res != "" && !res.isEmpty()){
			try {
				JSONObject jo = new JSONObject(res);
				JSONArray data = jo.getJSONArray("data");
				Object xmlData = null;
				if(data != null){
					if(version) return ((JSONObject) data.get(0)).get("version").toString();
					xmlData = ((JSONObject) data.get(0)).get("xmlData");
				}
				if(JSONObject.NULL != xmlData){
					return (String) xmlData;
				}
				return null;
			} catch (JSONException e) {
				e.printStackTrace();
			}	
		}
			
		return null;
	}
	
	public static String readXmlNodeChildFromFile(String xPath, String path, NamespaceContext nsContext, String axelorPath, String sessionId) {
		synchronized (path.intern()) {
			String xmlString = getXml(path, axelorPath, sessionId, false);
			if(xmlString == null)
				return "";
			ByteArrayInputStream bi = new ByteArrayInputStream(xmlString.getBytes());
			DocumentBuilderFactory xmlFact = DocumentBuilderFactory.newInstance();
			xmlFact.setNamespaceAware(nsContext != null);
			try {
				DocumentBuilder builder = xmlFact.newDocumentBuilder();
				Document doc = builder.parse(bi);
				XPath xpath = XPathFactory.newInstance().newXPath();
				if (nsContext != null) {
					xpath.setNamespaceContext(nsContext);
				}
				String s = xpath.evaluate(xPath, doc);
				return s.trim();
			} catch (XPathExpressionException e) {
				return "";
			} catch (FileNotFoundException e) {
				return "";
			} catch (ParserConfigurationException e) {
				return "";
			} catch (SAXException e) {
				return "";
			} catch (IOException e) {
				return "";
			}
		}
	}
	
	public static boolean writeXmlNodeChildToFile(String nodeName, String stringValue, boolean asCData, String fileName) {
		return writeXmlNodeChildToFile(new WriteOperation[] { new WriteOperation(nodeName, null, stringValue, asCData )} , fileName );
	}
	
	public static boolean writeXmlNodeAttributeToFile(String nodeName, String attributeName, String stringValue, String fileName) {
		return writeXmlNodeChildToFile(new WriteOperation[] { new WriteOperation(nodeName, attributeName, stringValue, false )} , fileName );
	}
	
	private static boolean writeXmlNodeChildToFile(WriteOperation[] operations, String path) {
		synchronized (path.intern()) {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			try {
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				File file = new File(path);
				Document doc = docBuilder.parse(file);
				for (WriteOperation operation : operations) {
					String nodeName = operation.nodeName;
					boolean handleAttribute = operation.attributeName != null;
					
					if (nodeName.contains(":")) {
						nodeName = nodeName.substring(nodeName.lastIndexOf(':')+1);
					}
					NodeList nodelist = doc.getElementsByTagName(nodeName);
					if (nodelist.getLength() != 1) {
						return false;
					}
					Node node = nodelist.item(0);
					
					
					if (handleAttribute) {
						NamedNodeMap attributes = node.getAttributes();
						Attr newAttr = doc.createAttribute(operation.attributeName);
						newAttr.setNodeValue(operation.stringValue);
						attributes.setNamedItem(newAttr);
					} else {
						NodeList children = node.getChildNodes();
						for (int j = children.getLength() - 1; j >= 0; j--) {
							node.removeChild(children.item(j));
						}
						if (operation.asCData) {
							if (node.appendChild(doc.createCDATASection(operation.stringValue)) == null) {
								return false;
							}
						} else {
							if (node.appendChild(doc.createTextNode(operation.stringValue)) == null) {
								return false;
							}
						}
					}
				}
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	
				StreamResult result = new StreamResult(new FileWriter(new File(path)));
				
				File f = new File(path);
				if (!f.exists() || !f.canRead() || !f.canWrite()) {
					return false;
				}
				
				DOMSource source = new DOMSource(doc);
				transformer.transform(source, result);
				
				result.getWriter().close();
				
				return true;
	
			} catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			} catch (SAXException e) {
				return false;
			} catch (TransformerConfigurationException e) {
				return false;
			} catch (TransformerFactoryConfigurationError e) {
				return false;
			} catch (TransformerException e) {
				return false;
			} catch (ParserConfigurationException e) {
				return false;
			}
		}
	}

}
