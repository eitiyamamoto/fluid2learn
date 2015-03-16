package pt.c02classes.s01knowledge.s02app.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import pt.c02classes.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c02classes.s01knowledge.s01base.impl.Statistics;
import pt.c02classes.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;
import pt.c02classes.s01knowledge.s01base.inter.IStatistics;
import pt.c02classes.s01knowledge.s02app.actors.EnquirerMaze;
import pt.c02classes.s01knowledge.s02app.actors.ResponderMaze;

public class OrchestratorInteractive
{
	public static void main(String[] args) throws IOException
	{
		IEnquirer enq;
		IResponder resp;
		IStatistics stat;
		IBaseConhecimento bc = new BaseConhecimento();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        bc.setScenario("maze");
        
        ArrayList<String> mazeName = new ArrayList<String>(Arrays.asList(bc.listaNomes()));;
        
        
        System.out.println("Welcome to the Dungeon & Maze!");
        System.out.println("Our Dungeons and mazes:");
        for (String name : mazeName) {
			System.out.println(name);
		}
        
		System.out.println("Which maze?");
		
		String selectedMaze = br.readLine();
		
		stat = new Statistics();
		resp = new ResponderMaze(stat, selectedMaze);
		enq = new EnquirerMaze();
		enq.connect(resp);
		enq.discover();
		System.out.println("----------------------------------------------------------------------------------------\n");
	}
}
