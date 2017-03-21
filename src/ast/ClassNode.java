package ast;

import java.util.ArrayList;
import lib.FOOLlib;
/**
 * Nodo che gestisce la dichiarazione di una classe 
 * @author lisamazzini
 *
 */
public class ClassNode implements DecNode {
	
	//Tipo della classe (in cui è contenuto il nome della classe) 
	private Node type;
	//Lista dei nodi dei campi 
	private ArrayList<Node> fieldList = new ArrayList<Node>();
	//Lista dei nodi dei metodi 
	private ArrayList<Node> methodList = new ArrayList<Node>();
	//CTEntry della classe corrente
	private CTentry classEntry;
	//CTEntry della sua superclasse (potrebbe non esserci) 
	private CTentry superEntry; 
	
	public ClassNode(Node type, ArrayList<Node> fList, ArrayList<Node> mList, CTentry classEntry, CTentry superEntry) {
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
		
		//Controllo del typecheck per ogni metodo (es. tipo di ritorno e dichiarazioni corrette) 
		for (Node m : methodList){
			m.typeCheck();
		}
		
		// CONTROLLO OVERRIDE se c'è superclasse 
		if (superEntry != null){
			// Controllo tipo per i campi, controllo che siano sottotipo di quelli della superclasse
			for(int i = 0; i < superEntry.getAllFields().size(); i++){
				Node superFieldType = ((FieldNode)superEntry.getAllFields().get(i)).getSymType();
				Node classFieldType = ((FieldNode)classEntry.getAllFields().get(i)).getSymType();
				
				if(!FOOLlib.isSubtype(classFieldType, superFieldType)){
					System.out.println("Wrong field type declared in subclass" + ((ClassTypeNode)type).getClassID());
					System.exit(1);
				}
			}
			
			// Controllo i tipi per i metodi
			for(int i = 0; i < superEntry.getAllMethods().size(); i++){
				Node superMethodType = ((MethodNode)superEntry.getAllMethods().get(i)).getSymType();
				Node classMethodType = ((MethodNode)classEntry.getAllMethods().get(i)).getSymType();
				
				if(!FOOLlib.isSubtype(classMethodType, superMethodType)){
					System.out.println("Wrong method signature in subclass" + ((ClassTypeNode)type).getClassID());
					System.exit(1);
				}
			}
		}

		// Valore di ritorno non utilizzato
		return null;
	}

	@Override
	public String codeGeneration() {
		//Prima setto tutte le label dei metodi
		for(Node n : this.methodList){
			((MethodNode)n).setLabel(FOOLlib.freshFunLabel());
		}
		
		//Poi chiamo la code generation di ogni metodo
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
