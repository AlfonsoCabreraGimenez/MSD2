/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListActividad11CabreraFuentesData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Categoria...");
		diagramaclasesbd.Categoria[] diagramaclasesbdCategorias = diagramaclasesbd.CategoriaDAO.listCategoriaByQuery(null, null);
		int length = Math.min(diagramaclasesbdCategorias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdCategorias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Video...");
		diagramaclasesbd.Video[] diagramaclasesbdVideos = diagramaclasesbd.VideoDAO.listVideoByQuery(null, null);
		length = Math.min(diagramaclasesbdVideos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdVideos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Lista_De_Reproduccion...");
		diagramaclasesbd.Lista_De_Reproduccion[] diagramaclasesbdLista_De_Reproduccions = diagramaclasesbd.Lista_De_ReproduccionDAO.listLista_De_ReproduccionByQuery(null, null);
		length = Math.min(diagramaclasesbdLista_De_Reproduccions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdLista_De_Reproduccions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Comentario...");
		diagramaclasesbd.Comentario[] diagramaclasesbdComentarios = diagramaclasesbd.ComentarioDAO.listComentarioByQuery(null, null);
		length = Math.min(diagramaclasesbdComentarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdComentarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		diagramaclasesbd.Usuario[] diagramaclasesbdUsuarios = diagramaclasesbd.UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(diagramaclasesbdUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Registrado...");
		diagramaclasesbd.Registrado[] diagramaclasesbdRegistrados = diagramaclasesbd.RegistradoDAO.listRegistradoByQuery(null, null);
		length = Math.min(diagramaclasesbdRegistrados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdRegistrados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		diagramaclasesbd.Administrador[] diagramaclasesbdAdministradors = diagramaclasesbd.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(diagramaclasesbdAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(diagramaclasesbdAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Categoria by Criteria...");
		diagramaclasesbd.CategoriaCriteria ldiagramaclasesbdCategoriaCriteria = new diagramaclasesbd.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdCategoriaCriteria.ID.eq();
		ldiagramaclasesbdCategoriaCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Categoria[] diagramaclasesbdCategorias = ldiagramaclasesbdCategoriaCriteria.listCategoria();
		int length =diagramaclasesbdCategorias== null ? 0 : Math.min(diagramaclasesbdCategorias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdCategorias[i]);
		}
		System.out.println(length + " Categoria record(s) retrieved."); 
		
		System.out.println("Listing Video by Criteria...");
		diagramaclasesbd.VideoCriteria ldiagramaclasesbdVideoCriteria = new diagramaclasesbd.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdVideoCriteria.ID.eq();
		ldiagramaclasesbdVideoCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Video[] diagramaclasesbdVideos = ldiagramaclasesbdVideoCriteria.listVideo();
		length =diagramaclasesbdVideos== null ? 0 : Math.min(diagramaclasesbdVideos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdVideos[i]);
		}
		System.out.println(length + " Video record(s) retrieved."); 
		
		System.out.println("Listing Lista_De_Reproduccion by Criteria...");
		diagramaclasesbd.Lista_De_ReproduccionCriteria ldiagramaclasesbdLista_De_ReproduccionCriteria = new diagramaclasesbd.Lista_De_ReproduccionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdLista_De_ReproduccionCriteria.ID.eq();
		ldiagramaclasesbdLista_De_ReproduccionCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Lista_De_Reproduccion[] diagramaclasesbdLista_De_Reproduccions = ldiagramaclasesbdLista_De_ReproduccionCriteria.listLista_De_Reproduccion();
		length =diagramaclasesbdLista_De_Reproduccions== null ? 0 : Math.min(diagramaclasesbdLista_De_Reproduccions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdLista_De_Reproduccions[i]);
		}
		System.out.println(length + " Lista_De_Reproduccion record(s) retrieved."); 
		
		System.out.println("Listing Comentario by Criteria...");
		diagramaclasesbd.ComentarioCriteria ldiagramaclasesbdComentarioCriteria = new diagramaclasesbd.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdComentarioCriteria.ID.eq();
		ldiagramaclasesbdComentarioCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Comentario[] diagramaclasesbdComentarios = ldiagramaclasesbdComentarioCriteria.listComentario();
		length =diagramaclasesbdComentarios== null ? 0 : Math.min(diagramaclasesbdComentarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdComentarios[i]);
		}
		System.out.println(length + " Comentario record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		diagramaclasesbd.UsuarioCriteria ldiagramaclasesbdUsuarioCriteria = new diagramaclasesbd.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdUsuarioCriteria.ID.eq();
		ldiagramaclasesbdUsuarioCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Usuario[] diagramaclasesbdUsuarios = ldiagramaclasesbdUsuarioCriteria.listUsuario();
		length =diagramaclasesbdUsuarios== null ? 0 : Math.min(diagramaclasesbdUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Registrado by Criteria...");
		diagramaclasesbd.RegistradoCriteria ldiagramaclasesbdRegistradoCriteria = new diagramaclasesbd.RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdRegistradoCriteria.ID.eq();
		ldiagramaclasesbdRegistradoCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Registrado[] diagramaclasesbdRegistrados = ldiagramaclasesbdRegistradoCriteria.listRegistrado();
		length =diagramaclasesbdRegistrados== null ? 0 : Math.min(diagramaclasesbdRegistrados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdRegistrados[i]);
		}
		System.out.println(length + " Registrado record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		diagramaclasesbd.AdministradorCriteria ldiagramaclasesbdAdministradorCriteria = new diagramaclasesbd.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldiagramaclasesbdAdministradorCriteria.ID.eq();
		ldiagramaclasesbdAdministradorCriteria.setMaxResults(ROW_COUNT);
		diagramaclasesbd.Administrador[] diagramaclasesbdAdministradors = ldiagramaclasesbdAdministradorCriteria.listAdministrador();
		length =diagramaclasesbdAdministradors== null ? 0 : Math.min(diagramaclasesbdAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(diagramaclasesbdAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListActividad11CabreraFuentesData listActividad11CabreraFuentesData = new ListActividad11CabreraFuentesData();
			try {
				listActividad11CabreraFuentesData.listTestData();
				//listActividad11CabreraFuentesData.listByCriteria();
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
