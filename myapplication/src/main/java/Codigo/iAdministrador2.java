package Codigo;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

public interface iAdministrador2 extends iUsuario_Registrado {

	public List buscarUsuario(String aNombre);

	public void crearCategoria(String aCategoria, int aEdad);

	public void eliminarUsuario(int aID);

	public void registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException;

}