package net.zhanghc.nlp.core.phase;

import java.util.Properties;

import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.core.Processor;

public final class PhaseProcessor implements Processor {
	Phase head = null;
	Phase tail = null;

	public void appendPhase(Phase.Type type, Properties conf) throws PhaseException {
		switch(type) {
		case TOKENIZE:
			appendPhase(TokenPhase.create(conf));
			return;
		case SEG_POS:
			appendPhase(SegPOSPhase.create(conf));
			return;
		case LEMMA:
			appendPhase(LemmaPhase.create(conf));
			return;
		case PARSE:
			appendPhase(ParsePhase.create(conf));
			return;
		}
	}

	public void appendPhase(Phase phase) throws PhaseException {
		if(tail == null) {
			head = phase;
			tail = phase;
		} else {
			if(Phase.Type.legal(tail.getType(), phase.getType())) {
				tail.append(phase);
				tail = phase;
			} else {
				throw new PhaseException(String.format("Cannot append Phase %s after Phase %s", 
						phase.getType().toString(), tail.getType().toString()));
			}
		}
	}

	@Override
	public void process(Sentence sentence) {
		Phase current = head;
		while(current != null) {
			current.preprocess(sentence);
			current.annotate(sentence);
			
			current = current.nextPhase();
		}
	}

	@Override
	public void configure(Properties properties) {

	}

}
