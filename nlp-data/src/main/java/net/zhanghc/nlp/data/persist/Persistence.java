package net.zhanghc.nlp.data.persist;

import java.util.Iterator;

import net.zhanghc.nlp.data.base.Document;
import net.zhanghc.nlp.data.base.Relation;
import net.zhanghc.nlp.data.base.Sentence;
import net.zhanghc.nlp.data.base.Sentence.SentenceBuilder;
import net.zhanghc.nlp.data.base.Word;

public class Persistence {
	
	public static <T extends Persistable> void persist(Document doc, T target) {
		target.setID(doc.getID());
		int size = doc.size();
		
		StringBuilder sb = new StringBuilder();
		
		String[] pos = new String[size];
		String[] dep = new String[size];
		
		Iterator<Sentence> iter = doc.iterator();
		int i = 0;
		while(iter.hasNext()) {
			Sentence s = iter.next();
			sb.append(s.getContent());
			
			StringBuilder pb = new StringBuilder();
			for(Word w : s) {
				pb.append(w.toString());
				pb.append(' ');
			}
			pos[i] = pb.toString().trim();
			
//			StringBuilder db = new StringBuilder();
//			for(Dependency d : s.getDependencies()) {
//				db.append(d.toString());
//				db.append(' ');
//			}
//			dep[i] = db.toString().trim();
			
			if(iter.hasNext()) {
				sb.append('\n');
			}
			i++;
		}
		
		target.setContent(sb.toString());
		target.setPosText(pos);
		target.setDepText(dep);
	}
	
	public static <T extends Loadable> Document load(T data) {
		Document doc = new Document(data.getID());
		int size = data.size();
		String[] sens = data.getContent().split("\n");
		String[] deps = data.getDepText();
		String[] wrds = data.getPosText();
		
		if(sens.length != size) {
			throw new IllegalArgumentException("Size of sentence is incompatible.");
		}
		if(wrds.length != size) {
			throw new IllegalArgumentException("Size of postag is incompatible.");
		}
		if(deps.length != size) {
			throw new IllegalArgumentException("Size of dependencies is incompatible.");
		}
		
		for(int i = 0; i < size; i++) {
			SentenceBuilder s = new SentenceBuilder();
			s.setIndex(i);
			s.setContent(sens[i]);
			String[] ws = wrds[i].split(" ");
			int j = 0;
			for(String w : ws) {
				s.addWord(Word.resume(j++, w));
			}
			String[] ds = deps[i].split(" ");
			for(String d : ds) {
				s.addRelation(Relation.resume(d));
			}
			
			doc.addSentence(s.build());
		}
		return doc;
	}

}
