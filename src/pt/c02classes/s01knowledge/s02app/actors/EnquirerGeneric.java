package pt.c02classes.s01knowledge.s02app.actors;

import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

public abstract class EnquirerGeneric implements IEnquirer{
	IResponder responder;
	
	@Override
	public void connect(IResponder responder) {
		this.responder = responder;
	}

	@Override
	public abstract boolean discover();
}
