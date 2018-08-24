package diagramaclasesbd;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import diagramaclasesbd.Administrador;
import Codigo.Usuario2;
import Codigo.Video2;

public class BD_Administradores {
	public BD_Principal _bd_prin_admin;
	public Vector<Administrador> _contiene_admin = new Vector<Administrador>();

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public Usuario cargarDatosUsuario(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		Usuario user = null;
		try {
			user = UsuarioDAO.getUsuarioByORMID(aID);	
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
		return user;
	}

	public Video2 cargarDatosVideo(int aID) {
		throw new UnsupportedOperationException();
	}
	public void registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Administrador ad = diagramaclasesbd.AdministradorDAO.createAdministrador();
			ad.setNombre(aNombre);
			ad.setApellido1(aApellido1);
			ad.setApellido2(aApellido2);
			ad.setFechaN(fechaFinal);
			ad.setApodo(aApodo);
			ad.setAvatar(aAvatar);
			ad.setEmail(aEmail);
			ad.setPassword(aPass);
			ad.setIsAdmin(true);
			
			diagramaclasesbd.AdministradorDAO.save(ad);
			t.commit();
		}catch (Exception e) {
				t.rollback();
			}
		}
		
	
	public List cargarUsuarioAdmin() throws PersistentException {
		List listado = null;
		//Metodo para cargar todos los administradores
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			listado = AdministradorDAO.queryAdministrador(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return listado;
	}

	/*public void eliminarUsuario(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Registrado regis = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(aID);
			//Registrado regis = (Registrado) u;
			
			//Quitamos enlaces con comentarios y borramos
			for(Object com : regis.es_escrito.getCollection())
			{
				Comentario coment = (Comentario) com;
				Video v = coment.getVideo();
				v.comentarios.remove(coment);
				regis.es_escrito.remove(coment);
				ComentarioDAO.delete(coment);
			}
			//Quitamos enlaces con videos y borramos
			for(Object video : regis.prop_video_de.getCollection())
			{
				Video v = (Video) video;
				v.comentarios.clear();
				for(Object listaR : v.lista_de_Reproduccion.getCollection())
				{
					Lista_De_Reproduccion listaDR = (Lista_De_Reproduccion) listaR;
					listaDR.video.remove(v);
				}
				regis.prop_video_de.remove(v);
				VideoDAO.delete(v);
			}
			
			//Quitamos enlaces con listas y borramos
			for(Object lista : regis.prop_de.getCollection())
			{
				Lista_De_Reproduccion listaR = (Lista_De_Reproduccion) lista;
				listaR.video.clear();
				regis.prop_de.remove(listaR);
				Lista_De_ReproduccionDAO.delete(listaR);
			}
			//Quitar suscripciones y suscriptores
			regis.suscripciones.clear();
			regis.suscriptores.clear();
			
			RegistradoDAO.delete(regis);

			
			//UsuarioDAO.delete(u);
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}*/
}
