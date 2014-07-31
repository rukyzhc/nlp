package net.zhanghc.nlp.data.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Sentence implements Iterable<Word> {
	protected transient Document owner;

	protected int index;

	protected String source;

	protected List<Word> words;
	protected List<Dependency> dependencies;

	public Sentence(Document owner, String source) {
		this(source);
		locate(owner);
	}

	public Sentence(String source) {
		this.source = source;
		this.words = new ArrayList<Word>();
		this.dependencies = new ArrayList<Dependency>();
	}

	public void locate(Document owner) {
		this.owner = owner;
		owner.addSentence(this);
	}

	@Override
	public Iterator<Word> iterator() {
		return words.iterator();
	}

	public int length() {
		return source.length();
	}

	public String getSource() {
		return source;
	}

}
