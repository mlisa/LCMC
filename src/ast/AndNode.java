package ast;

import lib.FOOLlib;

public class AndNode implements Node {

	private Node left;
	private Node right;

	public AndNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "And\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new BoolTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Non bool in and");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String labelTrue = FOOLlib.freshLabel();
		String labelFalse = FOOLlib.freshLabel();
		
		return left.codeGeneration() + 
				right.codeGeneration() + 
				"add \n" +
				"push 2\n" +
				"beq " + labelTrue + "\n" +
				"push 0\n" +
				"b " + labelFalse + "\n"+
				labelTrue + ":\n" + 
				"push 1\n" +
				labelFalse + ":\n";
	}

}