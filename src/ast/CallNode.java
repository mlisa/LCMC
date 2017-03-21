package ast;

import java.util.ArrayList;

import lib.FOOLlib;
/**
 * Chiamata di funzione 
 * @author lisamazzini
 *
 */
public class CallNode implements Node {

	private String id;
	private STentry entry;
	private ArrayList<Node> passedParlist;
	private int nestinglevel;

	public CallNode(String i, STentry e, ArrayList<Node> p, int nl) {
		id = i;
		entry = e;
		passedParlist = p;
		nestinglevel = nl;
	}

	public String toPrint(String s) { //
		String parlstr = "";
		for (Node par : passedParlist)
			parlstr += par.toPrint(s + "  ");
		return s + "Call:" + id + " at nestlev " + nestinglevel + "\n" + entry.toPrint(s + "  ") + parlstr;
	}

	public Node typeCheck() { //
		ArrowTypeNode functionType = null;
		//Controllo che sia chiamata una funzione  
		if (entry.getType() instanceof ArrowTypeNode) {
			functionType = (ArrowTypeNode) entry.getType();
		} else {
			System.out.println("Invocation of a non-function " + id);
			System.exit(0);
		}
		ArrayList<Node> declaredParList = functionType.getParList();
		//Controllo che il numero di parametri passati sia corretto
		if (!(declaredParList.size() == passedParlist.size())) {
			System.out.println("Wrong number of parameters in the invocation of " + id);
			System.exit(0);
		}
		//Per ogni parametro controllo che il tipo sia corretto (relazione di CONTRO-VARIANZA sul tipo dei parametri) 
		for (int i = 0; i < passedParlist.size(); i++)
			if (!(FOOLlib.isSubtype((passedParlist.get(i)).typeCheck(), declaredParList.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
				System.exit(0);
			}
		//Ritorna il tipo di ritorno
		return functionType.getRet();
	}

	public String codeGeneration() {
		
		//Carico il frame pointer
		String code = "lfp\n";
		//Genero il codice per i parametri passati 
		for (int i = passedParlist.size() - 1; i >= 0; i--){
			code += passedParlist.get(i).codeGeneration();
		}

		String getAR = "";
		//Metto tanti LW quanti necessari per risalire la catena statica per arrivare al padre sintattico 
		//(differenza fra nesting level attuale e quello della entry)  
		for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++){
			getAR += "lw\n";
		}
		
		//Se è un metodo non è necessario accedere a due posizioni dello stack 
		if (entry.isMethod()) {
			
			code += "lfp\n" +
					// setto AL risalendo la catena statica
					// ora recupero l'indirizzo a cui
					// saltare e lo metto sullo stack
					getAR +
					// metto offset sullo stack
					"push " + entry.getOffset() + "\n" + 
					"lfp\n" +
					// risalgo la catena statica
					getAR + 
					"add\n" +
					// carico sullo stack il valore all'indirizzo ottenuto
					"lw\n";	
		} else {
			code += // metto offset sullo stack (per il nuovo access link - FP ad AR dichiarazione funzione)
					"push " + entry.getOffset() + "\n" + 
					"lfp\n" + 
					// risalgo la catena statica
					getAR + 
					"add\n" +
					// carico sullo stack il valore all'indirizzo ottenuto 
					"lw\n" + 
					// metto offset-1 sullo stack (indirizzo di funzione, usato per saltare a codice funzione)
					"push " + (entry.getOffset() - 1) + "\n" + 
					"lfp\n" + 
					getAR + // risalgo la catena statica
					"add\n" + 
					"lw\n"; // carico sullo stack il valore all'indirizzo ottenuto
		}
		
		return code + "js\n";
		
	}

}