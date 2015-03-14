package pt.c02classes.s01knowledge.s02app.actors;

import java.util.Scanner;

import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

import java.util.ArrayList;
import java.util.HashMap;

public class EnquirerMaze implements IEnquirer {
	
	public class Caminho {
		ArrayList<String> bifurcacao;
		String movProx;
		
		Caminho () {
			movProx = null;
			bifurcacao = new ArrayList<String> ();
		}
	}

	IResponder responder;
	
	public void connect(IResponder responder) {
		this.responder = responder;
	}
	
	public boolean discover() {
		
		ArrayList <Caminho> caminho = new ArrayList<Caminho> ();
		Caminho movimento = new Caminho();
		caminho.add(movimento);
		
		String direcoes[] = {"oeste", "sul", "leste", "norte"};
		String movProx  = null;
		
		while (!responder.ask("aqui").equalsIgnoreCase("saida")) {
			for (int j = 0; j < direcoes.length && !responder.ask("aqui").equals("visitado"); j++) {
				String resposta = responder.ask(direcoes[j]);
				if (resposta.equalsIgnoreCase("passagem") || resposta.equalsIgnoreCase("saida")) {
					movimento.bifurcacao.add(direcoes[j]);
				}
			}
			
			if (movimento.bifurcacao.size() > 0) {
				
				movProx = movimento.bifurcacao.get(movimento.bifurcacao.size() - 1);
				movimento.movProx = movProx;
				movimento.bifurcacao.remove(movProx);
				
				movimento = new Caminho();
				caminho.add(movimento);
				
				responder.move(movProx);
			}
			else {
				
				while (movimento.bifurcacao.size() == 0) {
					caminho.remove(caminho.size() - 1);
					movimento = caminho.get(caminho.size() - 1);
					
					switch (movimento.movProx) {
					case "norte":
						responder.move("sul");
						break;
					case "sul":
						responder.move("norte");
						break;
					case "leste":
						responder.move("oeste");
						break;
					case "oeste":
						responder.move("leste");
						break;
					}
				}	
			}
		}
		
		/*Scanner scanner = new Scanner(System.in);
		
		System.out.print("(P)ergunta, (M)ovimento ou (F)im? ");
		String tipo = scanner.nextLine();
		while (!tipo.equalsIgnoreCase("F")) {
		   System.out.print("  --> ");
		   String pc = scanner.nextLine();
		   switch (tipo.toUpperCase()) {
		      case "P": String resposta = responder.ask(pc);
		                System.out.println("  Resposta: " + resposta);
		                break;
		      case "M": boolean moveu = responder.move(pc);
		                System.out.println((moveu)?"  Movimento executado!":"N�o � poss�vel mover");
		                break;
		   }
			System.out.print("(P)ergunta, (M)ovimento ou (F)im? ");
			tipo = scanner.nextLine();
		}*/
		

		if (responder.finalAnswer("cheguei"))
			System.out.println("Voce encontrou a saida!");
		else
			System.out.println("Fuem fuem fuem!");
		
		// scanner.close();
		
		return true;
	}
}