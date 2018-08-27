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
			List<Usuario> usuarios = UsuarioDAO.queryUsuario(null, null);
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
				diagramaclasesbd.Registrado r = diagramaclasesbd.RegistradoDAO.createRegistrado();
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
	public List<diagramaclasesbd.Registrado> buscar(String buscador) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Registrado> lista = null;
		ArrayList<diagramaclasesbd.Registrado> resultado = new ArrayList<diagramaclasesbd.Registrado>();
		try {
			lista = RegistradoDAO.queryRegistrado(null, null);
			for(diagramaclasesbd.Registrado u : lista){
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
			Usuario regis = UsuarioDAO.getUsuarioByORMID(aID);
			//Quitamos enlaces con comentarios y borramos
			for(Object com : regis.es_escrito.getCollection()) {
				Comentario coment = (Comentario) com;
				Video v = coment.getVideo();
				v.comentarios.remove(coment);
				regis.es_escrito.remove(coment);
				ComentarioDAO.delete(coment);
			}
			//Quitamos enlaces con videos y borramos
			for(Object video : regis.prop_video_de.getCollection())	{
				Video v = (Video) video;
				for(Object comentario : v.comentarios.getCollection()) {
					Comentario c = (Comentario) comentario;
					v.comentarios.remove(c);
				}
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
				for(Object videoLista : listaR.video.getCollection()) {
					Video vl = (Video) videoLista;
					listaR.video.remove(vl);
				}
				regis.prop_de.remove(listaR);
				Lista_De_ReproduccionDAO.delete(listaR);
			}
			//Quitar suscripciones y suscriptores
			List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
			for(Usuario usuario: usuarios){
				if(usuario.suscripciones.contains(regis)) {
					usuario.suscripciones.remove(regis);
				}
				if(usuario.suscriptores.contains(regis)) {
					usuario.suscriptores.contains(regis);
				}
			}
			UsuarioDAO.delete(regis);

			
			//UsuarioDAO.delete(u);
			
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