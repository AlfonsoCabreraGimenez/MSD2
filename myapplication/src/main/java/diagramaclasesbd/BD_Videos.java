package diagramaclasesbd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lVideosMgusta = null;
		ArrayList<Integer> megusta = new ArrayList<Integer>();
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		//int max = -1;
		//int pos = -1;
		//int cont = 0;
		try {
			lVideosMgusta = VideoDAO.queryVideo(null, null);
			for(diagramaclasesbd.Video v : lVideosMgusta){
				megusta.add(v.getMegusta());
			}
			while(!megusta.isEmpty()) {
				int  max = -1;
				int pos = -1;
				for(int i = 0 ; i < megusta.size();i++) {
					int actual=megusta.get(i);
					if(actual > max) {
						max = actual;
						pos=i;
					}
				}
				resultado.add(lVideosMgusta.get(pos));
				lVideosMgusta.remove(pos);
				megusta.remove(pos);
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resultado;
	}

	public List cargar_Videos_Ultimos() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lVideosUltimos = null;
		ArrayList<Date> ultimos = new ArrayList<Date>();
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		//int max = -1;
		//int pos = -1;
		//int cont = 0;
		try {
			lVideosUltimos = VideoDAO.queryVideo(null, null);
			for(diagramaclasesbd.Video v : lVideosUltimos){
				ultimos.add(v.getFechaCreacion());
			}
			while(!ultimos.isEmpty()) {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				Date max = formatoDelTexto.parse("0000-00-00");
				int pos = -1;
				for(int i = 0 ; i < ultimos.size();i++) {
					Date actual = ultimos.get(i);
					if(actual.compareTo(max) == 1) {
						max = actual;
						pos=i;
					}
				}
				resultado.add(lVideosUltimos.get(pos));
				lVideosUltimos.remove(pos);
				ultimos.remove(pos);
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
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
			//diagramaclasesbd.Categoria cate = diagramaclasesbd.CategoriaDAO.getCategoriaByORMID(1);
			diagramaclasesbd.Registrado r = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(aID);
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.createVideo();
			
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			video.setUrl(aUrl);
			video.setFechaCreacion(aFechaCreacion);
			diagramaclasesbd.Categoria cate=null;	
			//int idCat = -1;
			for(diagramaclasesbd.Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					//idCat = cat.getID();
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setUsuario_video(r);
			/*diagramaclasesbd.RegistradoDAO.save(r);
			diagramaclasesbd.CategoriaDAO.save(cate);*/
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
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
			diagramaclasesbd.Categoria cate=null;	
			for(diagramaclasesbd.Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
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