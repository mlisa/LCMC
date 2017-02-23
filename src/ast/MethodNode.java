package ast;

import java.util.ArrayList;

public class MethodNode implements DecNode {
	
	private String id;
	private Node retType; 
	private ArrayList<Node> parlist = new ArrayList<Node>(); 
	private ArrayList<Node> declist;
	private Node symType;
	private Node body;

	public MethodNode(String i, Node t) {
		this.id = i;
		this.retType = t;
	}
	
	public void addPar(ParNode par){
		parlist.add(par);
	}
	
	public void addVar(Node var) {
		declist.add(var);
	}
	
	public void addBody(Node body) {
		this.body = body;
	}
	
	public void addSymType(Node type){
		this.symType = type; 
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
