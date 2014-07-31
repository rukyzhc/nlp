package net.zhanghc.nlp.data.base;

public class Word {
	protected String word;
	protected String pos;
	protected int index;

	public Word(int index, String word, String pos) {
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
	
	public String toString() {
		return String.format("%s/%s", word, pos);
	}
	
	public static Word resume(int index, String str) {
		int p = str.lastIndexOf('/');
		return new Word(index, str.substring(0, p), str.substring(p + 1));
	}

}
