/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateActividad11CabreraFuentesDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance());
			diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
