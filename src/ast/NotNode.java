package ast;

import lib.FOOLlib;

public class NotNode implements Node {

	private Node x;

	public NotNode(Node x) {
		this.x = x;
	}

	public String toPrint(String s) {
		return s + "Not \n" + x.toPrint(s + "  ");
	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(x.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Non bool in  not");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		
		String labelIsOneThenZero = FOOLlib.freshLabel();
		String labelIsZeroThenOne = FOOLlib.freshLabel();
		
		return x.codeGeneration() + "push 1\n" + 
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