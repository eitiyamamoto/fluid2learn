package pt.c02classes.s01knowledge.s02app.actors;


import java.util.ArrayList;

public class EnquirerMaze extends EnquirerGeneric {
	
	public class Caminho {
		ArrayList<String> bifurcacao;
		String movProx;
		
		Caminho () {
			movProx = null;
			bifurcacao = new ArrayList<String> ();
		}
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

		if (responder.finalAnswer("cheguei"))
			System.out.println("Voce encontrou a saida!");
		else
			System.out.println("Fuem fuem fuem!");
		
		return true;
	}
}