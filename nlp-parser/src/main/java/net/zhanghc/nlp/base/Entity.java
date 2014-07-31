package net.zhanghc.nlp.base;

public class Entity extends Token {
	protected Type type;
	
	Entity() {
	}

	public Entity(Sentence owner, int index, int offset, String token) {
		super(owner, index, offset, token);
	}
	
	public Type getType() {
		return type;
	}
	
	public static enum Type {
		HASHTAG,
		USER,
		EMOTICON,
		URL,
		OTHER;
		
		public int tag() {
			switch(this) {
			case HASHTAG:
				return 1;
			case USER:
				return 2;
			case EMOTICON:
				return 3;
			case URL:
				return 4;
			default:
				return -1;
			}
		}
		
		public Type parse(int i) {
			switch(i) {
			case 1:
				return HASHTAG;
			case 2:
				return USER;
			case 3:
				return EMOTICON;
			case 4:
				return URL;
			}
			return OTHER;
		}
	}

	@Override
	public boolean isWord() {
		return false;
	}

}
