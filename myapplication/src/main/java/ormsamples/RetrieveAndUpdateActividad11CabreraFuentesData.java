/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateActividad11CabreraFuentesData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Lista_De_Reproduccion ldiagramaclasesbdLista_De_Reproduccion = diagramaclasesbd.Lista_De_ReproduccionDAO.loadLista_De_ReproduccionByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.Lista_De_ReproduccionDAO.save(ldiagramaclasesbdLista_De_Reproduccion);
			diagramaclasesbd.Comentario ldiagramaclasesbdComentario = diagramaclasesbd.ComentarioDAO.loadComentarioByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.ComentarioDAO.save(ldiagramaclasesbdComentario);
			diagramaclasesbd.Categoria ldiagramaclasesbdCategoria = diagramaclasesbd.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.CategoriaDAO.save(ldiagramaclasesbdCategoria);
			diagramaclasesbd.Usuario ldiagramaclasesbdUsuario = diagramaclasesbd.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.UsuarioDAO.save(ldiagramaclasesbdUsuario);
			diagramaclasesbd.Video ldiagramaclasesbdVideo = diagramaclasesbd.VideoDAO.loadVideoByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.VideoDAO.save(ldiagramaclasesbdVideo);
			diagramaclasesbd.Registrado ldiagramaclasesbdRegistrado = diagramaclasesbd.RegistradoDAO.loadRegistradoByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.RegistradoDAO.save(ldiagramaclasesbdRegistrado);
			diagramaclasesbd.Administrador ldiagramaclasesbdAdministrador = diagramaclasesbd.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			diagramaclasesbd.AdministradorDAO.save(ldiagramaclasesbdAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Lista_De_Reproduccion by Lista_De_ReproduccionCriteria");
		diagramaclasesbd.Lista_De_ReproduccionCriteria ldiagramaclasesbdLista_De_ReproduccionCriteria = new diagramaclasesbd.Lista_De_ReproduccionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdLista_De_ReproduccionCriteria.id.eq();
		System.out.println(ldiagramaclasesbdLista_De_ReproduccionCriteria.uniqueLista_De_Reproduccion());
		
		System.out.println("Retrieving Comentario by ComentarioCriteria");
		diagramaclasesbd.ComentarioCriteria ldiagramaclasesbdComentarioCriteria = new diagramaclasesbd.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdComentarioCriteria.id.eq();
		System.out.println(ldiagramaclasesbdComentarioCriteria.uniqueComentario());
		
		System.out.println("Retrieving Categoria by CategoriaCriteria");
		diagramaclasesbd.CategoriaCriteria ldiagramaclasesbdCategoriaCriteria = new diagramaclasesbd.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdCategoriaCriteria.id.eq();
		System.out.println(ldiagramaclasesbdCategoriaCriteria.uniqueCategoria());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		diagramaclasesbd.UsuarioCriteria ldiagramaclasesbdUsuarioCriteria = new diagramaclasesbd.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdUsuarioCriteria.ID.eq();
		System.out.println(ldiagramaclasesbdUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Video by VideoCriteria");
		diagramaclasesbd.VideoCriteria ldiagramaclasesbdVideoCriteria = new diagramaclasesbd.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdVideoCriteria.id.eq();
		System.out.println(ldiagramaclasesbdVideoCriteria.uniqueVideo());
		
		System.out.println("Retrieving Registrado by RegistradoCriteria");
		diagramaclasesbd.RegistradoCriteria ldiagramaclasesbdRegistradoCriteria = new diagramaclasesbd.RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdRegistradoCriteria.ID.eq();
		System.out.println(ldiagramaclasesbdRegistradoCriteria.uniqueRegistrado());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		diagramaclasesbd.AdministradorCriteria ldiagramaclasesbdAdministradorCriteria = new diagramaclasesbd.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldiagramaclasesbdAdministradorCriteria.ID.eq();
		System.out.println(ldiagramaclasesbdAdministradorCriteria.uniqueAdministrador());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateActividad11CabreraFuentesData retrieveAndUpdateActividad11CabreraFuentesData = new RetrieveAndUpdateActividad11CabreraFuentesData();
			try {
				retrieveAndUpdateActividad11CabreraFuentesData.retrieveAndUpdateTestData();
				//retrieveAndUpdateActividad11CabreraFuentesData.retrieveByCriteria();
			}
			finally {
				diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
