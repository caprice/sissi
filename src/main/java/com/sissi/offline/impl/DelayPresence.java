package com.sissi.offline.impl;

import java.util.Map;

import com.sissi.protocol.Element;
import com.sissi.protocol.offline.Delay;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.PresenceType;

/**
 * @author kim 2013-11-15
 */
public class DelayPresence extends DelayProtocol {

	public DelayPresence() {
		super(Presence.class);
	}

	@Override
	public Map<String, Object> write(Element element) {
		return super.based(element);
	}

	@Override
	public Element read(Map<String, Object> element) {
		Presence presence = (Presence) super.based(element, new Presence());
		return presence.setDelay(new Delay(super.getOffline(), presence.getFrom(), element.get(super.delay).toString()));
	}

	public Boolean isSupport(Element element) {
		return super.isSupport(element) && this.isAcceptStatus(element);
	}

	private boolean isAcceptStatus(Element element) {
		PresenceType type = PresenceType.parse(element.getType());
		return type != PresenceType.AVAILABLE && type != PresenceType.UNAVAILABLE;
	}
}
