package diagramaclasesiu;

public interface iAdministrador2 extends iUsuario_Registrado {

	public List buscarUsuario(String aNombre);

	public void crearCategoria(String aCategoria, int aEdad);

	public void eliminarUsuario(int aID);
}