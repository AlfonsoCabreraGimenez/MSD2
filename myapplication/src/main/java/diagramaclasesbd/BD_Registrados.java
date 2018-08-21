package diagramaclasesbd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import diagramaclasesbd.Registrado;
import Codigo.TipoBusqueda;
import Codigo.Usuario2;

public class BD_Registrados {
	public BD_Principal _bd_prin_regis;
	public Vector<Registrado> _contiene_regis = new Vector<Registrado>();

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
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
			diagramaclasesbd.Registrado r = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(aID);
			/*HAY QUE BORRAR TAMBN LISTAS Y VIDEOS
			 * 
			 */
			r.prop_video_de.clear();
			r.prop_de.clear();
			RegistradoDAO.delete(r);
			
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

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, String aAvatar) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		Registrado r = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(registrado.getID());
		try {
			//Registrado r = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(registrado.getID());
			r.setNombre(aNombre);
			r.setApellido1(aApellido1);
			r.setApellido2(aApellido2);
			r.setApodo(aApodo);
			r.setAvatar(null);
			r.setEmail(aEmail);
			r.setPassword(aNuevaPass);
			
			diagramaclasesbd.RegistradoDAO.save(r);
			t.commit();
		} catch (PersistentException e) {
			t.rollback();
		}
	}

	public List buscarUsuario(String aNombre) {
		throw new UnsupportedOperationException();
	}

	public void suscribirse(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			Usuario user1 = UsuarioDAO.getUsuarioByORMID(registrado.getID());
			Usuario user2 = UsuarioDAO.getUsuarioByORMID(aID);
			user1.suscripciones.add(user2);
			user2.suscriptores.add(user1);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void cancelarSuscripcion(int aID) {
		throw new UnsupportedOperationException();
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
}