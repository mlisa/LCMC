package ast;

import java.util.ArrayList;
import lib.*;

public class ProgLetInNode implements Node {

	private ArrayList<Node> declist;
	private ArrayList<Node> classList;
	private Node exp;

	public ProgLetInNode(ArrayList<Node>classList, ArrayList<Node> decList, Node exp) {
		this.classList = classList;
		this.declist = decList;
		this.exp = exp;
	}

	public String toPrint(String s) {
		String declstr = "";
		String classStr = new String("");
		
		for (Node cl : classList){
			classStr += cl.toPrint(s +"	");
		}
		
		for (Node dec : declist){
			declstr += dec.toPrint(s + "  ");
		}
		return s + "ProgLetIn\n" + 
			classStr + 
			declstr + 
			exp.toPrint(s + "  ");
	}

	public Node typeCheck() {
		
		for (Node cl : classList){
			cl.typeCheck();
		}
		
		for (Node dec : declist){
			dec.typeCheck();
		}
		
		return exp.typeCheck();
	}

	public String codeGeneration() {
		String declCode = "";
		String classCode = "";
		
		for (Node cl : classList){
			classCode += cl.codeGeneration();
		}
		
		for (Node dec : declist){
			declCode += dec.codeGeneration();
		}
		
		return "push 0\n\n" +
			classCode +
			declCode + 
			exp.codeGeneration() + 
			"halt\n" + 
			FOOLlib.getCode();
	}

}