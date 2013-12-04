package net.zhanghc.nlp.core;

import java.util.Properties;

import net.zhanghc.nlp.base.Sentence;

public interface Processor {

	public void configure(Properties properties);
	
	public void process(Sentence sentence);

}
