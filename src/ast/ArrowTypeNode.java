package ast;
import java.util.ArrayList;

/**
 * Mantiene la lista dei tipi dei parametri della funzioni a cui si riferisce e il tipo di ritorno
 * @author lisamazzini
 *
 */
public class ArrowTypeNode implements Node {

  private ArrayList<Node> parlist; 
  private Node ret;
  
  public ArrowTypeNode (ArrayList<Node> p, Node r) {
    parlist=p;
    ret=r;
  }
    
  public String toPrint(String s) { //
	String parlstr="";
    for (Node par:parlist)
      parlstr+=par.toPrint(s+"  ");
	return s+"ArrowType\n" + parlstr + ret.toPrint(s+"  ->") ; 
  }
  
  public Node getRet () { //
    return ret;
  }
  
  public ArrayList<Node> getParList () { //
    return parlist;
  }

  //non utilizzato
  public Node typeCheck () {
    return null;
  }

  //non utilizzato
  public String codeGeneration() {
		return null;
  }

}  