package net.zhanghc.nlp.core.phase;

import net.zhanghc.nlp.base.Sentence;

public interface Phase {
	
	public Type getPhase();
	
	public void annotate(Sentence sentence);
	
	public static enum Type {
		Token,
		Segmentation,
		Postag,
		Lemma,
		Parser,
	}

}
