package ast;
/**
 * La dichiarazione di campi all'interno della dichiarazione di una classe  
 * @author lisamazzini
 *
 */
public class FieldNode implements DecNode {
	
	private String id; 
	private Node symType;
	

	public FieldNode(String i, Node t) {
		this.id = i;
		this.symType = t;
	}
	
	public String getFieldID(){
		return this.id;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "Field ID: " + this.getFieldID() + "\n";
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
