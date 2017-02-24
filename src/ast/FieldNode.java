package ast;

public class FieldNode implements DecNode {
	
	private String id; 
	private Node symType;
	

	public FieldNode(String i, Node t) {
		this.id = i;
		this.symType = t;
	}

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		//Non utilizzato
		return null;
	}

	@Override
	public String codeGeneration() {
		return null;
	}

	@Override
	public Node getSymType() {
		return this.symType;
	}

}
