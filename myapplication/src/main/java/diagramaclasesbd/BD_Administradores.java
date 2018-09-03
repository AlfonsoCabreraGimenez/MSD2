package diagramaclasesbd;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import diagramaclasesbd.Administrador;
import Codigo.Pag_Inicio_R;
import Codigo.Usuario2;
import Codigo.Video2;
import GY.MyUI;

public class BD_Administradores {
	public BD_Principal _bd_prin_admin;
	public Vector<Administrador> _contiene_admin = new Vector<Administrador>();

	public int iniciarSesion(String aUser, String aPass) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		int inicioOk = -1;
		try {
			for(Administrador adm : Arrays.asList(AdministradorDAO.listAdministradorByQuery(null, null))) {
				if((adm.getApodo().equals(aUser) || adm.getEmail().equals(aUser))
						&& (adm.getPassword().equals(aPass))) {
					inicioOk = 1;
					UI.getCurrent().getSession().setAttribute("admin", adm);
				}
			}
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return inicioOk;
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

	public int registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		int resCrearAd = 1;
		try {
			List<Administrador> admins = Arrays.asList(AdministradorDAO.listAdministradorByQuery(null, null));
			List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
			for(Usuario user : usuarios) {
				if(user.getApodo().equals(aApodo)) {
					resCrearAd = -1;
					break;
				}
				if(user.getEmail().equals(aEmail)) {
					resCrearAd = 0;
					break;
				}
			}
			if(resCrearAd == 1) {
				Administrador a = AdministradorDAO.createAdministrador();
				a.setNombre(aNombre);
				a.setApellido1(aApellido1);
				a.setApellido2(aApellido2);
				a.setFechaN(fechaFinal);
				a.setApodo(aApodo);
				a.setAvatar(aAvatar);
				a.setEmail(aEmail);
				a.setPassword(aPass);
				a.setIsAdmin(true);
				AdministradorDAO.save(a);
				t.commit();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resCrearAd;
	}	
	
	public List<Administrador> cargarUsuarioAdmin() throws PersistentException {
		List<Administrador> listado = null;
		//Metodo para cargar todos los administradores
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			listado = Arrays.asList(AdministradorDAO.listAdministradorByQuery(null, null));
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return listado;
	}
}
