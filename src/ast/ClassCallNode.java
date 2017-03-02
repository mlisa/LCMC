package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class ClassCallNode implements Node {

	private String classId;
	private String methodId;
	private STentry classEntry;
	private STentry methodEntry;
	private ArrayList<Node> parlist;
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
		ArrayList<Node> parMethod = ((ArrowTypeNode)methodEntry.getType()).getParList();
				
		//I parametri devono essere di stessa cardinalità
		if(parlist.size() == parMethod.size()){
			//Controllo che i parametri siano del tipo giusto
			for(int i=0; i <parlist.size(); i++){
				
				Node parType = ((ParNode)parlist.get(i)).getSymType();
				Node fieldType = ((ParNode)parMethod.get(i)).getSymType();
				
				//Se non è sottotipo lancio errore
				if(!FOOLlib.isSubtype(parType, fieldType)){
					System.out.println("ERRORE");
					System.exit(1);
				}
			}
		} else {
			System.out.println("ERRORE");
			System.exit(1);
		}
		
		//Valore di ritorno del metodo
		return methodEntry.getType();
	}

	@Override
	public String codeGeneration() {
		
		String code = new String("lfp\n");
		
		// Genero il codice per ogni parametro
		for (Node arg : parlist){
			code += arg.codeGeneration();
		}
		
		String jumpsToAR = new String("");
		
		// Per prendere il codice dell'AR relativo alla classe in cui � dichiarato il metodo
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
