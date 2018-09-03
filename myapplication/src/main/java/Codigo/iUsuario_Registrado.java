package Codigo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import diagramaclasesbd.Comentario;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;
public interface iUsuario_Registrado {
	

	public boolean anadirAListaRep(int aID, int idLista);

	public void borrarLista(int aID);

	public void borrarVideo(int aID);

	public List<Video> buscar(String buscador, TipoBusqueda aTipoBusqueda);

	public void cancelarSuscripcion(int aID);

	public List<Video> cargar_Videos_Historial(int aID);

	public List<Video> cargar_Videos_Relacionados(int aID);

	public List<Video> cargar_Videos_Suscriptores(int aID);

	public List<diagramaclasesbd.Categoria> cargarCategorias();

	public Usuario cargarDatosUsuario(int aID);

	public diagramaclasesbd.Video cargarDatosVideo(int aID);

	public List<Comentario> cargarListaComentarios(int aID);

	public void crearListaRep(String aTitulo, List<Video> aVideo);

	public boolean darQuitarMegusta(int aID);

	public void eliminarComentario(int aID);

	public int modificarDatos(int idUser, String aNombre, String aApellido1, String aApellido2, String aApodo, String aEmail, String aAvatar);

	public void modificarDatosVideo(int idVideo, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura);

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion);

	public void suscribirse(int aID);

	public void escribirComentario(String aCadena, int aID);

	public boolean eliminarVideoListaReproduccion(int idLista , int idVideo);

	public boolean videoPropio(int idVideo, int iduser);

	public List<Lista_De_Reproduccion> cargarListaReproduccionPropia(int idUsuario);
	
	public List<Video> cargar_Videos_ListaReproduccion(int aID);
	
	public boolean comprobarSuscripcion(int ID);
	
	public void aumentarVisualizaciones(int idVideo);
	
	public void anadirHistorial(int idVideo);
}