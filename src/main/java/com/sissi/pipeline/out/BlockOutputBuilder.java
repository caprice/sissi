package com.sissi.pipeline.out;

import java.util.HashSet;
import java.util.Set;

import com.sissi.context.JID;
import com.sissi.context.JIDBuilder;
import com.sissi.context.JIDContext;
import com.sissi.pipeline.Output;
import com.sissi.pipeline.OutputBuilder;
import com.sissi.protocol.Element;
import com.sissi.protocol.message.Message;
import com.sissi.protocol.presence.Presence;
import com.sissi.ucenter.BlockContext;

/**
 * @author kim 2013年12月9日
 */
abstract class BlockOutputBuilder implements OutputBuilder {

	private final Set<Class<? extends Element>> blockSupports = new HashSet<Class<? extends Element>>();

	private final BlockContext context;

	protected final JIDBuilder jidBuilder;

	public BlockOutputBuilder(BlockContext context, JIDBuilder jidBuilder) {
		super();
		this.context = context;
		this.jidBuilder = jidBuilder;
		this.blockSupports.add(Presence.class);
		this.blockSupports.add(Message.class);
	}

	abstract protected class BlockOutput implements Output {

		@Override
		public Boolean output(JIDContext context, Element node) {
			JID contacter = this.contacter(context, node);
			if (this.isEmpty(context.getJid(), contacter) || !BlockOutputBuilder.this.blockSupports.contains(node.getClass())) {
				return true;
			}
			return !BlockOutputBuilder.this.context.isBlock(this.user(context, node), contacter);
		}

		abstract protected JID user(JIDContext context, Element node);

		abstract protected JID contacter(JIDContext context, Element node);

		private Boolean isEmpty(JID jid) {
			return (jid == null || jid.getUser() == null);
		}

		private boolean isEmpty(JID user, JID contact) {
			return this.isEmpty(user) || this.isEmpty(contact);
		}

		@Override
		public Output close() {
			return this;
		}
	}
}
