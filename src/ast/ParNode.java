package ast;
public class ParNode implements DecNode {

  private String id;
  private Node type;
  
  public ParNode (String i, Node t) {
   id=i;
   type=t;
  }
  
  public String toPrint(String s) {
	  return s+"Par:" + id +"\n"
			 +type.toPrint(s+"  ") ; 
  }
  
  public Node getType() {
	return type;
}

//non utilizzato
  public Node typeCheck () {
     return null;
  }
  
  //non utilizzato
  public String codeGeneration() {
		return "";
  }

	@Override
	public Node getSymType() {
		// TODO Auto-generated method stub
		return type;
	}
    
}  