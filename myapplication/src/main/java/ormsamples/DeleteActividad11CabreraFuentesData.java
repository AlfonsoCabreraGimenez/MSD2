/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteActividad11CabreraFuentesData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Lista_De_Reproduccion ldiagramaclasesbdLista_De_Reproduccion = diagramaclasesbd.Lista_De_ReproduccionDAO.loadLista_De_ReproduccionByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.Lista_De_ReproduccionDAO.delete(ldiagramaclasesbdLista_De_Reproduccion);
			diagramaclasesbd.Comentario ldiagramaclasesbdComentario = diagramaclasesbd.ComentarioDAO.loadComentarioByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.ComentarioDAO.delete(ldiagramaclasesbdComentario);
			diagramaclasesbd.Categoria ldiagramaclasesbdCategoria = diagramaclasesbd.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.CategoriaDAO.delete(ldiagramaclasesbdCategoria);
			diagramaclasesbd.Usuario ldiagramaclasesbdUsuario = diagramaclasesbd.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.UsuarioDAO.delete(ldiagramaclasesbdUsuario);
			diagramaclasesbd.Video ldiagramaclasesbdVideo = diagramaclasesbd.VideoDAO.loadVideoByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.VideoDAO.delete(ldiagramaclasesbdVideo);
			diagramaclasesbd.Registrado ldiagramaclasesbdRegistrado = diagramaclasesbd.RegistradoDAO.loadRegistradoByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.RegistradoDAO.delete(ldiagramaclasesbdRegistrado);
			diagramaclasesbd.Administrador ldiagramaclasesbdAdministrador = diagramaclasesbd.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			diagramaclasesbd.AdministradorDAO.delete(ldiagramaclasesbdAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteActividad11CabreraFuentesData deleteActividad11CabreraFuentesData = new DeleteActividad11CabreraFuentesData();
			try {
				deleteActividad11CabreraFuentesData.deleteTestData();
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
