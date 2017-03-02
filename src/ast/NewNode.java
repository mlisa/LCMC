package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class NewNode implements Node {

	private ArrayList<Node> fieldList;
	private String className; 
	private CTentry classEntry;
	
	public NewNode(String className, ArrayList<Node> fieldList, CTentry classEntry){
		this.className = className; 
		this.fieldList = fieldList; 
		this.classEntry = classEntry;
	}
	
	@Override
	public String toPrint(String indent) {
		
		String fields = "";
		
		for (Node n : fieldList){
			fields += n.toPrint(indent + "	");
		}
		
		return indent + "Class ID: " + this.className + "\n" + fields;
	}

	@Override
	public Node typeCheck() {
		
		//I campi devono essere in egual numero
		if(classEntry.getAllFields().size() == fieldList.size()){
			//Controllo che i tipi siano giusti
			for(int i=0; i < fieldList.size(); i++){
				Node fieldType = ((FieldNode)classEntry.getAllFields().get(i)).getSymType();
				Node calledFieldType = ((FieldNode)fieldList.get(i)).getSymType();
				
				if(!FOOLlib.isSubtype(calledFieldType, fieldType)){
					System.out.println("ERRORE");
					System.exit(1);
				}
			}
		} else {
			System.out.println("ERRORE");
			System.exit(1);
		}
		return null;
	}

	@Override
	public String codeGeneration() {
		
		String code = new String("");
		
		// Esecuzione CodeGen di tutti gli argomenti
		for (Node f : fieldList){
			code = code.concat(f.codeGeneration());
		}
		
		// Caricamento argomenti sull'heap secondo il layout degli oggetti 
		for (int index = 0; index < this.fieldList.size(); index++){
			code = code.concat("lhp\n")	// Alloco spazio per l'heap = Pusho nello stack l'indirizzo dell'heap pointer
				.concat("sw\n")		// Poppo dallo stack l'indirizzo dell'hp e il valore del argomento 
									// => Carico l'argomento nell'indirizzo del primo valore poppato (HP address) 
				.concat("lhp\n")	// Pusho nuovamente l'indirizzo dell'HP nello stack 
				.concat("push 1\n")	// Pusho 1 nello stack
				.concat("add\n")	// Incremento di 1 byte l'indirizzo dell'HP
				.concat("shp\n");	// Aggiorno effettivamente il valore dell'HP, salvandolo nell'HP register
		}
		
		code = code.concat("lhp\n");		// Faccio coincidere Object Pointer e HP -> Salvo OP sullo stack
		
		// Pusho sull'heap le label dei metodi sempre secondo l'Obj Layout 
		for (Node m : classEntry.allMethods){
			code = code.concat("push" + ((MethodNode)m).getLabel() + "\n")
				.concat("lhp\n")
				.concat("sw\n")
				.concat("lhp\n")
				.concat("push 1\n")
				.concat("add")
				.concat("shp\n");
		}
		
		if (classEntry.allMethods.isEmpty()){
			// Devo gestire le classi che non possiedono metodi!
			code = code.concat("lhp\n")
				.concat("push 1\n")
				.concat("add")
				.concat("shp\n");
		}
		
		return code;
	}

}
