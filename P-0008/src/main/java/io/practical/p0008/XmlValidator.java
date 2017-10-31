package io.practical.p0008;

/**
 * @author ofabbri
 *
 */
public abstract class XmlValidator {
	
	protected String xmlXsd = "xsd/xml.xsd";
	
	protected String akoXsd = "xsd/akomantoso30.xsd";
	
	protected String fileName;

	
	
	public String getXmlXsd() {
		return getClass().getClassLoader().getResource(xmlXsd).getFile();
	}

	public void setXmlXsd(String xmlXsd) {
		this.xmlXsd = xmlXsd;
	}

	public String getAkoXsd() {
		return getClass().getClassLoader().getResource(akoXsd).getFile();
	}

	public void setAkoXsd(String akoXsd) {
		this.akoXsd = akoXsd;
	}

	public String getFileName() {
		return getClass().getClassLoader().getResource(fileName).getFile();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public XmlValidator(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public abstract void validate();

}
