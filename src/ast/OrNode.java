package ast;

import lib.FOOLlib;

public class OrNode implements Node {

	private Node left;
	private Node right;

	public OrNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "Or\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
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
			System.out.println("Non bool in or");
			System.exit(0);
		}
		
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		
		String labelTrue = FOOLlib.freshLabel();
		String labelFalse = FOOLlib.freshLabel();
		
		return left.codeGeneration() + 
				right.codeGeneration() + 
				"add\n" +
				"push 0\n" +
				"beq " + labelFalse + "\n" +
				"push 1\n" +
				"b " + labelTrue + "\n" +
				labelFalse + ":\n" + 
				"push 0\n" +
				labelTrue + ":\n";
	}

}