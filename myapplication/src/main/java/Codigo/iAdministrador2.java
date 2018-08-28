package Codigo;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public interface iAdministrador2 extends iUsuario_Registrado {

	public List<Registrado> buscar(String aNombre);

	public boolean crearCategoria(String aCategoria, int aEdad);

	public void eliminarUsuario(int aID);

	public int registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar);

	public List<Administrador> cargarUsuarioAdmin();
	
}