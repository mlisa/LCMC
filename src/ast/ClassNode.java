package ast;

import java.util.ArrayList;

public class ClassNode implements DecNode {
	
	private String id;
	private ArrayList<Node> fieldList = new ArrayList<Node>();
	private ArrayList<Node> methodList = new ArrayList<Node>();
	
	public ClassNode(String i, ArrayList<Node> fList, ArrayList<Node> mList) {
		this.id = i;
		this.fieldList = fList;
		this.methodList = mList;
	
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

	@Override
	public Node getSymType() {
		// TODO Auto-generated method stub
		return null;
	}

}
