package net.zhanghc.nlp.data.base;

import net.zhanghc.nlp.data.base.Sentence.Matcher;
import net.zhanghc.nlp.data.persist.Loadable;
import net.zhanghc.nlp.data.persist.Persistence;

public class TestSentence {
	public static void main(String[] args) throws Exception {
		Doc r = new Doc();
		r.c = "经充电后使用，效果很好";
		r.p = new String[] {"经/p 充电/vi 后/f 使用/v ，/wd 效果/n 很/d 好/a"};
		r.d = new String[] {"0,3,prep 1,2,lccomp 2,0,plmod 3,-1,root 5,7,nsubj 6,7,advmod 7,3,dep"};
		
		Document d = Persistence.load(r);
		Sentence sen = d.getSentence().get(0);
		long s = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++) {
			Matcher m = sen.match("电后使用，效");
		}
		System.err.printf("%.3e", (System.currentTimeMillis() - s) / 10000000.0);
	}
	
	static class Doc implements Loadable {
		String c;
		String[] p;
		String[] d;
		@Override
		public String getID() {
			return null;
		}
		@Override
		public String getContent() {
			return c;
		}
		@Override
		public int size() {
			return p.length;
		}
		@Override
		public String[] getDepText() {
			return d;
		}
		@Override
		public String[] getPosText() {
			return p;
		}
	}
}
