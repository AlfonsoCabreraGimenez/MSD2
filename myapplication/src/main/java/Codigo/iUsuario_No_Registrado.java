package Codigo;

import java.util.Date;
import java.util.List;

import diagramaclasesbd.Comentario;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;
public interface iUsuario_No_Registrado {

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta();

	public List<diagramaclasesbd.Video> cargar_Videos_Ultimos();

	public int iniciarSesion(String aUser, String aPass);

	public int registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar);

	public boolean nuevaPass(String email, String codigo, String aPass);

	public List<diagramaclasesbd.Video> buscar(String buscador, TipoBusqueda aTipoBusqueda);
	
	public List<Usuario> buscar(String buscador);

	public boolean regeneracionPass(String aEmail);

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