package com.sissi.pipeline.in.iq.register;

import com.sissi.pipeline.in.iq.IQProcessor;
import com.sissi.ucenter.RegisterContext;
import com.sissi.ucenter.field.Fields;

/**
 * @author kim 2013年12月3日
 */
public class RegisterStoreSimpleProcessor extends RegisterStoreProcessor {

	public RegisterStoreSimpleProcessor(RegisterContext registerContext, IQProcessor iqProcessor) {
		super(registerContext, iqProcessor);
	}

	@Override
	protected Fields filter(Fields field) {
		return field;
	}
}
