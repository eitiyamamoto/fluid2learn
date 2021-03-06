package pt.c02classes.s01knowledge.s02app.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pt.c02classes.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c02classes.s01knowledge.s01base.impl.Statistics;
import pt.c02classes.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;
import pt.c02classes.s01knowledge.s01base.inter.IStatistics;
import pt.c02classes.s01knowledge.s02app.actors.EnquirerAnimals;
import pt.c02classes.s01knowledge.s02app.actors.EnquirerMaze;
import pt.c02classes.s01knowledge.s02app.actors.ResponderAnimals;
import pt.c02classes.s01knowledge.s02app.actors.ResponderMaze;

public class OrchestratorInit {
	public static void main(String[] args){
		char option = '0';
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Programa é executado enquanto não for selecionado para sair (q ou Q);
		while(option != 'q' && option != 'Q'){
			//A pergunta será repetida até obter a resposta esperada
			while( option != 'A' && option != 'a' && option != 'M' && option != 'm'
					&& option != 'q' && option != 'Q'){
				
				System.out.println("(A)nimals or (M)aze or (Q)uit?");
				
				//Caso ocorra algum erro na leitura, a variável retornará ao seu valor neutro
				// e fará a pergunta novamente;
				try {
					option = (char) br.readLine().charAt(0);
				} catch (IOException e) {
					option = '0';
				} finally{
					try {
						br.reset();
					} catch (IOException e) { } 
				}
			}
			
			//Caso tenha selecionado uma das opções que leva ao jogo, então este é executado
			// e a option é reininciada para nova consulta;
			if(option == 'A' || option == 'a'){
				Orchestrator.main(args);
				option = '0';
			} else if(option == 'M' || option == 'm'){
				try {
					OrchestratorInteractive.main(args);
				} catch (IOException e) {
					System.out.println("Erro ao ler entrada!");
				}
				option = '0';
			}
		}
	}
}
