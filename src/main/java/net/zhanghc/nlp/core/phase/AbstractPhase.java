package net.zhanghc.nlp.core.phase;

public abstract class AbstractPhase implements Phase {
	protected Phase next;
	
	@Override
	public void append(Phase phase) {
		this.next = phase;
	}
	
	@Override
	public Phase nextPhase() {
		return next;
	}

}
