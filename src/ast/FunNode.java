package ast;
import java.util.ArrayList;

import lib.FOOLlib;
/**
 * Dichiarazione di una funzione 
 * @author lisamazzini
 *
 */
public class FunNode implements DecNode {

  private String id;
  private Node retType; 
  private ArrayList<Node> parlist = new ArrayList<Node>(); 
  private ArrayList<Node> declist; 
  private Node body;
  private Node symType;
  
  public FunNode (String i, Node t) {
    id=i;
    retType=t;
  }
  
  public void addDecBody (ArrayList<Node> d, Node b) {
    declist=d;
    body=b;
  }  
  
  public void addPar (Node p) {
    parlist.add(p);
  }
  
  public void addSymType(Node type){
	  this.symType = type;
  }
  
  public String toPrint(String s) {
	  
	String parlstr="";
	
	for (Node par:parlist){
		parlstr+=par.toPrint(s+"  ");
	}
	  
	String declstr="";
	
	if (declist!=null){
		for (Node dec:declist) {
			declstr+=dec.toPrint(s+"  ");
		}
	}
	  
    return s+"Fun:" + id +"\n"
		   +retType.toPrint(s+"  ")
		   +parlstr
	   	   +declstr
           +body.toPrint(s+"  ") ; 
  }
  
  //valore di ritorno non utilizzato
  public Node typeCheck () {
	if (declist!=null) {
	  for (Node dec:declist){
		dec.typeCheck();
	  }
	}
	//Co-varianza sul tipo di ritorno
    if ( !(FOOLlib.isSubtype(body.typeCheck(),retType)) ){
      System.out.println("Wrong return type for function "+id);
      System.exit(0);
    }  
    return null;
  }
  
  /*- FunNode
due cose sono messe nello stack:
1. FP a questo AR (in reg $fp)
2. (a offset-1) indir di f*/
  
  public String codeGeneration() {
	  
	    //Genero il codice delle dichiarazioni
	    String declCode="";
	    if (declist!=null) {
	    	for (Node dec:declist) {
	    	declCode+=dec.codeGeneration();
	    	}
	    }
	    
	    //Genero le pop per ogni cosa dichiarata (doppia se è una funzione)
	    String popDecList="";
	    if (declist!=null) {
	    	for (Node dec:declist) {
		    	//Controlla che sia di tipo funzionale, se lo è pop due volte 
		    	if(dec instanceof DecNode && ((DecNode)dec).getSymType() instanceof ArrowTypeNode){
			    	popDecList+="pop\n";
		    	}
		    	popDecList+="pop\n";
	    	}
	    }
	    
	    //Genero le pop per ogni parametro passato (doppia se è una funzione)
	    String popParList="";
	    for (Node dec:parlist){ 
	    	//Controlla che sia di tipo funzionale, se lo è pop due volte 
	    	if(dec instanceof DecNode && ((DecNode)dec).getSymType() instanceof ArrowTypeNode){
		    	popParList+="pop\n";
	    	}
	    	popParList+="pop\n";
	    }
	    
	    String funLabel = FOOLlib.freshFunLabel(); 
	    
	    //Preparo il codice da inserire alla fine del file .asm 
	    FOOLlib.putCode(funLabel+":\n"+
	            "cfp\n"+ //setta $fp a $sp
				"lra\n"+ //inserimento return address
	    		declCode+ //inserimento dichiarazioni locali
	    		body.codeGeneration()+ //genera il codice per il body
	    		"srv\n"+ //pop del return value
	    		popDecList+ 
	    		"sra\n"+ // pop del return address
	    		"pop\n"+ // pop di AL
	    		popParList+
	    		"sfp\n"+  // setto $fp a valore del CL
	    		"lrv\n"+ // risultato della funzione sullo stack
	    		"lra\n"+"js\n" // salta a $ra
	    		);
	    
		return "lfp\n push "+ funLabel +"\n";
  }

@Override
public Node getSymType() {
	// TODO Auto-generated method stub
	return symType;
}
  
}  