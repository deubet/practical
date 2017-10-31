package io.practical.p0008;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomValidator extends XmlValidator {

	public DomValidator(String fileName) {
		super(fileName);
	}

	@Override
	public void validate() {
		DocumentBuilderFactory domParserFactory = DocumentBuilderFactory.newInstance();
		domParserFactory.setValidating(false);
		domParserFactory.setNamespaceAware(true);

		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		DocumentBuilder dBuilder;
		try {
			domParserFactory.setSchema(schemaFactory
					.newSchema(new Source[] { new StreamSource(getXmlXsd()), new StreamSource(getAkoXsd()) }));
			dBuilder = domParserFactory.newDocumentBuilder();
			dBuilder.parse(new InputSource(getFileName()));
		} catch (SAXException | ParserConfigurationException | IOException se) {
			se.printStackTrace();
		}

	}

}
