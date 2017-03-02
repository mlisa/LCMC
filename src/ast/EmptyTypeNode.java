package ast;

public class EmptyTypeNode implements Node {
	
	public EmptyTypeNode() {
		
	}
	
	@Override
	public String toPrint(String indent) {
		
		return indent+"EmptyTypeNode:Null\n";
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
