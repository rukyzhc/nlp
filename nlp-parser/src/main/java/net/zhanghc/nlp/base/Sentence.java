package net.zhanghc.nlp.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.zhanghc.nlp.annotation.Relation;

public final class Sentence implements Iterable<Token> {
	protected transient Document owner;

	protected int index;
	protected int offset;

	protected String source;

	protected List<Token> tokens;
	protected List<Dependency> dependencies;

	public Sentence(Document owner, String source) {
		this(source);
		locate(owner);
	}

	public Sentence(String source) {
		this.source = source;
		this.tokens = new ArrayList<Token>();
		this.dependencies = new ArrayList<Dependency>();
	}

	public void locate(Document owner) {
		this.owner = owner;
		owner.addSentence(this);
	}

	@Override
	public Iterator<Token> iterator() {
		return tokens.iterator();
	}

	public int length() {
		return source.length();
	}

	public String getSource() {
		return source;
	}

	public int getOffset() {
		return offset;
	}

	public void rebuild() {
		for(Token token : tokens) {
			token.owner = this;
		}
	}
	
	public static class Builder {
		Sentence sentence;

		public Builder(Sentence sentence) {
			this.sentence = sentence;

			initial();
		}

		int woff;
		int eoff = 0;
		int sidx = -1;
		public void addWord(Word word) {
			sidx++;
			int loc = plain.indexOf(word.token, woff);
			if(loc == -1) {
				return;
			}
			woff = loc + word.token.length();
			word.offset = offset[loc];

			for(int i = eoff; i < word.offset; i++) {
				Entity e = null;
				if((e = entities[i]) != null) {
					e.index = sentence.tokens.size();
					sentence.tokens.add(e);
				}
			}
			eoff = word.offset;

			word.index = sentence.tokens.size();
			sentence.tokens.add(word);

			wPtr[sidx] = word.index;
		}

		public void addDependency(int gindex, int dindex, String rel) {
			Dependency dep = new Dependency();

			dep.govIdx = wPtr[gindex];
			dep.depIdx = wPtr[dindex];
			if(dep.govIdx == -1 || dep.depIdx == -1) {
				//FIXME: gov or dep word is not in token list.
				return;
			}
			dep.relation = new Relation(rel);

			sentence.dependencies.add(dep);
		}

		String plain;
		int[] offset;
		int[] wPtr;
		Entity[] entities;

		static Pattern htPattern = Pattern.compile("(#[^#\\s]+)[#\\s]");
		static Pattern rtPattern = Pattern.compile("(@[\\S]+)[\\s]");
		static Pattern urlPattern = Pattern.compile("(http://[a-zA-Z0-9\\.]+/[a-zA-Z0-9]+)");

		void initial() {
			String source = sentence.source;

			byte[] tags = new byte[source.length()];
			offset = new int[source.length()];
			wPtr = new int[source.length()];
			entities = new Entity[source.length()];
			Arrays.fill(wPtr, -1);
			Arrays.fill(tags, (byte)0);

			match(source, htPattern, Entity.Type.HASHTAG, tags);
			match(source, rtPattern, Entity.Type.USER, tags);
			match(source, urlPattern, Entity.Type.URL, tags);

			StringBuilder sb = new StringBuilder();
			char[] chs = source.toCharArray();
			for(int i = 0; i < chs.length; i++) {
				if(tags[i] != 0) {
					continue;
				}

				offset[sb.length()] = i;
				sb.append(chs[i]);
			}

			plain = sb.toString();
		}

		void match(String source, Pattern p, Entity.Type type, byte[] tags) {
			Matcher m = p.matcher(source);
			while(m.find()) {
				Entity entity = new Entity();

				entity.offset = m.start();
				entity.token = m.group(1);
				entity.type = type;

				entities[entity.offset] = entity;
				for(int i = m.start(); i < m.end(); i++) {
					tags[i] = (byte)type.tag();
				}
			}
		}

		public String getPlainText() {
			return plain;
		}

	}


}
