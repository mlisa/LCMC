package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class NewNode implements Node {

	private ArrayList<Node> paramList;
	private String className; 
	private CTentry classEntry;
	
	public NewNode(String className, ArrayList<Node> paramList, CTentry classEntry){
		this.className = className; 
		this.paramList = paramList; 
		this.classEntry = classEntry;
	}
	
	@Override
	public String toPrint(String indent) {
		
		String fields = "";
		
		for (Node n : paramList){
			fields += n.toPrint(indent + "	");
		}
		
		return indent + "Class ID: " + this.className + "\n" + fields;
	}

	@Override
	public Node typeCheck() {
		
		//I campi devono essere in egual numero
		if(classEntry.getAllFields().size() == paramList.size()){
			//Controllo che i tipi siano giusti
			for(int i=0; i < paramList.size(); i++){
				Node fieldType = ((FieldNode)classEntry.getAllFields().get(i)).getSymType();
				Node calledFieldType = paramList.get(i).typeCheck();
				
				if(!FOOLlib.isSubtype(calledFieldType, fieldType)){
					System.out.println("ERRORE");
					System.exit(1);
				}
			}
		} else {
			System.out.println("ERRORE");
			System.exit(1);
		}
		return new ClassTypeNode(className);
	}

	@Override
	public String codeGeneration() {
		
		String code = new String("");
		
		// Esecuzione CodeGen di tutti gli argomenti
		for (Node f : paramList){
			code += f.codeGeneration();
		}
		
		// Caricamento argomenti sull'heap secondo il layout degli oggetti 
		for (int index = 0; index < this.paramList.size(); index++){
			code +=	"lhp\n"	+		// Alloco spazio per l'heap = Pusho nello stack l'indirizzo dell'heap pointer
					"sw\n" +		// Poppo dallo stack l'indirizzo dell'hp e il valore del argomento 
									// => Carico l'argomento nell'indirizzo del primo valore poppato (HP address) 
					"lhp\n"	+ 		// Pusho nuovamente l'indirizzo dell'HP nello stack 
					"push 1\n" +	// Pusho 1 nello stack
					"add\n" +		// Incremento di 1 byte l'indirizzo dell'HP
					"shp\n";		// Aggiorno effettivamente il valore dell'HP, salvandolo nell'HP register
		}
		
		code += "lhp\n";		// Faccio coincidere Object Pointer e HP -> Salvo OP sullo stack
		
		// Pusho sull'heap le label dei metodi sempre secondo l'Obj Layout 
		for (Node m : classEntry.allMethods){
			code += "push " + ((MethodNode)m).getLabel() + "\n" +
					"lhp\n" +
					"sw\n" +
					"lhp\n" +
					"push 1\n" +
					"add\n" +
					"shp\n";
		}
		
		if (classEntry.allMethods.isEmpty() &&
				classEntry.allFields.isEmpty()){
			// Devo gestire le classi che non possiedono metodi e campi!
			code += "lhp\n" +
					"push 1\n" +
					"add\n" +
					"shp\n";
		}
		
		return code;
	}

}
