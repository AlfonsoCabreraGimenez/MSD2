package diagramaclasesbd;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

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

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Categoria cate = diagramaclasesbd.CategoriaDAO.getCategoriaByORMID(1);
			diagramaclasesbd.Registrado r = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(aID);
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.createVideo();
			
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			video.setUrl(aUrl);
			video.setFechaCreacion(aFechaCreacion);
			
			video.setCategoria(cate);
			video.setUsuario_video(r);
			diagramaclasesbd.RegistradoDAO.save(r);
			diagramaclasesbd.CategoriaDAO.save(cate);
			diagramaclasesbd.VideoDAO.save(video);
			
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}

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

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura) throws PersistentException {
	
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			//diagramaclasesbd.Categoria cate = diagramaclasesbd.CategoriaDAO.getCategoriaByORMID(1);

			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
			
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			
			/*video.setCategoria(cate);
			video.setUsuario_video(r);
			diagramaclasesbd.RegistradoDAO.save(r);
			diagramaclasesbd.CategoriaDAO.save(cate);
			*/
			diagramaclasesbd.VideoDAO.save(video);
			
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}

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

	public void eliminarVideoListaReproduccion(int aID) {
		throw new UnsupportedOperationException();
	}
}