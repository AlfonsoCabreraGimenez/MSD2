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

	public List buscarVideo(String aTitulo);

	public void cancelarSuscripcion(int aID);

	public List cargar_Videos_Historial(int aID);

	public List cargar_Videos_Relacionados(int aID);

	public List cargar_Videos_Suscriptores(int aID);

	public void cargarAvatar(int aID);

	public List<diagramaclasesbd.Categoria> cargarCategorias();

	public Usuario cargarDatosUsuario(int aID);

	public diagramaclasesbd.Video cargarDatosVideo(int aID);

	public List<Comentario> cargarListaComentarios(int aID);

	public void crearListaRep(String aTitulo, List<Video> aVideo);

	public boolean darQuitarMegusta(int aID);

	public void descargarVideo(int aID);

	public void eliminarComentario(int aID);

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, String aAvatar);

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura);

	public void quitarMegusta(int aID);

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion);

	public void suscribirse(int aID);

	public void escribirComentario(String aCadena, int aID);

	public void eliminarVideoListaReproduccion(int aID);

	public List<Registrado> cargarUsuariosRegis();

	public boolean videoPropio(int idVideo, int iduser);

	public List<Video> cargarVideosPropios(int ID);

	public List<Lista_De_Reproduccion> cargarListaReproduccionPropia(int idUsuario);
}