package net.zhanghc.nlp.annotation;

public class PartOfSpeech implements Annotation {
	protected String tag;

	public PartOfSpeech(String pos) {
		this.tag = pos;
	}

	public boolean isNoun() {
		return tag.charAt(0) == 'N';
	}
	
	public char toShort() {
		return tag.charAt(0);
	}

	@Override
	public Key getKey() {
		return Key.PartOfSpeech;
	}

	@Override
	public String getValue() {
		return tag;
	}
	
	@Override
	public String toString() {
		return tag;
	}

}
