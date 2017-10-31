package io.practical.p0007;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;


public class MyStaxParser extends MyXmlParser {

	public MyStaxParser(String fileName) {
		super(fileName);
	}

	@Override
	public void parse() {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventReader;
		try {
			eventReader = factory
					.createXMLEventReader(new FileReader(getClass().getClassLoader().getResource(fileName).getFile()));
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
			}
		} catch (FileNotFoundException | XMLStreamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
