package com.sissi.pipeline.in.iq.block;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;
import com.sissi.protocol.iq.block.BlockList;
import com.sissi.protocol.iq.block.BlockListItem;
import com.sissi.ucenter.BlockContext;

/**
 * @author kim 2013年12月6日
 */
public class BlockedListProcessor extends ProxyProcessor {

	private final BlockContext blockContext;
	
	public BlockedListProcessor(BlockContext blockContext) {
		super();
		this.blockContext = blockContext;
	}

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		BlockList list = BlockList.class.cast(protocol);
		for (String each : this.blockContext.iBlockWho(context.getJid())) {
			list.add(new BlockListItem().setJid(super.build(each, null).asStringWithBare()));
		}
		context.write(list.getParent().setFrom(context.getDomain()).setTo(context.getJid()).setType(ProtocolType.RESULT));
		return true;
	}
}
