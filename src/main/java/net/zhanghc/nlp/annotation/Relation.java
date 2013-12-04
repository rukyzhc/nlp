package net.zhanghc.nlp.annotation;

public class Relation implements Annotation {
	protected String relation;
	
	public Relation(String relation) {
		this.relation = relation;
	}

	@Override
	public Key getKey() {
		return Key.Relation;
	}

	@Override
	public String getValue() {
		return relation;
	}
	
	@Override
	public String toString() {
		return relation;
	}

}
