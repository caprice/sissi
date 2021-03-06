package com.sissi.context.impl;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;

import com.sissi.context.JID;
import com.sissi.context.JIDContext;
import com.sissi.context.Status;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-11-21
 */
public class JIDContexts extends ArrayList<JIDContext> implements JIDContext {

	private final static long serialVersionUID = 1L;

	private final RuntimeException notSupport = new RuntimeException("MultiContexts not support this funciton");

	public JIDContext setBinding(Boolean isBinding) {
		for (JIDContext each : this) {
			each.setBinding(isBinding);
		}
		return this;
	}

	public Boolean isBinding() {
		boolean isBinding = true;
		for (JIDContext each : this) {
			isBinding = each.isBinding() ? isBinding : false;
		}
		return isBinding;
	}

	@Override
	public JIDContext setPriority(Integer priority) {
		for (JIDContext each : this) {
			each.setPriority(priority);
		}
		return this;
	}

	public JIDContext setDomain(String domain) {
		for (JIDContext each : this) {
			each.setDomain(domain);
		}
		return this;
	}

	public JIDContext setLang(String lang) {
		for (JIDContext each : this) {
			each.setLang(lang);
		}
		return this;
	}

	@Override
	public JIDContext setJid(JID jid) {
		for (JIDContext each : this) {
			each.setJid(jid);
		}
		return this;
	}

	@Override
	public Boolean setTls() {
		boolean startTls = true;
		for (JIDContext each : this) {
			startTls = each.setTls() ? startTls : false;
		}
		return startTls;
	}

	public Boolean isTls() {
		boolean isTls = true;
		for (JIDContext each : this) {
			isTls = each.isTls() ? isTls : false;
		}
		return isTls;
	}

	@Override
	public JIDContext setAuth(Boolean canAccess) {
		for (JIDContext each : this) {
			each.setAuth(canAccess);
		}
		return this;
	}

	@Override
	public Boolean isAuth() {
		boolean isAuth = true;
		for (JIDContext each : this) {
			isAuth = each.isAuth() ? isAuth : false;
		}
		return isAuth;
	}

	public Boolean isAuthRetry() {
		boolean isAuthRetry = true;
		for (JIDContext each : this) {
			isAuthRetry = each.isAuthRetry() ? isAuthRetry : false;
		}
		return isAuthRetry;
	}

	@Override
	public Boolean close() {
		boolean allClose = true;
		for (JIDContext each : this) {
			allClose = each.close() ? allClose : true;
		}
		return allClose;
	}

	public Boolean closePrepare() {
		boolean allClose = true;
		for (JIDContext each : this) {
			allClose = each.closePrepare() ? allClose : true;
		}
		return allClose;
	}

	public Boolean closeTimeout() {
		boolean allClose = true;
		for (JIDContext each : this) {
			allClose = each.closeTimeout() ? allClose : true;
		}
		return allClose;
	}

	public JIDContext reset() {
		for (JIDContext each : this) {
			each.reset();
		}
		return this;
	}

	public JIDContext ping() {
		for (JIDContext each : this) {
			each.ping();
		}
		return this;
	}

	public JIDContext pong(Element node) {
		for (JIDContext each : this) {
			each.pong(node);
		}
		return this;
	}

	@Override
	public JIDContext write(Element node) {
		for (JIDContext each : this) {
			each.write(node);
		}
		return this;
	}

	public JIDContext write(Collection<Element> nodes) {
		for (Element node : nodes) {
			this.write(node);
		}
		return this;
	}

	public Long getIndex() {
		throw notSupport;
	}

	@Override
	public JID getJid() {
		throw notSupport;
	}

	public String getLang() {
		throw notSupport;
	}

	public String getDomain() {
		throw notSupport;
	}

	@Override
	public Status getStatus() {
		throw notSupport;
	}

	@Override
	public Integer getPriority() {
		throw notSupport;
	}

	public SocketAddress getAddress() {
		throw notSupport;
	}
}
