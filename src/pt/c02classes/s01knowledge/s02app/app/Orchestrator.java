package pt.c02classes.s01knowledge.s02app.app;

import pt.c02classes.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c02classes.s01knowledge.s01base.impl.Statistics;
import pt.c02classes.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirerFactory;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;
import pt.c02classes.s01knowledge.s01base.inter.IStatistics;
import pt.c02classes.s01knowledge.s02app.actors.EnquirerFactory;
import pt.c02classes.s01knowledge.s02app.actors.ResponderAnimals;

public class Orchestrator
{
	public static void main(String[] args)
	{
		IEnquirer enq;
		IResponder resp;
		IStatistics stat;
		
		IEnquirerFactory enqFactory = new EnquirerFactory();
		IBaseConhecimento base = new BaseConhecimento();

		base.setScenario("animals");
		String listaAnimais[] = base.listaNomes();
        for (int animal = 0; animal < listaAnimais.length; animal++) {
			System.out.println("Enquirer com " + listaAnimais[animal] + "...");
			stat = new Statistics();
			resp = new ResponderAnimals(stat, listaAnimais[animal]);
			enq = enqFactory.createEnquire(resp);
			enq.connect(resp);
			enq.run();
			System.out.println("----------------------------------------------------------------------------------------\n");
        }		
	}
}