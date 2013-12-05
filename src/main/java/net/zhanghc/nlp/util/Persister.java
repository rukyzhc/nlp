package net.zhanghc.nlp.util;

import com.google.gson.Gson;

import net.zhanghc.nlp.base.Document;

public final class Persister {
	private static Gson gson = new Gson(); 

	public static String persist(Document doc) {
		return gson.toJson(doc);
	}

	public static Document resume(String content) {
		Document doc = gson.fromJson(content, Document.class);
		doc.rebuild();
		return doc;
	}

}
