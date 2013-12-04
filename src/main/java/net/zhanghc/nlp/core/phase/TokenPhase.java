package net.zhanghc.nlp.core.phase;

import net.zhanghc.nlp.base.Sentence;

public class TokenPhase implements Phase {

	@Override
	public Type getPhase() {
		return Type.Token;
	}

	@Override
	public void annotate(Sentence sentence) {
		// TODO Auto-generated method stub
		
	}

}
