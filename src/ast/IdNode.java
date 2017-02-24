package ast;
public class IdNode implements Node {

  private String id;
  private STentry entry;
  private int nestinglevel;
  
  public IdNode (String i, STentry st, int nl) {
    id=i;
    entry=st;
    nestinglevel=nl;
  }
  
  public String toPrint(String s) {
	return s+"Id:" + id + " at nestlev " + nestinglevel +"\n" + entry.toPrint(s+"  ") ;  
  }
  
  public Node typeCheck () {
	/*if (entry.getType() instanceof ArrowTypeNode) { //
	  System.out.println("Wrong usage of function identifier");
      System.exit(0);
    }	*/ 
	if(entry.isMethod() || entry.getType() == null){
		System.out.println("Wrong usage of method or class identifier");
	    System.exit(0);
	}
    return entry.getType();
  }
  
  public String codeGeneration() {
      String getAR="";
	  for (int i=0; i<nestinglevel-entry.getNestinglevel(); i++) {
	    	 getAR+="lw\n";
	  }
	  
	  if (entry.getType() instanceof ArrowTypeNode) {
          return "push "+ (entry.getOffset() - 1 )+"\n"+ //metto offset -1 sullo stack ( perchè è una funzione e devo raggiungere il codice) 
            "lfp\n"+getAR+ //risalgo la catena statica
            "add\n"+ 
            "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto  
	  }

	    return "push "+entry.getOffset()+"\n"+ //metto offset sullo stack 
		       "lfp\n"+getAR+ //risalgo la catena statica
			   "add\n"+ 
               "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto

  }
}  