package diagramaclasesbd;

import java.util.Date;
import java.util.List;

import diagramaclasesiu.TipoBusqueda;
import diagramaclasesiu.Usuario2;
import diagramaclasesiu.Video2;
import diagramaclasesiu.iUsuario_Registrado;
import diagramaclasesiu.iAdministrador2;
import diagramaclasesiu.iUsuario_No_Registrado;

public class BD_Principal implements iUsuario_Registrado, iAdministrador2, iUsuario_No_Registrado {
	public BD_Categorias _bd_categ;
	public BD_Videos _bd_videos;
	public BD_Listas_De_Reproduccion _bd_listasrep;
	public BD_Comentarios _bd_coment;
	public BD_Registrados _bd_regis;
	public BD_Administradores _bd_admin;

	public void anadirAListaRep(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarLista(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public List buscar(TipoBusqueda aTipoBusqueda) {
		throw new UnsupportedOperationException();
	}

	public List buscarVideo(String aTitulo) {
		throw new UnsupportedOperationException();
	}

	public void cancelarSuscripcion(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Historial(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Relacionados(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Suscriptores(int aID) {
		throw new UnsupportedOperationException();
	}

	public void cargarAvatar(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargarCategorias() {
		throw new UnsupportedOperationException();
	}

	public Usuario2 cargarDatosUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public Video2 cargarDatosVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargarListaComentarios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearListaRep(String aTitulo, List aVideo) {
		throw new UnsupportedOperationException();
	}

	public void darMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void descargarVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public void eliminarComentario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, Image aAvatar) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, Image aMiniatura) {
		throw new UnsupportedOperationException();
	}

	public void quitarMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void subirVideo(int aID, Video aVideo, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion) {
		throw new UnsupportedOperationException();
	}

	public void suscribirse(int aID) {
		throw new UnsupportedOperationException();
	}

	public void escribirComentario(String aCadena, int aID) {
		throw new UnsupportedOperationException();
	}

	public void eliminarVideoListaReproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public List buscarUsuario(String aNombre) {
		throw new UnsupportedOperationException();
	}

	public void crearCategoria(String aCategoria, int aEdad) {
		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Masmegusta() {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Ultimos() {
		throw new UnsupportedOperationException();
	}

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar) {
		throw new UnsupportedOperationException();
	}

	public void nuevaPass(String aPass, String aRepPass) {
		throw new UnsupportedOperationException();
	}

	public void regeneracionPass(String aEmail) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Subidos(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Reproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_ListaReproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Suscriptores(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Lista_Suscripciones(int aID) {
		throw new UnsupportedOperationException();
	}
}