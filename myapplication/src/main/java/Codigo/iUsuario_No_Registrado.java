package Codigo;

import java.util.Date;
import java.util.List;
public interface iUsuario_No_Registrado {

	public List cargar_Videos_Masmegusta();

	public List cargar_Videos_Ultimos();

	public boolean iniciarSesion(String aUser, String aPass);

	public void registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar);

	public void nuevaPass(String aPass, String aRepPass);

	public List buscar(TipoBusqueda aTipoBusqueda);

	public void regeneracionPass(String aEmail);

	public Usuario2 cargarDatosUsuario(int aID);

	public Video2 cargarDatosVideo(int aID);

	public List cargar_Videos_Subidos(int aID);

	public List cargar_Lista_Reproduccion(int aID);

	public List cargar_Videos_ListaReproduccion(int aID);

	public List cargar_Lista_Suscriptores(int aID);

	public List cargar_Lista_Suscripciones(int aID);
}