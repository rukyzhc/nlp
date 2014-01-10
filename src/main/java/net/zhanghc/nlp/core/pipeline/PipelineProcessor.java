package net.zhanghc.nlp.core.pipeline;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.IndexAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;

import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.base.Word;
import net.zhanghc.nlp.core.Processor;

public final class PipelineProcessor implements Processor {
	private StanfordCoreNLP pipeline;
	
	private boolean stemStage;
	private boolean posStage;
	private boolean neStage;
	private boolean parseStage;

	@Override
	public void process(Sentence sentence) {
		Sentence.Builder builder = new Sentence.Builder(sentence);
		
		String plain = builder.getPlainText();
		if(plain.trim().length() == 0) {
			return;
		}

		Annotation annotation = new Annotation(plain);
		pipeline.annotate(annotation);

		List<CoreMap> sens = annotation.get(SentencesAnnotation.class);

		if(sens.size() > 1) {
//			logger.warn("There is more than 1 sentence in the string [" + source + "] and only the first sentence is processed.");
		} else if(sens.size() == 0) {
//			logger.error("There is no sentence in the string [" + source + "] .");
			return;
		}

		CoreMap sen = sens.get(0);

		for(CoreLabel token : sen.get(TokensAnnotation.class)) {
			String word = token.get(TextAnnotation.class);
			String pos = token.get(PartOfSpeechAnnotation.class);
			String ne = token.get(NamedEntityTagAnnotation.class);
			String stem = token.get(LemmaAnnotation.class);

			Word w = new Word(word);
			if(stemStage) w.setStem(stem);
			if(posStage) w.setPOS(pos);
			if(neStage) w.setNamedEntity(ne);

			builder.addWord(w);
		}

		if(parseStage) {
			SemanticGraph dependencies = sen.get(CollapsedCCProcessedDependenciesAnnotation.class);
			for(TypedDependency tdep : dependencies.typedDependencies()) {
				int gi = tdep.gov().label().get(IndexAnnotation.class) - 1;
				int di = tdep.dep().label().get(IndexAnnotation.class) - 1;
				String r = tdep.reln().getShortName();

				builder.addDependency(gi, di, r);
			}
		}

		return;
	}

	@Override
	public void configure(Properties props) {
		pipeline = new StanfordCoreNLP(props);
		
		String stages = props.getProperty("annotators");
		stemStage = stages.contains("lemma");
		neStage = stages.contains("ne");
		posStage = stages.contains("pos");
		parseStage = stages.contains("parse");
	}

}
