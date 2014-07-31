package net.zhanghc.nlp.util;

import static org.junit.Assert.*;

import net.zhanghc.nlp.core.Preprocessor;
import net.zhanghc.nlp.core.Processor;
import net.zhanghc.nlp.core.pipeline.DefaultProperties;
import net.zhanghc.nlp.core.pipeline.PipelineProcessor;
import net.zhanghc.nlp.annotation.Key;
import net.zhanghc.nlp.base.Document;
import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.base.Token;
import net.zhanghc.nlp.base.Word;

import org.junit.Test;

public class TestProcessor {
	
	@Test
	public void testEnglish() {
		Processor proc = new PipelineProcessor();
		proc.configure(DefaultProperties.defaultEnglishProperties("tokenize, ssplit, pos, lemma"));
//		proc.configure(DefaultProperties.defaultEnglishProperties("tokenize, ssplit, pos, lemma, ner"));
//		proc.configure(DefaultProperties.defaultEnglishProperties("tokenize, ssplit, pos, lemma, ner, parse"));
		
		String doc = "#TEST Sample tweet @romenesko (shares short excerpts from his online column): Josh Prager resigns from WSJ after 13 years; says he and the paper are no longer a good fit.";
		
		Document document = Preprocessor.create(null, doc, Splitter.DefaultSplitter.instance());

		for(Sentence sentence : document) {
			proc.process(sentence);
			System.out.println(sentence.getSource());
			int soff = sentence.getOffset();
			for(Token token : sentence) {
				int off = soff + token.getOffset();
				int len = token.getToken().length();
				String expect = doc.substring(off, off + len);
				assertEquals(expect, token.getToken());
				
				if(token.isWord()) {
					System.out.printf("%d\t%d\t%s\t%s\t%s", token.getIndex(), token.getOffset(), token.getToken(), ((Word)token).getAnnotation(Key.Stem),  ((Word)token).getAnnotation(Key.PartOfSpeech));
				} else {
					System.out.printf("%d\t%d\t%s", token.getIndex(), token.getOffset(), token.getToken());
				}
				System.out.println();
			}
		}
	}

	@Test
	public void testChinese() {
		Processor proc = new PipelineProcessor();
		proc.configure(DefaultProperties.defaultChineseProperties("segment, ssplit, pos"));
//		proc.configure(DefaultProperties.defaultChineseProperties("segment, ssplit, pos, ne"));
//		proc.configure(DefaultProperties.defaultChineseProperties("segment, ssplit, pos, ne, parse"));

		String doc = "#你妈嫌你什么# 我妈嫌我太龌龊,我妈嫌我屁股大 我妈嫌我太懒惰,我妈嫌我乱花钱 我妈嫌我太骚包,我妈嫌我长不大 都来说说，哪些方面遭妈嫌弃了？话筒话筒 发微博+ #你妈嫌你什么# +被嫌弃的事件，并且 @Mr_禎桩 比比谁最招人嫌!";

		Document document = Preprocessor.create(null, doc, Splitter.DefaultSplitter.instance());

		for(Sentence sentence : document) {
			proc.process(sentence);
			System.out.println(sentence.getSource());
			int soff = sentence.getOffset();
			for(Token token : sentence) {
				int off = soff + token.getOffset();
				int len = token.getToken().length();
				String expect = doc.substring(off, off + len);
				assertEquals(expect, token.getToken());

				if(token.isWord()) {
					System.out.printf("%d\t%d\t%s\t%s", token.getIndex(), token.getOffset(), token.getToken(), ((Word)token).getAnnotation(Key.PartOfSpeech));					 
				} else {
					System.out.printf("%d\t%d\t%s", token.getIndex(), token.getOffset(), token.getToken());
				}
				System.out.println();
			}
		}
	}

}
