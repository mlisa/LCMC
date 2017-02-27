package ast;

public class EmptyNode implements Node {
	
	public EmptyNode(){
		
	}

	@Override
	public String toPrint(String indent) {
		
		return "EmptyNode:Null\n";
	}

	@Override
	public Node typeCheck() {
		return new EmptyTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "push -1\n";
	}

}
