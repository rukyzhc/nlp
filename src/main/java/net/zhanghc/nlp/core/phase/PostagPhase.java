package net.zhanghc.nlp.core.phase;

import net.zhanghc.nlp.base.Sentence;

public class PostagPhase implements Phase {

	@Override
	public Type getPhase() {
		return Type.Postag;
	}

	@Override
	public void annotate(Sentence sentence) {
		// TODO Auto-generated method stub
		
	}

}
