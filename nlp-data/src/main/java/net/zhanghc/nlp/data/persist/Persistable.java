package net.zhanghc.nlp.data.persist;

public interface Persistable {

	public void setID(String id);

	public void setContent(String content);

	public void setDepText(String[] text);

	public void setPosText(String[] text);
	
}
