package diagramaclasesbd;

import java.util.Vector;
import diagramaclasesbd.Administrador;
import Codigo.Usuario2;
import Codigo.Video2;

public class BD_Administradores {
	public BD_Principal _bd_prin_admin;
	public Vector<Administrador> _contiene_admin = new Vector<Administrador>();

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public Usuario2 cargarDatosUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public Video2 cargarDatosVideo(int aID) {
		throw new UnsupportedOperationException();
	}
}