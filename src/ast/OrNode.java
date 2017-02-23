package ast;

import lib.FOOLlib;

public class OrNode implements Node {

  private Node left;
  private Node right;
  
  public OrNode (Node l, Node r) {
    left=l;
    right=r;
  }
  
  public String toPrint(String s) {
    return s+"And\n" + left.toPrint(s+"  ")  
                      + right.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck() {
    if (! ( FOOLlib.isSubtype(left.typeCheck(),new BoolTypeNode()) &&
            FOOLlib.isSubtype(right.typeCheck(),new BoolTypeNode()) ) ) {
      System.out.println("Non bool in or");
      System.exit(0);
    }
    return new BoolTypeNode();
  }
  
  public String codeGeneration() {
		return left.codeGeneration()+
			   right.codeGeneration()+
			   "or \n";
  }
  
}  