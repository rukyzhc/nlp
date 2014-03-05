package net.zhanghc.nlp.core.phase;

import java.util.Properties;

public abstract class ParsePhase extends AbstractPhase {

	@Override
	public Type getType() {
		return Type.PARSE;
	}
	
	public static ParsePhase create(Properties conf) {
		return null;
	}

}
