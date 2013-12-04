package net.zhanghc.nlp.util;

public interface Splitter {

	public void setSource(String source);

	public boolean next();

	public int start();

	public int end();
	
	public String current();
	
	public void reset();

	public static class DefaultSplitter implements Splitter {
		private static Splitter instance = null;
		public static Splitter instance() {
			if(instance == null)
				instance = new DefaultSplitter();
			return instance;
		}

		@Override
		public void setSource(String source) {
			this.source = source;
			reset();
		}

		@Override
		public void reset() {
			s = -1;
			e = 0;
		}
		
		private int s = -1;
		private int e = 0;
		private String source;
		@Override
		public boolean next() {
			if(source == null)
				return false;

			if(e >= source.length())
				return false;

			s = e;
			while(++e < source.length()) {
				char c = source.charAt(e);
				if(PunctuationUtil.isEndPunc(c)) {
					break;
				}
			}
			if(e < source.length()) {
				while(++e < source.length()) {
					char c = source.charAt(e);
					if(!isSkipAfterEndPunc(c)) {
						break;
					}
				}
			}
			return true;
		}
		
		private boolean isSkipAfterEndPunc(char c) {
			switch(CharUtil.classify(c)) {
			case Space:
			case Punctuation:
				return true;
			default:
				return false;
			}
		}

		@Override
		public int start() {
			return s;
		}

		@Override
		public int end() {
			return e;
		}
		
		@Override
		public String current() {
			return source.substring(s, e);
		}

	}

}
