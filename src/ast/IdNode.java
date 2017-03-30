package ast;

public class IdNode implements Node {

	private String id;
	private STentry entry;
	private int nestinglevel;

	public IdNode(String i, STentry st, int nl) {
		id = i;
		entry = st;
		nestinglevel = nl;
	}

	public String toPrint(String s) {
		return s + "Id:" + id + " at nestlev " + nestinglevel + "\n" + entry.toPrint(s + "  ");
	}

	public Node typeCheck() {
		/*
		 * if (entry.getType() instanceof ArrowTypeNode) { //
		 * System.out.println("Wrong usage of function identifier");
		 * System.exit(0); }
		 */
		if (entry.isMethod() || entry.getType() == null) {
			System.out.println("Wrong usage of method or class identifier");
			System.exit(0);
		}
		return entry.getType();
	}
	
	/*
	 * Estensione Higher-order:
	 * 	ora ammettere anche un ID con tipo funzionale!
	 * 	se il tipo è funzionale (perchè nome di funzione o var/par di tipo funzionale) 
	 * 	due cose sono messe nello stack recuperandole come valori dall'AR dove è
	 * 	dichiarato l'ID con meccanismo usuale di risalita catena statica:
	 * 		1. FP ad AR dichiarazione funzione
	 *		2. (a offset-1) indir funzione
	 * 
	 */
	public String codeGeneration() {
		String funCode = new String("");
		String getAR = "";

		for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++) {
			getAR += "lw\n";
		}

		if (entry.getType() instanceof ArrowTypeNode) {
			// metto offset -1 sullo stack ( perchÃ¨ Ã¨ una funzione e devo
			// raggiungere il codice)
			funCode += "push " + (entry.getOffset() - 1) + "\n" + 
					// offset-1 => push offset; push 1; sub;
					// risalgo la catena statica
					"lfp\n" + 
					getAR + 
					"add\n" +
					// carico sullo stack il valore all'indirizzo ottenuto
					"lw\n";
		}
		
		// metto offset sullo stack
		return "push " + entry.getOffset() + "\n" + 
				// risalgo la catena statica	
				"lfp\n" + 
				getAR + 
				// carico sullo stack il valore all'indirizzo ottenuto
				"add\n" + 
				"lw\n" + 
				funCode;
	}
}