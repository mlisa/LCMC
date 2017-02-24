package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CTentry {

	//Virtual table per la classe corrente
	HashMap<String,STentry> vTable = new HashMap<String,STentry>();

	//Offset per i campi
	int offsetFields;               
	
	//Offset per i metodi
	int offsetMethods;              
	                     
	//Lista per tenere traccia dei campi
	ArrayList<Node> allFields = new ArrayList<Node>();     
	                               
	//Lista per tenere traccia dei metodi
	ArrayList<Node> allMethods = new ArrayList<Node>();	     
	
	//Set per marcare gli offset già occupati dai campi e dai metodi (per il controllo di dichiarazioni doppie)
	Set<Integer> locals;
	
	//Costruttore per classi che non ereditano
	public CTentry() {
		this.vTable = new HashMap<String, STentry>();
		this.offsetFields = -1;
		this.offsetMethods = 0;
		this.allFields = new ArrayList<Node>();
		this.allMethods = new ArrayList<Node>();
		this.locals = new HashSet<Integer>();
	}

	// Costruttore nel caso in cui la classe erediti da un'altra 
	public CTentry(CTentry entry) {
		this.vTable = new HashMap<String,STentry>(entry.getVTable());
		this.offsetFields = entry.getOffsetFields();
		this.offsetMethods = entry.getOffsetMethods();
		this.allFields = new ArrayList<Node>(entry.getAllFields());
		this.allMethods = new ArrayList<Node>(entry.getAllMethods());
		this.locals = new HashSet<Integer>();
		
	}
	
	public int getOffsetFields() {
		return offsetFields;
	}

	public int getOffsetMethods() {
		return offsetMethods;
	}

	public ArrayList<Node> getAllFields() {
		return allFields;
	}

	public ArrayList<Node> getAllMethods() {
		return allMethods;
	}

	/*public STentry getMethod(String id, ArrayList<Node> parlist){
		for(Node n : allMethods){
			MethodNode m = (MethodNode)n;
			if(m.getId().equals(id)){
				for(int i = 0; i < m.getParlist().size(); i++){
					//Controllo che siano lo stesso tipo 
					ParNode passedPar = ((ParNode)parlist.get(i));
					Node nn = m.getParlist().get(i);
					ParNode officialPar = ((ParNode)nn);
					
					if (passedPar.getType() instanceof (officialPar.getType().getClass())) {
						
					}
				}
			}
		}
	}*/
    
	public HashMap<String, STentry> getVTable() {
		return vTable;
	}
	
	public void addField(String name, Node type) {
			
			STentry oldEntry = this.vTable.get(name);
			STentry newEntry;
			FieldNode field = new FieldNode(name, type);
			int offset;
			
			//Se l'entry era giò presente all'interno della virtual table, se ne fa l'override
			if(oldEntry != null){				
				// prendo l'offset della entry ereditata
				offset = oldEntry.getOffset();
				// creo una nuova STentry che sostituisce la precedente, quindi con lo stesso offset (nesting level sempre = 1 ) 
				newEntry = new STentry(1,type,offset);
				// sovrascrivo l'elemento anche all'interno della lista dei campi
				this.allFields.set(-(offset)-1, field); //Dato che i campi vanno da -1, -2, ecc, con questa operazione porto gli indici in relazione alla lista (che va da 0, 1,2..)  -(-3)-1 = 2 
			} else {
				//Se è un campo nuovo, creo una nuova entry all'offset a cui si è arrivati (nesting level sempre = 1 ) 
				newEntry = new STentry(1,type,this.offsetFields);
				//Mi salvo l'offset attuale
				offset = this.offsetFields;
				// Decremento l'offset per il campo successivo
				this.offsetFields--;
				//Aggiungo il campo alla lista dei campi
				this.allFields.add(field);
			}
			
			// inserisco l'entry nella virtual table
			this.vTable.put(name, newEntry);
			
			//Controllo che non ci siano già dichiarati dei campi all'offset indicato, altrimenti lo aggiungo 		
			if(!this.locals.add(offset)){
				// ritorna true se non era presente
				System.out.println("Error: field "+name+ " declared twice!");
				System.exit(0);
			}
		}
	
	public void addMethod(String name, Node type) {
		
		STentry oldEntry = this.vTable.get(name);
		STentry newEntry;
		MethodNode field = new MethodNode(name, type);
		int offset;
		
		//Se l'entry era giò presente all'interno della virtual table, se ne fa l'override
		if(oldEntry != null){			
			// prendo l'offset della entry ereditata
			offset = oldEntry.getOffset();
			// creo una nuova STentry che sostituisce la precedente, quindi con lo stesso offset (nesting level sempre = 1 ) 
			newEntry = new STentry(1,type,offset);
			// sovrascrivo l'elemento anche all'interno della lista dei metodi
			this.allMethods.set(offset, field); //Per i metodi uso semplicemente l'offset perchè si muove come gli indici della lista 
		} else {
			//Se è un metodo nuovo, creo una nuova entry all'offset a cui si è arrivati (nesting level sempre = 1 ) 
			newEntry = new STentry(1,type,this.offsetMethods);
			//Mi salvo l'offset per controllare all'interno delle variabili locali
			offset = this.offsetFields;
			// Aumento l'offset che indica il prossimo spazio libero
			this.offsetMethods++;
			//Aggiungo il metodo alla lista dei metodi
			this.allMethods.add(field);
		}

		// inserisco l'entry nella virtual table come metodo
		newEntry.setAsMethod();
		this.vTable.put(name, newEntry);
		
		//Controllo che non ci siano già dichiarati dei metodi all'offset indicato, altrimenti lo aggiungo 
		if(!this.locals.add(offset)){		
			// ritorna true se non era presente
			System.out.println("Error: method "+name+ " declared twice!");
			System.exit(0);
		}
		
	}

	@Override
	public String toString() {
		return "CTentry [vTable=" + vTable + ", offsetFields=" + offsetFields + ", offsetMethods=" + offsetMethods
				+ ", allFields=" + allFields + ", allMethods=" + allMethods + ", locals=" + locals + "]";
	}
	
	
	                               
}
