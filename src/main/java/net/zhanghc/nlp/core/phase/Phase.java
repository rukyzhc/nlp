package net.zhanghc.nlp.core.phase;

import java.util.Properties;

import net.zhanghc.nlp.base.Sentence;

public interface Phase {

	public Type getType();

	public void initial(Properties conf);

	public void preprocess(Sentence sentence);

	public void annotate(Sentence sentence);

	public void append(Phase phase);

	public Phase nextPhase();

	public static enum Type {
		TOKENIZE,
		SEG_POS,
		LEMMA,
		PARSE;

		public int order() {
			switch(this) {
			case TOKENIZE:
				return 1;
			case SEG_POS:
				return 3;
			case LEMMA:
				return 5;
			case PARSE:
				return 7;
			default:
				return 0;
			}
		}
		
		public static boolean legal(Type before, Type after) {
			return before.order() < after.order();
		}
	}

}
