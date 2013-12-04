package net.zhanghc.nlp.util;

import static org.junit.Assert.*;

import net.zhanghc.nlp.core.Preprocessor;
import net.zhanghc.nlp.core.Processor;
import net.zhanghc.nlp.core.pipeline.DefaultProperties;
import net.zhanghc.nlp.core.pipeline.PipelineProcessor;
import net.zhanghc.nlp.base.Document;
import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.base.Token;

import org.junit.Test;

public class TestProcessor {

	@Test
	public void test() {
		Processor proc = new PipelineProcessor();
		proc.configure(DefaultProperties.defaultChineseProperties());
		
		String doc = "#你妈嫌你什么# 我妈嫌我太龌龊,我妈嫌我屁股大 我妈嫌我太懒惰,我妈嫌我乱花钱 我妈嫌我太骚包,我妈嫌我长不大 都来说说，哪些方面遭妈嫌弃了？话筒话筒 发微博+ #你妈嫌你什么# +被嫌弃的事件，并且 @Mr_禎桩 比比谁最招人嫌!";
		
		Document document = Preprocessor.create("", doc, Splitter.DefaultSplitter.instance());
		
		for(Sentence sentence : document) {
			proc.process(sentence);
			System.out.println(sentence.getSource());
			for(Token token : sentence) {
				System.out.printf("%d\t%d\t%s", token.getIndex(), token.getOffset(), token.getToken());
				System.out.println();
			}
		}
	}

}
