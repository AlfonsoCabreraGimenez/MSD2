package Codigo;

import java.util.Date;
import java.util.List;

import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;
public interface iUsuario_No_Registrado {

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta();

	public List<diagramaclasesbd.Video> cargar_Videos_Ultimos();

	public boolean iniciarSesion(String aUser, String aPass);

	public int registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar);

	public void nuevaPass(String aPass, String aRepPass);

	public List<diagramaclasesbd.Video> buscar(String buscador, TipoBusqueda aTipoBusqueda);
	
	public List<diagramaclasesbd.Registrado> buscar(String buscador);

	public void regeneracionPass(String aEmail);

	public Usuario cargarDatosUsuario(int aID);

	public diagramaclasesbd.Video cargarDatosVideo(int aID);

	public List cargar_Videos_Subidos(int aID);

	public List cargar_Lista_Reproduccion(int aID);

	public List<Video> cargar_Videos_ListaReproduccion(int aID);

	public List cargar_Lista_Suscriptores(int aID);

	public List cargar_Lista_Suscripciones(int aID);
	
	public void aumentarVisitas(int idUser);
	
	public void aumentarVisualizaciones(int idVideo);
}