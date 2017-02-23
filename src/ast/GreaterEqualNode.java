package ast;

import lib.FOOLlib;

public class GreaterEqualNode implements Node {

  private Node left;
  private Node right;
  
  public GreaterEqualNode (Node l, Node r) {
    left=l;
    right=r;
  }
  
  public String toPrint(String s) {
    return s+"Greater or equal\n" + left.toPrint(s+"  ")   
                       + right.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck() {
	  if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
	            FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
	      System.out.println("Non integers in greater or equal");
	      System.exit(0);
	    }
    return new BoolTypeNode();
  }  
  
  public String codeGeneration() {
	  String l1 = FOOLlib.freshLabel(); 
	  String l2 = FOOLlib.freshLabel();
	  return left.codeGeneration()+
			   right.codeGeneration()+
			   "bgeq "+ l1 +"\n"+
			   "push 0\n"+
			   "b " + l2 + "\n" +
			   l1 + ":\n"+
			   "push 1\n" +
			   l2 + ":\n";
		       
  }
  
}  