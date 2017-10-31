package io.practical.p0008;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidatorValidator extends XmlValidator {

	public ValidatorValidator(String fileName) {
		super(fileName);
	}

	@Override
	public void validate() {
		
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			 Schema schema = schemaFactory.newSchema(new Source[] { new StreamSource(getXmlXsd()), new StreamSource(getAkoXsd()) });
			 Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(getFileName())));
			} catch (SAXException | IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			}
		
	}

}
