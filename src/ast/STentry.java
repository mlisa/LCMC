package ast;

public class STentry {

	private int nl;
	private Node type;
	private int offset;
	private boolean isMethod = false;

	public STentry(int n, int os) {
		nl = n;
		offset = os;
	}

	public STentry(int nestinglevel, Node t, int os) {
		nl = nestinglevel;
		type = t;
		offset = os;
	}

	public void addType(Node t) {
		type = t;
	}

	public Node getType() {
		return type;
	}

	public int getOffset() {
		return offset;
	}

	public int getNestinglevel() {
		return nl;
	}
	
	public STentry setAsMethod(){
		this.isMethod=true;
		
		return this;
	}
	
	public boolean isMethod(){
		return isMethod;
	}

	public String toPrint(String s) { //
		return s + "STentry: nestlev " + Integer.toString(nl) + "\n" + 
			s + "STentry: type\n" + type.toPrint(s + "  ") + 
			s + "STentry: offset " + Integer.toString(offset) + "\n" +
			s + "STentry: isMethod " + this.isMethod() + "\n";
	}
}