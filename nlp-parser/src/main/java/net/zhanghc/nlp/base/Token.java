package net.zhanghc.nlp.base;

public abstract class Token {
	protected transient Sentence owner;
	
	protected int index;
	protected int offset;
	
	protected String token;
	
	Token() {
	}

	public Token(Sentence owner, int index, int offset, String token) {
		this.offset = offset;
		this.index = index;
		
		this.token = token;
		this.owner = owner;
	}
	
	public Sentence getOwner() {
		return owner;
	}
	public int getIndex() {
		return index;
	}
	public int getOffset() {
		return offset;
	}
	public String getToken() {
		return token;
	}
	
	public abstract boolean isWord();

}
