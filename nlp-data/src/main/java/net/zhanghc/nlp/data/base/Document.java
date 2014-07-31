package net.zhanghc.nlp.data.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Document implements Iterable<Sentence> {
	protected List<Sentence> sentences;
	
	protected String docID;
	protected int length = 0;
	
	public Document(String docID) {
		this.sentences = new ArrayList<Sentence>();
		this.docID = docID;
	}
	
	public int size() {
		return sentences.size();
	}
	
	public void addSentence(Sentence sentence) {
		int i = sentences.size();
		sentences.add(sentence);
		sentence.index = i;
		
		length += sentence.length();
	}
	
	public int length() {
		return length;
	}

	@Override
	public Iterator<Sentence> iterator() {
		return sentences.iterator();
	}

}
