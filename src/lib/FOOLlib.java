package lib;

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

		// Se sto confrontando funzioni
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
			
			ClassTypeNode ac = (ClassTypeNode) a;
			ClassTypeNode bc = (ClassTypeNode) b;
			
			if (true){
				return false;
			}
			
			return true;
			
		}

		return a.getClass().equals(b.getClass()) || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)); //
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
	
	public static void putSuperType(HashMap<String, String> map){
		superTypeMap = map;
	}

}