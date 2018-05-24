package diagramaclasesiu;

import diagramaclasesbd.Video;

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

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, Image aAvatar);

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, Image aMiniatura);

	public void quitarMegusta(int aID);

	public void subirVideo(int aID, Video aVideo, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion);

	public void suscribirse(int aID);

	public void escribirComentario(String aCadena, int aID);

	public void eliminarVideoListaReproduccion(int aID);
}