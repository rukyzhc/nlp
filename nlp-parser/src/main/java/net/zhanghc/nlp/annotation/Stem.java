package net.zhanghc.nlp.annotation;

public class Stem implements Annotation {
	protected String stem;

	public Stem(String stem) {
		this.stem = stem;
	}

	@Override
	public Key getKey() {
		return Key.Stem;
	}

	@Override
	public String getValue() {
		return stem;
	}
	
	@Override
	public String toString() {
		return stem;
	}

}
