/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateActividad11CabreraFuentesData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Categoria ldiagramaclasesbdCategoria = diagramaclasesbd.CategoriaDAO.createCategoria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : videos, edad
			diagramaclasesbd.CategoriaDAO.save(ldiagramaclasesbdCategoria);
			diagramaclasesbd.Video ldiagramaclasesbdVideo = diagramaclasesbd.VideoDAO.createVideo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : comentarios, usuario_historial, megusta, visualizaciones, categoria, lista_rep, mas_gusta, ultimos, relacionados, usuarios, es_propietario, usuario
			diagramaclasesbd.VideoDAO.save(ldiagramaclasesbdVideo);
			diagramaclasesbd.Lista_De_Reproduccion ldiagramaclasesbdLista_De_Reproduccion = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : videosRel, videos_ultimos, video_masmegusta, videos_rep, es_propietario_lista
			diagramaclasesbd.Lista_De_ReproduccionDAO.save(ldiagramaclasesbdLista_De_Reproduccion);
			diagramaclasesbd.Comentario ldiagramaclasesbdComentario = diagramaclasesbd.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : video_coment, usuario_comentario
			diagramaclasesbd.ComentarioDAO.save(ldiagramaclasesbdComentario);
			diagramaclasesbd.Usuario ldiagramaclasesbdUsuario = diagramaclasesbd.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : usuario_suscriptores, suscripciones, suscriptores, usuario_sucripciones, es_escrito, propiedad_de, otros_usuarios, propiedad_video_de, historial, me_gusta, visitas, isAdmin
			diagramaclasesbd.UsuarioDAO.save(ldiagramaclasesbdUsuario);
			diagramaclasesbd.Registrado ldiagramaclasesbdRegistrado = diagramaclasesbd.RegistradoDAO.createRegistrado();
			// Initialize the properties of the persistent object here
			diagramaclasesbd.RegistradoDAO.save(ldiagramaclasesbdRegistrado);
			diagramaclasesbd.Administrador ldiagramaclasesbdAdministrador = diagramaclasesbd.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			diagramaclasesbd.AdministradorDAO.save(ldiagramaclasesbdAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateActividad11CabreraFuentesData createActividad11CabreraFuentesData = new CreateActividad11CabreraFuentesData();
			try {
				createActividad11CabreraFuentesData.createTestData();
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
