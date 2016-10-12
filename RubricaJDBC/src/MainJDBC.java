import model.*;
import dao.*;


public class MainJDBC {

	public static void main(String[] args) {
RubricaDao rdao=new RubricaDao();
Rubrica r=rdao.aggiungiRubrica("Luigi");
Gestione g= new Gestione();

	try {
		g.aggiungiVoce(r, "Paolino", "Paperino", "917843961");
		g.aggiungiVoce(r, "mmmmm", "ssssss", "4768912");
	} catch (VoceDuplicato e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	
	try {
		g.aggiornaVoce(r, "mmmmm", "Martina", "ssssss", "Alfostof", "47892364");
	} catch (VoceNonEsiste e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		Voce v=g.trovaVoce(r, "Paolino", "Paperino");
		System.out.println(v.getTelefono());
	} catch (VoceNonEsiste e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		g.deleteVoce(r, "Martina", "Alfostof");
	} catch (VoceNonEsiste e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
