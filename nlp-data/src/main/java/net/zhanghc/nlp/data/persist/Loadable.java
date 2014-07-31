package net.zhanghc.nlp.data.persist;

public interface Loadable {
	
	public String getID();

	public String getContent();
	
	public int size();

	public String[] getDepText();

	public String[] getPosText();

}
