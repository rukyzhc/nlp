package net.zhanghc.nlp.data.base;

public class Word {
	protected Sentence owner;

	protected String word;
	protected String pos;
	protected int index;

	Word() {
	}

	public Word(Sentence owner, int index, String word, String pos) {
		this.owner = owner;
		this.index = index;
		this.word = word;
		this.pos = pos;
	}

	public String getWord() {
		return word;
	}

	public String getPOSTag() {
		return pos;
	}

	public int getIndex() {
		return index;
	}

	public Sentence getOwner() {
		return owner;
	}

}
