package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class ClassNode implements DecNode {
	
	private String id;
	private ArrayList<Node> fieldList = new ArrayList<Node>();
	private ArrayList<Node> methodList = new ArrayList<Node>();
	private CTentry classEntry;
	private CTentry superEntry; 
	
	public ClassNode(String i, ArrayList<Node> fList, ArrayList<Node> mList, CTentry classEntry, CTentry superEntry) {
		this.id = i;
		this.fieldList = fList;
		this.methodList = mList;
		this.classEntry = classEntry;
		this.superEntry = superEntry;
	
	}

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		//Controllo tipo per i campi 
		for(int i=0; i < superEntry.getAllFields().size(); i++){
			Node superFieldType = ((FieldNode)superEntry.getAllFields().get(i)).getSymType();
			Node classFieldType = ((FieldNode)classEntry.getAllFields().get(i)).getSymType();
			
			if(!FOOLlib.isSubtype(classFieldType, superFieldType)){
				System.out.println("Errore");
				System.exit(1);
			}
		}
		
		//Controllo i tipi per i metodi
		for(int i=0; i < superEntry.getAllMethods().size(); i++){
			Node superMethodType = ((MethodNode)superEntry.getAllMethods().get(i)).getSymType();
			Node classMethodType = ((MethodNode)classEntry.getAllMethods().get(i)).getSymType();
			
			if(!FOOLlib.isSubtype(classMethodType, superMethodType)){
				System.out.println("Errore");
				System.exit(1);
			}
		}
		
		//Valore di ritorno non utilizzato
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
		return new ClassTypeNode(this.id);
	}

}
