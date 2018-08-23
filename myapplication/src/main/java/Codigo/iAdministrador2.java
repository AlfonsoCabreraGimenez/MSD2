package Codigo;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import diagramaclasesbd.Registrado;

public interface iAdministrador2 extends iUsuario_Registrado {

	public List<Registrado> buscar(String aNombre);

	public void crearCategoria(String aCategoria, int aEdad);

	public Boolean eliminarUsuario(int aID);

	public void registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException;

	public List<diagramaclasesbd.Administrador> cargarUsuarioAdmin();
	
}