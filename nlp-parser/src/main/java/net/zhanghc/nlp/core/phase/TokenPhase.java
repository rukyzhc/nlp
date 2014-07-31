package net.zhanghc.nlp.core.phase;

import java.util.Properties;

public abstract class TokenPhase extends AbstractPhase {

	@Override
	public Type getType() {
		return Type.TOKENIZE;
	}
	
	public static TokenPhase create(Properties conf) {
		return null;
	}

}
