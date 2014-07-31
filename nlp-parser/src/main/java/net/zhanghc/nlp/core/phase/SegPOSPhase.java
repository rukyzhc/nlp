package net.zhanghc.nlp.core.phase;

import java.util.Properties;

import net.zhanghc.nlp.annotation.pos.TagSet;

public abstract class SegPOSPhase extends AbstractPhase {

	@Override
	public Type getType() {
		return Type.SEG_POS;
	}
	
	public abstract void setTagSet(TagSet set);
	
	public static SegPOSPhase create(Properties conf) {
		return null;
	}

}
