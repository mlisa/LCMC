package ast;

public class EmptyNode implements Node {

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
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
