package net.zhanghc.nlp.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SequenceTagger {
	Set<String> seqs;
	String tag;
	public static int MaxGram = 4;

	public SequenceTagger(Set<String> sequences, String tag) {
		this.seqs = new HashSet<String>(sequences);
		this.tag = tag;
	}

	public String[] tag(String[] words, boolean withPos) {
		if(words.length == 0) return new String[]{};
		
		int size = words.length;
		String[] ws;
		if(withPos) {
			ws = new String[size];
			for(int i = 0; i < size; i++) {
				int p = words[i].lastIndexOf('/');
				ws[i] = words[i].substring(0, p);
			}
		} else {
			ws = words;
		}
		int[] start = new int[size];
		int[] end = new int[size];
		int[] tag = new int[size];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(ws[i]);
			start[i] = i==0 ? 0 : end[i-1];
			end[i] = start[i] + ws[i].length();
		}
		String content = sb.toString();
		
		int aid = 1;
		for(int i = 4; i >= 1; i--) {
			for(int j = 0; j < size - i + 1; j++) {
				if(tag[j] == 0 && match(j, j+i-1, start, end, content)) {
					Arrays.fill(tag, j, j+i, aid++);
				}
			}
		}
		
		List<String> res = new ArrayList<String>();
		StringBuilder ab = null;
		int prev = 0;
		int nasp = 0;
		for(int i = 0; i < size; i++) {
			if(prev == 0 && tag[i] == prev) {
				res.add(words[i]);
			} else if(prev == 0 && tag[i] != prev) {
				ab = new StringBuilder();
				ab.append(ws[i]);
			} else if(prev != 0 && tag[i] == prev) {
				ab.append(ws[i]);
			} else if(prev != 0 && tag[i] != prev) {
				res.add(withPos ? String.format("%s/%s", ab.toString(), tag) : ab.toString());
				nasp++;
				if(tag[i] != 0) {
					ab = new StringBuilder();
					ab.append(ws[i]);
				} else {
					res.add(words[i]);
				}
			}
			prev = tag[i];
		}
		if(prev == 0) {
			res.add(words[size - 1]);
		} else {
			res.add(withPos ? String.format("%s/%s", ab.toString(), tag) : ab.toString());
			nasp++;
		}
		if(nasp == 0) return null;
		else {
			String[] ret = new String[res.size()];
			res.toArray(ret);
			return ret;
		}
	}
	
	boolean match(int s, int e, int[] start, int[] end, String content) {
		String str = content.substring(start[s], end[e]);
		return seqs.contains(str);
	}

}