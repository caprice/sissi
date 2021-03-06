package com.sissi.protocol.message;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.sissi.read.MappingMetadata;

/**
 * @author kim 2013-11-1
 */
@MappingMetadata(uri = Message.XMLNS, localName = Body.NAME)
@XmlRootElement
public class Body {

	public final static String NAME = "body";

	private final StringBuffer text = new StringBuffer();

	public Body() {
		super();
	}

	public Body(String text) {
		super();
		this.text.append(text);
	}

	@XmlValue
	public String getText() {
		return this.text.toString();
	}

	public Body setText(String text) {
		this.text.append(text);
		return this;
	}

	public Boolean hasContent() {
		return this.text.length() > 0;
	}
}
