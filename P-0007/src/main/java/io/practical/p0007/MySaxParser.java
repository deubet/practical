package io.practical.p0007;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MySaxParser extends MyXmlParser {

	public MySaxParser(String fileName) {
		super(fileName);
	}

	@Override
	public void parse() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try {
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        MySaxHandler handler = new MySaxHandler();
	        saxParser.parse(new File(getClass().getClassLoader().getResource(fileName).getFile()), handler);
	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
		
	}

}
