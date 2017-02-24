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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
