package net.zhanghc.nlp.core.phase;

import java.util.Properties;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.ChineseSegmenterAnnotator;

import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.core.Processor;

public class PhaseProcessor implements Processor {

	public void addPhase(Phase phase) {

	}

	@Override
	public void process(Sentence sentence) {
		ChineseSegmenterAnnotator annotator = new ChineseSegmenterAnnotator();
		Annotation annotation = new Annotation(sentence.toString());
		annotator.doOneSentence(annotation);
	}

	@Override
	public void configure(Properties properties) {
		
	}

}
