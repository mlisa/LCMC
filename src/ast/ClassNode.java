package ast;

import java.util.ArrayList;
import lib.FOOLlib;

public class ClassNode implements DecNode {
	
	//private String id;
	private Node type;
	private ArrayList<Node> fieldList = new ArrayList<Node>();
	private ArrayList<Node> methodList = new ArrayList<Node>();
	private CTentry classEntry;
	private CTentry superEntry; 
	
	public ClassNode(Node type, ArrayList<Node> fList, ArrayList<Node> mList, CTentry classEntry, CTentry superEntry) {
		//this.id = i; // Il nome della Classe è contenuto in Type!!!
		this.type = type;
		this.fieldList = fList;
		this.methodList = mList;
		this.classEntry = classEntry;
		this.superEntry = superEntry;
	
	}
	
	public String getClassID(){
		return ((ClassTypeNode) this.type).getClassID();
	}
	
	public void addMethod(Node method){
		this.methodList.add(method);
	}
	
	public void addField(Node field){
		this.fieldList.add(field);
	}

	@Override
	public String toPrint(String indent) {
		
		String print = indent + "Type: " + type.toPrint(indent + "	");
		
		for (Node n : fieldList){
			print += n.toPrint(indent + "	");
		}
		
		for (Node n : methodList){
			print += n.toPrint(indent + "	");
		}
		
		
		return print;
	}

	@Override
	public Node typeCheck() {
		
		for (Node m : methodList){
			m.typeCheck();
		}
		
		//
		
		// CONTROLLO OVERRIDE
		if (superEntry != null){
			// Controllo tipo per i campi 
			for(int i = 0; i < superEntry.getAllFields().size(); i++){
				Node superFieldType = ((FieldNode)superEntry.getAllFields().get(i)).getSymType();
				Node classFieldType = ((FieldNode)classEntry.getAllFields().get(i)).getSymType();
				
				if(!FOOLlib.isSubtype(classFieldType, superFieldType)){
					System.out.println("Errore");
					System.exit(1);
				}
			}
			
			// Controllo i tipi per i metodi
			for(int i = 0; i < superEntry.getAllMethods().size(); i++){
				Node superMethodType = ((MethodNode)superEntry.getAllMethods().get(i)).getSymType();
				Node classMethodType = ((MethodNode)classEntry.getAllMethods().get(i)).getSymType();
				
				if(!FOOLlib.isSubtype(classMethodType, superMethodType)){
					System.out.println("Errore");
					System.exit(1);
				}
			}
		}

		// Valore di ritorno non utilizzato
		return null;
	}

	@Override
	public String codeGeneration() {
		for(Node n : this.methodList){
			((MethodNode)n).setLabel(FOOLlib.freshLabel());
		}
		
		for(Node n : this.methodList){
			n.codeGeneration();
		}
		
		return "";
	}

	@Override
	public Node getSymType() {
		return this.type;
	}

}
