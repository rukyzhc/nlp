package net.zhanghc.nlp.util;

import net.zhanghc.nlp.base.Document;
import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.core.Preprocessor;
import net.zhanghc.nlp.core.Processor;
import net.zhanghc.nlp.core.pipeline.DefaultProperties;
import net.zhanghc.nlp.core.pipeline.PipelineProcessor;
import net.zhanghc.nlp.data.util.Splitter;

import org.junit.Test;

public class TestPersister {

	@Test
	public void test() {
		Processor proc = new PipelineProcessor();
		proc.configure(DefaultProperties.defaultEnglishProperties("tokenize, ssplit, pos, lemma"));
//		proc.configure(DefaultProperties.defaultEnglishProperties("tokenize, ssplit, pos, lemma, ner, parse"));
		String doc = "#TEST Sample tweet @romenesko (shares short excerpts from his online column): Josh Prager resigns from WSJ after 13 years; says he and the paper are no longer a good fit.";

		Document document = Preprocessor.create(null, doc, Splitter.DefaultSplitter.instance());

		for(Sentence sentence : document) {
			proc.process(sentence);
		}

		String content = Persister.persist(document);
		System.out.println(content);
	}

}
