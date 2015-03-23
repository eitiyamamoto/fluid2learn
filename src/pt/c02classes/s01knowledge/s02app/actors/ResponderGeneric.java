package pt.c02classes.s01knowledge.s02app.actors;

import pt.c02classes.s01knowledge.s01base.inter.IObjetoConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

public abstract class ResponderGeneric implements IResponder{
	private IObjetoConhecimento obj;
	private String scenario;
	
	@Override
	public String scenario(){
		return scenario;
	}

	@Override
	public abstract String ask(String question);

	@Override
	public abstract boolean move(String direction);

	@Override
	public abstract boolean finalAnswer(String answer);
}
