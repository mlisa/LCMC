package ast;

import java.util.ArrayList;

public class NewNode implements Node {

	private ArrayList<Node> fieldList;
	private String className; 
	
	public NewNode(String className, ArrayList<Node> fieldList){
		this.className = className; 
		this.fieldList = fieldList; 
	}
	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
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
