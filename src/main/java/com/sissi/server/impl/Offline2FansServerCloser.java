package com.sissi.server.impl;

import com.sissi.addressing.Addressing;
import com.sissi.broadcast.BroadcastProtocol;
import com.sissi.context.JIDContext;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.PresenceType;
import com.sissi.server.ServerCloser;

/**
 * @author kim 2013-11-20
 */
public class Offline2FansServerCloser implements ServerCloser {

	private final Integer IS_OFFLINE = 2;

	private final Addressing addressing;

	private final BroadcastProtocol protocolBraodcast;

	public Offline2FansServerCloser(Addressing addressing, BroadcastProtocol protocolBraodcast) {
		super();
		this.addressing = addressing;
		this.protocolBraodcast = protocolBraodcast;
	}

	@Override
	public Offline2FansServerCloser close(JIDContext context) {
		if (this.addressing.others(context.getJid()) < IS_OFFLINE) {
			this.protocolBraodcast.broadcast(context.getJid(), new Presence().setFrom(context.getJid().getBare()).setType(PresenceType.UNAVAILABLE));
		}
		return this;
	}
}
