package net.zhanghc.nlp.data.base;

public class Relation {
	protected int govIdx;
	protected int depIdx;

	protected String relation;
	
	public String toString() {
		return String.format("%d,%d,%s", govIdx, depIdx, relation);
	}
	
	public static Relation resume(String str) {
		String[] ss = str.split(",");
		Relation ret = new Relation();
		ret.govIdx = Integer.parseInt(ss[0]);
		ret.depIdx = Integer.parseInt(ss[1]);
		ret.relation = ss[2];
		return ret;
	}
}
