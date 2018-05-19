package diagramaclasesbd;

import java.util.List;
import java.util.Vector;
import diagramaclasesbd.Video;
import Codigo.TipoBusqueda;
import Codigo.Video2;

public class BD_Videos {
	public BD_Principal _bd_prin_videos;
	public Vector<Video> _contiene_videos = new Vector<Video>();

	public List cargar_Videos_Masmegusta() {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Ultimos() {
		throw new UnsupportedOperationException();
	}

	public List buscar(TipoBusqueda aTipoBusqueda) {
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

	public void subirVideo(int aID, Video aVideo, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Subidos(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_ListaReproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public Video2 cargarDatosVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura) {
		throw new UnsupportedOperationException();
	}

	public void darMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void quitarMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public List buscarVideo(String aTitulo) {
		throw new UnsupportedOperationException();
	}

	public void crearListaRep(String aTitulo, List aVideo) {
		throw new UnsupportedOperationException();
	}

	public void decargarVideo(int aID) {
		throw new UnsupportedOperationException();
	}
}