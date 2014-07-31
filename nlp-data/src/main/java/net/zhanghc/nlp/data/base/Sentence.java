package net.zhanghc.nlp.data.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Sentence implements Iterable<Word> {
	protected int index;
	protected String content;

	protected List<Word> words;
	protected List<Relation> relations;
	
	Sentence() {
		this.words = new ArrayList<Word>();
		this.relations = new ArrayList<Relation>();
	}

	@Override
	public Iterator<Word> iterator() {
		return words.iterator();
	}
	
	public int size() {
		return words.size();
	}
	
	public Word getWord(int i) {
		return words.get(i);
	}

	public int length() {
		return content.length();
	}

	public String getContent() {
		return content;
	}
	
	public Matcher match(String content) {
		int size = size();
		int j = 0, max_s = -1, max_l = 0;
		StringBuilder sb = new StringBuilder();
		String c = null;
		for(int i = 0; i < size; i++) {
			String w = words.get(i).word;
			if(content.contains(w)) {
				sb.append(w);
				if(++j > max_l) {
					max_s = i - j + 1;
					max_l = j;
					c = sb.toString();
				}
			} else {
				sb = new StringBuilder();
				j = 0;
			}
		}
		return max_s==-1 ? null:new Matcher(max_s, max_l, c);
	}
	
	public static class SentenceBuilder {
		Sentence sen = new Sentence();
		
		public void setIndex(int i) {
			sen.index = i;
		}
		
		public void setContent(String s) {
			sen.content = s;
		}

		public void addWord(Word w) {
			sen.words.add(w);
		}
		
		public void addRelation(Relation r) {
			sen.relations.add(r);
		}

		public Sentence build() {
			return sen;
		}
	}

	public static class Matcher {
		int start;
		int size;
		String match;
		Matcher(int s, int l, String m) {
			start = s; size = l; match = m;
		}
		public int getStart() {
			return start;
		}
		public int getSize() {
			return size;
		}
		public String getContent() {
			return match;
		}
	}

}
