package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ast.*;

public class FOOLlib {

	private static int labCount = 0;

	private static int funLabCount = 0;

	private static String funCode = "";

	private static HashMap<String, String> superTypeMap;

	// valuta se il tipo "a" è <= al tipo "b"
	public static boolean isSubtype(Node subType, Node superType) {

		// Se sto confrontando funzioni o metodi
		if (subType instanceof ArrowTypeNode && superType instanceof ArrowTypeNode) {

			ArrowTypeNode subTypeArrowType = (ArrowTypeNode) subType;
			ArrowTypeNode superTypeArrowType = (ArrowTypeNode) superType;

			if (subTypeArrowType.getParList().size() != superTypeArrowType.getParList().size()) {
				return false;
			}

			// Se relazione controvarianza dei parametri
			for (int i = 0; i < subTypeArrowType.getParList().size(); i++) {
				//È corretta se il supertipo è uguale o "sovratipo" al sottotipo 
				if (!isSubtype(superTypeArrowType.getParList().get(i), subTypeArrowType.getParList().get(i))) {
					return false;
				}
			}

			// Relazione covarianza tra return
			return isSubtype(subTypeArrowType.getRet(), superTypeArrowType.getRet());

		} else if (subType instanceof ClassTypeNode && superType instanceof ClassTypeNode){
			
			String subClassID = ((ClassTypeNode) subType).getClassID();
			String superClassID = ((ClassTypeNode) superType).getClassID();
			
			//Se sono due classi uguali
			if(subClassID.equals(superClassID)){
				return true;
			}
			
			//Cerco se esiste relazione di sottoclasse-superclasse nella mappa 
			do {
				if (superTypeMap.containsKey(subClassID) && superTypeMap.get(subClassID).equals(superClassID)){
					return true;
				}
				
				subClassID = superClassID;
				superClassID = superTypeMap.get(subClassID);
			} while(superClassID != null);
			
			return false;
			
		} else if (subType instanceof EmptyTypeNode && superType instanceof ClassTypeNode){
			return true; 
		}

		return subType.getClass().equals(superType.getClass()) || ((subType instanceof BoolTypeNode) && (superType instanceof IntTypeNode)); //
	}
	
	public static Node lowestCommonAncestor(Node a, Node b){
		//Se uno dei due è NULL, ritorno l'altro
		if (a instanceof EmptyTypeNode){
			return b;
		}
		
		if (b instanceof EmptyTypeNode){
			return a;
		}
		
		//Se sono classi, cerco il lowest common ancestor utilizzando la superType map 
		if (a instanceof ClassTypeNode && b instanceof ClassTypeNode){
			
			String superClassID = ( (ClassTypeNode) a ).getClassID();
			
			do {
				Node superNode = new ClassTypeNode(superClassID);

				if (FOOLlib.isSubtype(b, superNode)){
					return superNode;
				}
				
				superClassID = FOOLlib.superTypeMap.get(superClassID);
				
			} while(superClassID != null);
		// Se sono funzioni torna null se il controllo non ha successo, altrimenti torna un tipo 
		// funzionale che ha come tipo di ritorno il risultato della chiamata ricorsiva e come tipo 
		// di parametro i-esimo il tipo che è sottotipo dell'altro
		} else if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode &&
				((ArrowTypeNode)a).getParList().size() == ((ArrowTypeNode)b).getParList().size()){
			
			ArrowTypeNode ar = (ArrowTypeNode) a;
			ArrowTypeNode br = (ArrowTypeNode) b;
			Node retType = FOOLlib.lowestCommonAncestor( ar.getRet(), br.getRet());
			ArrayList<Node> parList = new ArrayList<>();
			
			if (retType != null ){
				
				for (int index = 0; index < ar.getParList().size(); index++){
					
					//Controllo quale parametro è sottotipo dell'altro e lo aggiungo alla parList dell'ArrowTypeNode
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

	public static String freshFunLabel() {
		return "function" + (funLabCount++);
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