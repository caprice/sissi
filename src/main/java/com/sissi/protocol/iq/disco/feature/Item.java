package com.sissi.protocol.iq.disco.feature;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sissi.protocol.iq.disco.DiscoItems;
import com.sissi.protocol.iq.disco.DiscoFeature;

/**
 * @author kim 2013年12月18日
 */
@XmlType(namespace = DiscoItems.XMLNS)
@XmlRootElement(name = Item.NAME)
public class Item extends DiscoFeature {

	public final static String NAME = "item";

	private String jid;

	private String name;

	public Item() {
		super(null);
	}

	public Item(String jid, String name) {
		this();
		this.jid = jid;
		this.name = name;
	}

	@XmlAttribute
	public String getJid() {
		return jid;
	}

	public Item setJid(String jid) {
		this.jid = jid;
		return this;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}
}
