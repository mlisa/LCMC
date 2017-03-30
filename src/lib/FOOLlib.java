package lib;

import java.util.ArrayList;
import java.util.HashMap;

import ast.*;

public class FOOLlib {

	private static int labCount = 0;

	private static int funLabCount = 0;

	private static String funCode = "";

	private static HashMap<String, String> superTypeMap;

	// valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di base:
	// int o bool
	public static boolean isSubtype(Node a, Node b) {

		// Se sto confrontando funzioni o metodi
		if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode) {

			ArrowTypeNode ar = (ArrowTypeNode) a;
			ArrowTypeNode br = (ArrowTypeNode) b;

			if (ar.getParList().size() != br.getParList().size()) {
				return false;
			}

			// Se relazione controvarianza dei parametri
			for (int i = 0; i < ar.getParList().size(); i++) {
				if (!isSubtype(br.getParList().get(i), ar.getParList().get(i))) {
					return false;
				}
			}

			// Relazione covarianza tra return
			return isSubtype(ar.getRet(), br.getRet());

		} else if (a instanceof ClassTypeNode && b instanceof ClassTypeNode){
			
			String subClassID = ((ClassTypeNode) a).getClassID();
			String superClassID = ((ClassTypeNode) b).getClassID();
			
			//Se sono due classi uguali
			if(subClassID.equals(superClassID)){
				return true;
			}
			
			do {
				if (superTypeMap.containsKey(subClassID) && superTypeMap.get(subClassID).equals(superClassID)){
					return true;
				}
				
				subClassID = superClassID;
				superClassID = superTypeMap.get(superClassID);
			} while(superClassID != null);
			
			return false;
			
		} else if (a instanceof EmptyTypeNode && b instanceof ClassTypeNode){
			return true; 
		}

		return a.getClass().equals(b.getClass()) || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)); //
	}
	
	public static Node lowestCommonAncestor(Node a, Node b){
		
		if (a instanceof EmptyTypeNode){
			return b;
		}
		
		if (b instanceof EmptyTypeNode){
			return a;
		}
		
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode){
			
			String superClassID = ( (ClassTypeNode) a ).getClassID();
			
			Node superNode = new ClassTypeNode(superClassID);
			do {
				
				if (FOOLlib.isSubtype(b, superNode)){
					return superNode;
				}
				
				superClassID = FOOLlib.superTypeMap.get(superClassID);
				
			} while(superClassID != null);
		} else if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode &&
				((ArrowTypeNode)a).getParList().size() == ((ArrowTypeNode)b).getParList().size()){
			
			ArrowTypeNode ar = (ArrowTypeNode) a;
			ArrowTypeNode br = (ArrowTypeNode) b;
			Node retType = FOOLlib.lowestCommonAncestor( ar.getRet(), br.getRet());
			ArrayList<Node> parList = new ArrayList<>();
			
			if (retType != null ){
				for (int index = 0; index < ar.getParList().size(); index++){
					if(FOOLlib.isSubtype(ar.getParList().get(index), br.getParList().get(index))){
						parList.add(index, ar.getParList().get(index));
					} else if(FOOLlib.isSubtype(br.getParList().get(index), ar.getParList().get(index))){
						parList.add(index, br.getParList().get(index));
					} else {
						return null; 
					} 
				}
				return new ArrowTypeNode(parList, retType);
			} 
			
		} else if((a instanceof IntTypeNode && b instanceof IntTypeNode) || 
				(a instanceof IntTypeNode && b instanceof BoolTypeNode) ||
				(a instanceof BoolTypeNode && b instanceof IntTypeNode)){
			return new IntTypeNode();
		} else if((a instanceof BoolTypeNode && b instanceof BoolTypeNode)) {
			return new BoolTypeNode();
		}
		
		return null;
	}

	public static String freshLabel() {
		return "label" + (labCount++);
	}

	public static String freshFunLabel(String labelName) {
		return labelName + (funLabCount++);
	}

	public static void putCode(String c) {
		funCode += "\n" + c; // aggiunge una linea vuota di separazione prima di
								// funzione
	}

	public static String getCode() {
		return funCode;
	}

	public static void putSuperType(HashMap<String, String> map) {
		superTypeMap = map;
	}

}