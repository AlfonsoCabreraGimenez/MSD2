package diagramaclasesbd;

import java.util.Vector;
import diagramaclasesbd.Registrado;
import diagramaclasesiu.TipoBusqueda;
import diagramaclasesiu.Usuario2;

public class BD_Registrados {
	public BD_Principal _bd_prin_regis;
	public Vector<Registrado> _contiene_regis = new Vector<Registrado>();

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar) {
		throw new UnsupportedOperationException();
	}

	public void nuevaPass(String aPass, String aRepPass) {
		throw new UnsupportedOperationException();
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

	public Usuario2 cargarDatosUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Suscriptores(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Suscripciones(int aID) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, Image aAvatar) {
		throw new UnsupportedOperationException();
	}

	public List buscarUsuario(String aNombre) {
		throw new UnsupportedOperationException();
	}

	public void suscribirse(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cancelarSuscripcion(int aID) {
		throw new UnsupportedOperationException();
	}
}