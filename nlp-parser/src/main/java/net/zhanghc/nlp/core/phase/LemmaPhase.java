package net.zhanghc.nlp.core.phase;

import java.util.Properties;

public abstract class LemmaPhase extends AbstractPhase {

	@Override
	public Phase.Type getType() {
		return Type.LEMMA;
	}

	public static LemmaPhase create(Properties conf) {
		return null;
	}

}
