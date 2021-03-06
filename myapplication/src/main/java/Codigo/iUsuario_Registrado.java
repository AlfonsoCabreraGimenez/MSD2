package Codigo;

import java.util.Date;
import java.util.List;

public interface iUsuario_Registrado {

	public void anadirAListaRep(int aID);

	public void borrarLista(int aID);

	public void borrarVideo(int aID);

	public List buscar(TipoBusqueda aTipoBusqueda);

	public List buscarVideo(String aTitulo);

	public void cancelarSuscripcion(int aID);

	public List cargar_Videos_Historial(int aID);

	public List cargar_Videos_Relacionados(int aID);

	public List cargar_Videos_Suscriptores(int aID);

	public void cargarAvatar(int aID);

	public List cargarCategorias();

	public Usuario2 cargarDatosUsuario(int aID);

	public Video2 cargarDatosVideo(int aID);

	public List cargarListaComentarios(int aID);

	public void crearListaRep(String aTitulo, List aVideo);

	public void darMegusta(int aID);

	public void descargarVideo(int aID);

	public void eliminarComentario(int aID);

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, String aAvatar);

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura);

	public void quitarMegusta(int aID);

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aEtiqueta, String aDescripcion, String aUrl, String aCategoria);

	public void suscribirse(int aID);

	public void escribirComentario(String aCadena, int aID);

	public void eliminarVideoListaReproduccion(int aID);
}