package ast;

public class ClassTypeNode implements Node {
	
	private String id = "";
	
	public ClassTypeNode(String id){
		this.id = id;
	}
	
	public String getClassID(){
		return this.id;
	}
	
	@Override
	public String toPrint(String indent) {
		
		return indent + id +":ClassType\n";
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return "";
	}

}
