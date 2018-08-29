package diagramaclasesbd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mysql.fabric.xmlrpc.base.Array;
import com.vaadin.ui.UI;

import diagramaclasesbd.Registrado;
import Codigo.Pag_Inicio_R;
import Codigo.TipoBusqueda;
import Codigo.Usuario2;
import GY.MyUI;

public class BD_Registrados {
	public BD_Principal _bd_prin_regis;
	public Vector<Registrado> _contiene_regis = new Vector<Registrado>();

	public int iniciarSesion(String aUser, String aPass) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		int inicioOk = -1;
		try {
			for(Registrado reg : Arrays.asList(RegistradoDAO.listRegistradoByQuery(null, null))) {
				if((reg.getApodo().equals(aUser) || reg.getEmail().equals(aUser))
						&& (reg.getPassword().equals(aPass))) {
					inicioOk = 0;
					UI.getCurrent().getSession().setAttribute("usuario", reg);
				}
			}
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return inicioOk;
	}

	public int registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		int resReg = 1;
		try {
			List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
			for(Usuario user : usuarios) {
				if(user.getApodo().equals(aApodo)) {
					resReg = -1;
					break;
				}
				if(user.getEmail().equals(aEmail)) {
					resReg = 0;
					break;
				}
			}
			if(resReg == 1) {
				Registrado r = RegistradoDAO.createRegistrado();
				r.setNombre(aNombre);
				r.setApellido1(aApellido1);
				r.setApellido2(aApellido2);
				r.setFechaN(aFechaN);
				r.setApodo(aApodo);
				r.setAvatar(aAvatar);
				r.setEmail(aEmail);
				r.setPassword(aPass);
				diagramaclasesbd.RegistradoDAO.save(r);
				t.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resReg;
	}

	public void nuevaPass(String aPass, String aRepPass) {
		throw new UnsupportedOperationException();
	}
	public List<Usuario> buscar(String buscador) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Usuario> lista = null;
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		try {
			lista = UsuarioDAO.queryUsuario(null, null);
			for(Usuario u : lista){
				if(u.getApodo().contains(buscador)) {
					resultado.add(u);
				}
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resultado;
	}
	public List buscar(TipoBusqueda aTipoBusqueda) {
		throw new UnsupportedOperationException();
	}

	public void cargarAvatar(int aID) {
		throw new UnsupportedOperationException();
	}

	public void regeneracionPass(String aEmail) {
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
//////////////////////////////////
	public void eliminarUsuario(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = UsuarioDAO.getUsuarioByORMID(aID);
			for(Video vid : user.prop_video_de.toArray()) {
				Video video= VideoDAO.getVideoByORMID(vid.getORMID());
				List<Lista_De_Reproduccion> listas = Arrays.asList(Lista_De_ReproduccionDAO.listLista_De_ReproduccionByQuery(null, null));
				List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
				List<Comentario> comentarios = Arrays.asList(ComentarioDAO.listComentarioByQuery(null, null));
				for(Lista_De_Reproduccion lista : listas) {
					if(lista.video.contains(video)) {
						lista.video.remove(video);
					}
					Lista_De_ReproduccionDAO.save(lista);
				}
				for(Usuario usuario : usuarios) {
					if(usuario.me_gusta.contains(video)) {
						usuario.me_gusta.remove(video);
					}
					if(usuario.prop_video_de.contains(video)) {
						usuario.prop_video_de.remove(video);
					}
					UsuarioDAO.save(usuario);
				}
				for(Comentario coment : comentarios) {
					if(coment.getVideo().equals(video)) {
						ComentarioDAO.delete(coment);
					}
				}
				VideoDAO.delete(video);
			}
			for(Usuario u : UsuarioDAO.listUsuarioByQuery(null, null)) {
				if(u.suscripciones.contains(user)) {
					u.suscripciones.remove(user);
				}
				if(u.suscriptores.contains(user)) {
					u.suscriptores.remove(user);
				}
				UsuarioDAO.save(u);
			}
			for(Comentario coment : ComentarioDAO.listComentarioByQuery(null, null)) {
				if(coment.getUsuario_comentario().equals(user)) {
					for(Video video:VideoDAO.listVideoByQuery(null, null)) {
						if(video.comentarios.contains(coment)) {
							video.comentarios.remove(coment);
							VideoDAO.save(video);
						}
							
					}
					ComentarioDAO.delete(coment);
				}
			}
			for (Lista_De_Reproduccion lista : Lista_De_ReproduccionDAO.listLista_De_ReproduccionByQuery(null, null)) {
				if (lista.getEs_prop_lista().getID() == (user.getID())) {
					for (Video video : VideoDAO.listVideoByQuery(null, null)) {
						if (video.lista_de_Reproduccion.contains(lista)) {
							video.lista_de_Reproduccion.remove(lista);
							VideoDAO.save(video);
						}
					}
				}
				Lista_De_ReproduccionDAO.deleteAndDissociate(lista);
				Lista_De_ReproduccionDAO.delete(lista);
			}
			
			UsuarioDAO.deleteAndDissociate(user);
			UsuarioDAO.delete(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List cargar_Lista_Suscriptores(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Suscripciones(int aID) {
		throw new UnsupportedOperationException();
	}

	public int modificarDatos(int idUser, String aNombre, String aApellido1, String aApellido2, String aApodo, String aEmail, String aAvatar) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		int resMod = 1;
		try {
			List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
			for(Usuario user : usuarios) {
				if(user.getApodo().equals(aApodo) && (user.getID() != idUser)) {
					resMod = -1;
					break;
				}
				if(user.getEmail().equals(aEmail) && (user.getID() != idUser)) {
					resMod = 0;
					break;
				}
			}
			if(resMod == 1) {
				Usuario u = UsuarioDAO.getUsuarioByORMID(idUser);
				u.setNombre(aNombre);
				u.setApellido1(aApellido1);
				u.setApellido2(aApellido2);
				u.setApodo(aApodo);
				u.setAvatar(aAvatar);
				u.setEmail(aEmail);
				UsuarioDAO.save(u);
				t.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resMod;
	}

	public List buscarUsuario(String aNombre) {
		throw new UnsupportedOperationException();
	}

	public void suscribirse(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(user == null) {
				user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
			}
			Usuario user1 = UsuarioDAO.getUsuarioByORMID(user.getID());
			Usuario user2 = UsuarioDAO.getUsuarioByORMID(aID);
			user1.suscripciones.add(user2);
			user2.suscriptores.add(user1);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void cancelarSuscripcion(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(user == null) {
				user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
			}
			Usuario user1 = UsuarioDAO.getUsuarioByORMID(user.getID());
			Usuario user2 = UsuarioDAO.getUsuarioByORMID(aID);
			user1.suscripciones.remove(user2);
			user2.suscriptores.remove(user1);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
	
	public List<Registrado> cargarUsuariosRegis() throws PersistentException {
		List<Registrado> listado = null;
		//Metodo para cargar todos los registrados
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
		
			listado = RegistradoDAO.queryRegistrado(null, null);
	
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return listado;
	}
	
	public boolean comprobarSuscripcion(int ID) throws PersistentException {
		boolean suscrito = false;
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(user == null) {
				user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
			}
			Usuario userIniciado = UsuarioDAO.getUsuarioByORMID(user.getID());
			Usuario userVisitado = UsuarioDAO.getUsuarioByORMID(ID);
			if(userIniciado.suscripciones.contains(userVisitado)) {
				suscrito = true;
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return suscrito;
	}
	
	public void aumentarVisitas(int idUser) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = UsuarioDAO.getUsuarioByORMID(idUser);
			user.setVisitas(user.getVisitas()+1);
			UsuarioDAO.save(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}