package io.practical.p0008;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class SaxValidator extends XmlValidator {

	public SaxValidator(String fileName) {
		super(fileName);
	}

	@Override
	public void validate() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setValidating(false);
		saxParserFactory.setNamespaceAware(true);

		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		SAXParser parser = null;
		try {
			saxParserFactory.setSchema(schemaFactory
					.newSchema(new Source[] { new StreamSource(getXmlXsd()), new StreamSource(getAkoXsd()) }));
			parser = saxParserFactory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ErrorHandler() {
				public void warning(SAXParseException e) throws SAXException {
					System.out.println("WARNING: " + e.getMessage()); // do nothing
				}

				public void error(SAXParseException e) throws SAXException {
					System.out.println("ERROR : " + e.getMessage());
					throw e;
				}

				public void fatalError(SAXParseException e) throws SAXException {
					System.out.println("FATAL : " + e.getMessage());
					throw e;
				}
			});
			reader.parse(new InputSource(getFileName()));
		} catch (SAXException | ParserConfigurationException | IOException se) {
			se.printStackTrace();
		}

	}

}
