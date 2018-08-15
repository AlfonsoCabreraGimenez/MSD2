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

	public void eliminarUsuario(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Usuario u = diagramaclasesbd.UsuarioDAO.getUsuarioByORMID(aID);

			/*HAY QUE BORRAR TAMBN LISTAS Y VIDEOS
			 * 
			 */

			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
	}
}
