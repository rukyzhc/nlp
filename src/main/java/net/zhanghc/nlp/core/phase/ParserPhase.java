package net.zhanghc.nlp.core.phase;

import net.zhanghc.nlp.base.Sentence;

public class ParserPhase implements Phase {

	@Override
	public Type getPhase() {
		return Type.Parser;
	}

	@Override
	public void annotate(Sentence sentence) {
		// TODO Auto-generated method stub
		
	}

}
