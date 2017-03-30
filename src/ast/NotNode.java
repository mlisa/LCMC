package ast;

import lib.FOOLlib;

public class NotNode implements Node {

	private Node term;

	public NotNode(Node x) {
		this.term = x;
	}

	public String toPrint(String s) {
		return s + "Not \n" + term.toPrint(s + "  ");
	}

	public Node typeCheck() {
		
		if (term instanceof IntNode && 
				(((IntNode) term).getValue() == 1 || ((IntNode) term).getValue() == 0)) {

					return new BoolTypeNode();
		}
		
		if (!(FOOLlib.isSubtype(term.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Non bool in  not");
			System.exit(0);
		}
		
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		
		String labelIsOneThenZero = FOOLlib.freshLabel();
		String labelIsZeroThenOne = FOOLlib.freshLabel();
		
		return term.codeGeneration() + "push 1\n" + 
				"beq " + labelIsOneThenZero + "\n" +
				// se sono diversi (quindi era 0)
				"push 1 \n" + 
				"b " + labelIsZeroThenOne + "\n" + 
				labelIsOneThenZero + ":\n" +
				// se sono uguali (quindi era 1)
				"push 0 \n" + 
				labelIsZeroThenOne + ":\n";
	}

}