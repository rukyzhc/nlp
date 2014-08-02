package net.zhanghc.nlp.core;

import java.util.ArrayList;
import java.util.List;

import net.zhanghc.nlp.base.Document;
import net.zhanghc.nlp.base.Sentence;
import net.zhanghc.nlp.data.util.Splitter;

public class Preprocessor {
	
	public static Document create(String docID, String document, Splitter splitter) {
		Document doc = new Document(docID);
		splitter.setSource(document);
		while(splitter.next()) {
			doc.addSentence(create(splitter.current()));
		}
		return doc;
	}
	
	public static List<Sentence> create(String document, Splitter splitter) {
		List<Sentence> ret = new ArrayList<Sentence>();
		splitter.setSource(document);
		while(splitter.next()) {
			ret.add(create(splitter.current()));
		}
		return ret;
	}
	
	public static Sentence create(Document doc, String source) {
		return new Sentence(doc, source);
	}
	
	public static Sentence create(String source) {
		return new Sentence(source);
	}

}
