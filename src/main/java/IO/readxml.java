package IO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class readxml {
	public static void main(String[] args){
		DOMParser parser = new DOMParser();
		Document document = parser.parse("test.xml");
		Element rootElement = document.getDocumentElement();
		NodeList nodes = rootElement.getChildNodes();
		for(int i=0;i<nodes.getLength();i++){
			Node node = nodes.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element child = (Element)node;
			}
		}
		NodeList nodelist = rootElement.getElementsByTagName("book");
		if(nodelist!=null){
			for(int i=0;i<nodelist.getLength();i++){
				Element element = (Element)nodelist.item(i);
				String id = element.getAttribute("id");
				System.out.println(id);
			}
		}
	}
}

class DOMParser{
	public Document parse(String filePath){
		DocumentBuilderFactory  builderFactory = DocumentBuilderFactory.newInstance();
		Document document = null;
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			document = builder.parse(new File(filePath));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return document;
	}
	}
