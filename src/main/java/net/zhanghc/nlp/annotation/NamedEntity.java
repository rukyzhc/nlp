package net.zhanghc.nlp.annotation;

public class NamedEntity implements Annotation {
	private String ne;
	
	public NamedEntity(String ne) {
		this.ne = ne;
	}

	@Override
	public Key getKey() {
		return Key.NamedEntity;
	}

	@Override
	public String getValue() {
		return ne;
	}


}
