package ast;

import lib.FOOLlib;

public class IfNode implements Node {

	private Node condition;
	private Node thenExp;
	private Node elseExp;

	public IfNode(Node c, Node t, Node e) {
		condition = c;
		thenExp = t;
		elseExp = e;
	}

	public String toPrint(String s) {
		return s + "If\n" + condition.toPrint(s + "  ") + thenExp.toPrint(s + "  ") + elseExp.toPrint(s + "  ");
	}

	public Node typeCheck() {
		
		if (!(FOOLlib.isSubtype(condition.typeCheck(), new BoolTypeNode()))) {
			System.out.println("non boolean condition in if");
			System.exit(0);
		}
		
		Node t = thenExp.typeCheck();
		Node e = elseExp.typeCheck();

		if (FOOLlib.lowestCommonAncestor(t, e) != null){
			return FOOLlib.lowestCommonAncestor(t, e);
		}
			
		if (FOOLlib.lowestCommonAncestor(e, t) != null) {
			return t;
		}
		
		System.out.println("Incompatible types in then else branches");
		System.exit(0);
		return null;
	}

	public String codeGeneration() {
		String labelToThenExp = FOOLlib.freshLabel();
		String labelToElseExp = FOOLlib.freshLabel();
		
		return condition.codeGeneration() + 
				"push 1\n" + 
				"beq " + labelToThenExp + "\n" + 
				elseExp.codeGeneration() + 
				"b " + labelToElseExp + "\n" + 
				labelToThenExp + ":\n" + 
				thenExp.codeGeneration() + 
				labelToElseExp + ":\n";
	}

}