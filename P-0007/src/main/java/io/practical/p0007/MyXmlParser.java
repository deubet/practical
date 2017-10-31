package io.practical.p0007;

public abstract class MyXmlParser {
	
	protected String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
		
	public MyXmlParser(String fileName) {
		super();
		this.fileName = fileName;
	}

	public abstract void parse();

}
