package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class MethodNode implements DecNode {
	
	private String id;
	private Node retType; //Valore di ritorno del metodo, è uguale al valore conservato nella STEntry relativa al MethodNode
	private ArrayList<Node> parlist = new ArrayList<Node>(); 
	private ArrayList<Node> declist;
	private Node symType; //Tipo del Nodo MethodNode! Non il valore di ritorno del metodo!
	private Node body;
	private String label;

	public MethodNode(String identifier, Node retType) {
		this.id = identifier;
		this.retType = retType;
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

	
	public ArrayList<Node> getParlist() {
		return parlist;
	}

	public String getMethodID() {
		return id;
	}

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "Method ID: " + this.getMethodID() + "\n";
	}

	@Override
	public Node typeCheck() {
		if(!FOOLlib.isSubtype(this.body.typeCheck(), retType)){
			System.out.println("Wrong return type for method "+this.id);
			System.exit(0);
		}
		
		if(this.declist != null){
			for(Node node:this.declist){
				node.typeCheck();
			}
		}
		
		return this.retType;
	}

	@Override
	public String codeGeneration() {
		/*-MethodNode
		genera codice del metodo (invariato rispetto a funzioni)
		e lo inserisce in FOOLlib con putCode()
		usando l'etichetta nel suo campo "label"
		(torna codice vuoto)*/
		
		
		String declCode = "";
	    if (declist != null){
	    	for (Node dec : declist){
	    		declCode += dec.codeGeneration();
	    	}
	    }
		    
	    // Allocazione elementi dichiarati nel corpo del metodo
	    String popDecl = "";
	    if (declist != null){
	    	for (Node dec : declist){
	    		//Controlla che sia di tipo funzionale, se lo è pop due volte 
		    	if(dec instanceof DecNode && ((DecNode)dec).getSymType() instanceof ArrowTypeNode){
			    	popDecl += "pop\n";
		    	}
		    	popDecl += "pop\n";
	    	}
	    }
	    
	    // Allocazione Parametri passati al metodo
	    String popParl = "";
	    for (Node dec : parlist){ 
	    	// Se i parametri sono di tipo funzionale, se lo è pop due volte 
	    	if(dec instanceof DecNode && ((DecNode)dec).getSymType() instanceof ArrowTypeNode){
		    	popParl += "pop\n";
	    	}
	    	popParl += "pop\n";
	    }
	    
	    
	    FOOLlib.putCode(this.label+":\n"+
	            "cfp\n"+ //setta $fp a $sp
				"lra\n"+ //inserimento return address
	    		declCode+ //inserimento dichiarazioni locali
	    		body.codeGeneration()+
	    		"srv\n"+ //pop del return value
	    		popDecl+
	    		"sra\n"+ // pop del return address
	    		"pop\n"+ // pop di AL
	    		popParl+
	    		"sfp\n"+  // setto $fp a valore del CL
	    		"lrv\n"+ // risultato della funzione sullo stack
	    		"lra\n"+
	    		"js\n" // salta a $ra
	    		);
	    
		return "";
	}

	@Override
	public Node getSymType() {
		return this.symType;
	}
}
