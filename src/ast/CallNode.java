package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class CallNode implements Node {

	private String id;
	private STentry entry;
	private ArrayList<Node> parlist;
	private int nestinglevel;

	public CallNode(String i, STentry e, ArrayList<Node> p, int nl) {
		id = i;
		entry = e;
		parlist = p;
		nestinglevel = nl;
	}

	public String toPrint(String s) { //
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		return s + "Call:" + id + " at nestlev " + nestinglevel + "\n" + entry.toPrint(s + "  ") + parlstr;
	}

	public Node typeCheck() { //
		ArrowTypeNode t = null;
		if (entry.getType() instanceof ArrowTypeNode) {
			t = (ArrowTypeNode) entry.getType();
		} else {
			System.out.println("Invocation of a non-function " + id);
			System.exit(0);
		}
		ArrayList<Node> p = t.getParList();
		if (!(p.size() == parlist.size())) {
			System.out.println("Wrong number of parameters in the invocation of " + id);
			System.exit(0);
		}
		for (int i = 0; i < parlist.size(); i++)
			if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
				System.exit(0);
			}
		return t.getRet();
	}

	public String codeGeneration() {

		String code = "lfp\n";

		for (int i = parlist.size() - 1; i >= 0; i--)
			code += parlist.get(i).codeGeneration();

		String getAR = "";
		for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++)
			getAR += "lw\n";

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
			code += // metto offset sullo stack (per il nuovo access link)
					"push " + entry.getOffset() + "\n" + 
					"lfp\n" + 
					// risalgo la catena statica
					getAR + 
					"add\n" +
					// carico sullo stack il valore all'indirizzo ottenuto 
					"lw\n" + 
					// metto offset-1 sullo stack
					"push " + (entry.getOffset() - 1) + "\n" + 
					"lfp\n" + 
					getAR + // risalgo la catena statica
					"add\n" + 
					"lw\n"; // carico sullo stack il valore all'indirizzo ottenuto
		}
		
		return code + "js\n";
		
	}

}