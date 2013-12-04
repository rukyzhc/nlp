package net.zhanghc.nlp.base;

import net.zhanghc.nlp.annotation.Annotatable;
import net.zhanghc.nlp.annotation.Annotation;
import net.zhanghc.nlp.annotation.Key;
import net.zhanghc.nlp.annotation.NamedEntity;
import net.zhanghc.nlp.annotation.PartOfSpeech;
import net.zhanghc.nlp.annotation.Stem;

public class Word extends Token implements Annotatable {
	protected Stem stem;
	protected NamedEntity ne;
	protected PartOfSpeech pos;

	Word() {
	}
	
	public Word(Sentence owner, int index, int offset, String token) {
		super(owner, index, offset, token);
	}
	
	public Word(String token) {
		super.token = token;
	}
	
	public void setStem(String stem) {
		this.stem = new Stem(stem);
	}
	
	public void setNamedEntity(String ne) {
		this.ne = new NamedEntity(ne);
	}

	public void setPOS(String pos) {
		this.pos = new PartOfSpeech(pos);
	}
	
	@Override
	public boolean isWord() {
		return true;
	}
	
	@Override
	public Annotation getAnnotation(Key key) {
		switch(key) {
		case Stem:
			return stem;
		case NamedEntity:
			return ne;
		case PartOfSpeech:
			return pos;
		}
		return null;
	}

}
