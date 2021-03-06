package com.sissi.pipeline.in.iq;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;
import com.sissi.protocol.error.ServerError;
import com.sissi.protocol.error.detail.BadRequest;
import com.sissi.protocol.iq.IQ;

/**
 * @author kim 2014年1月14日
 */
public class IQCheckTypeProcessor implements Input {

	private final String ERROR_TEXT = "Please check type";

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		return IQ.class.cast(protocol).isValid() ? true : this.writeAndReturn(context, protocol);
	}

	private Boolean writeAndReturn(JIDContext context, Protocol protocol) {
		context.write(protocol.reply().setError(new ServerError().setType(ProtocolType.MODIFY).setBy(context.getDomain()).add(BadRequest.DETAIL, context.getLang(), ERROR_TEXT)));
		return false;
	}
}
