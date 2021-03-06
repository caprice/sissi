package com.sissi.context;

/**
 * @author kim 2013-10-30
 */
public interface JID {

	public String getUser();

	public String getDomain();

	public JID setDomain(String domain);

	public String getResource();

	public JID setResource(String resource);

	public JID getBare();

	public String asString();

	public String asStringWithBare();
}
