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
			diagramaclasesbd.Lista_De_Reproduccion ldiagramaclasesbdLista_De_Reproduccion = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : videos, videoUltimos, videoMasMegusta, video, es_propietario_de
			diagramaclasesbd.Lista_De_ReproduccionDAO.save(ldiagramaclasesbdLista_De_Reproduccion);
			diagramaclasesbd.Comentario ldiagramaclasesbdComentario = diagramaclasesbd.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : video, usuarioComentario
			diagramaclasesbd.ComentarioDAO.save(ldiagramaclasesbdComentario);
			diagramaclasesbd.Categoria ldiagramaclasesbdCategoria = diagramaclasesbd.CategoriaDAO.createCategoria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : video, edad
			diagramaclasesbd.CategoriaDAO.save(ldiagramaclasesbdCategoria);
			diagramaclasesbd.Usuario ldiagramaclasesbdUsuario = diagramaclasesbd.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : es_escrito, suscriptores, otros_usuario, historial, propiedad_de, me_gusta, propiedad_video_de, suscripciones, es_suscriptor, usuario
			diagramaclasesbd.UsuarioDAO.save(ldiagramaclasesbdUsuario);
			diagramaclasesbd.Video ldiagramaclasesbdVideo = diagramaclasesbd.VideoDAO.createVideo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : usuarios, comentario, megusta, visualizaciones, es_propietario, lista_rep, ultimos, mas_gusta, relacionados, usuarioHistorial, usuario, categoria
			diagramaclasesbd.VideoDAO.save(ldiagramaclasesbdVideo);
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
