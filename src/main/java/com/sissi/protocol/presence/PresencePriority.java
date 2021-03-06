package com.sissi.protocol.presence;

import javax.xml.bind.annotation.XmlRootElement;

import com.sissi.read.MappingMetadata;

/**
 * @author kim 2013年12月25日
 */
@MappingMetadata(uri = Presence.XMLNS, localName = PresencePriority.NAME)
@XmlRootElement
public class PresencePriority {
	
	public final static String NAME = "priority";
	
	private String text;

	public String getText() {
		return text;
	}

	public PresencePriority setText(String text) {
		this.text = text;
		return this;
	}
}
