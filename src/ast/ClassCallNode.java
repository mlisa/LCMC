package ast;

import java.util.ArrayList;

import lib.FOOLlib;
/**
 * Gestisce la chiamata di un metodo di una classe es: obj.method()
 * @author lisamazzini
 *
 */
public class ClassCallNode implements Node {
	
	//Nome della classe
	private String classId;
	//Nome del metodo
	private String methodId;
	//Entry della classe
	private STentry classEntry;
	//Entry del metodo (scope del metodo)
	private STentry methodEntry;
	//Parametri passati al metodo
	private ArrayList<Node> parlist;
	//Nesting level di dove viene effettuata la chiamata 
	private int nestingLevel;
	
	public ClassCallNode(String classId, String methodId, STentry classEntry, STentry methodEntry, ArrayList<Node> parlist, int nestingLevel) {
		this.classId = classId;
		this.methodId = methodId;
		this.classEntry = classEntry;
		this.methodEntry = methodEntry;
		this.parlist = parlist;
		this.nestingLevel = nestingLevel; 
	}
	
	public String getClassID() {
		return classId;
	}

	public String getMethodID() {
		return methodId;
	}

	public STentry getClassEntry() {
		return classEntry;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}
	
	@Override
	public String toPrint(String indent) {
		
		String parameters = "";
		
		for(Node n : parlist){
			parameters += n.toPrint(indent + "	"); 			
		}
		
		return indent + "Class ID: " + this.getClassID() + "\n" +
				indent + "CalledMethod ID: " + this.getMethodID() + "\n" +
				parameters +
				indent +"NestingLevel: " + this.getNestingLevel() + "\n";
	}

	@Override
	public Node typeCheck() {
		ArrowTypeNode methodType = null;
		//Controllo che sia di tipo corretto
		if(methodEntry.getType() instanceof ArrowTypeNode){
			methodType = (ArrowTypeNode)methodEntry.getType();
		} else {
			System.out.println("Invocation of a non-method " + methodId);
			System.exit(0);
		}
		
		ArrayList<Node> parMethod = methodType.getParList();
				
		//I parametri devono essere di stessa cardinalità
		if(parlist.size() == parMethod.size()){
			//Controllo che i parametri siano del tipo giusto
			for(int i=0; i <parlist.size(); i++){
				
				//Prendo il tipo del parametro passato
				Node passedParType = parlist.get(i).typeCheck();
				//Prendo il tipo del parametro atteso
				Node declaredParType = parMethod.get(i);
				
				//Se non è sottotipo lancio errore (contro-varianza) 
				if(!FOOLlib.isSubtype(passedParType, declaredParType)){
					System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + methodId);
					System.exit(1);
				}
			}
		} else {
			System.out.println("Wrong number of parameters in the invocation of " + methodId);
			System.exit(1);
		}
		
		//Valore di ritorno del metodo
		return ((ArrowTypeNode)methodEntry.getType()).getRet();
	}

	@Override
	public String codeGeneration() {
		
		//Carico il frame pointer
		String code = new String("lfp\n");
		
		// Genero il codice per ogni parametro
		for (Node arg : parlist){
			code += arg.codeGeneration();
		}
		
		String jumpsToAR = new String("");
		
		// Per prendere il codice dell'AR relativo alla classe in cui è dichiarato il metodo
		// devo fare tanti salti quanti sono i nestinglevel di differenza
		// AKA Risalita Catena Statica
		for (int jump = 0; jump < nestingLevel - classEntry.getNestinglevel(); jump ++){
			jumpsToAR += "lw\n";
		}
				
		// Prendo l'indirizzo dell'AL = Indirizzo dell'Object Pointer
		code += "push " + classEntry.getOffset() + "\n"+
				"lfp\n" +
				jumpsToAR +	
				"add\n" +
				"lw\n";
		
		// Recupero l'indirizzo del metodo richiamato dalla classe
		code += "push " + classEntry.getOffset() + "\n" +
				"lfp\n" +
				jumpsToAR +				
				"add\n" +
				"lw\n" +
				"push " + methodEntry.getOffset() + "\n" +
				"add\n" +
				"lw\n";
		
		return code +"js\n";
	}

}
