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

		if (left instanceof IntNode && 
				(((IntNode) left).getValue() == 1 || ((IntNode) left).getValue() == 0)) {

			if (right instanceof IntNode && 
					(((IntNode) right).getValue() == 1 || ((IntNode) right).getValue() == 0)
					|| right instanceof BoolNode) {
					
					return new BoolTypeNode();
			}
		}

		if (left instanceof BoolNode) {
			if (right instanceof IntNode && 
					(((IntNode) right).getValue() == 1 || ((IntNode) right).getValue() == 0)) {
				
				return new BoolTypeNode();
			}
		}

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

		return left.codeGeneration() + right.codeGeneration() + "add \n" + "push 2\n" + "beq " + labelTrue + "\n"
				+ "push 0\n" + "b " + labelFalse + "\n" + labelTrue + ":\n" + "push 1\n" + labelFalse + ":\n";
	}

}