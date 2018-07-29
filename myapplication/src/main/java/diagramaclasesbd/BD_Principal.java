package diagramaclasesbd;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import Codigo.TipoBusqueda;
import Codigo.Usuario2;
import Codigo.Video2;
import Codigo.iUsuario_Registrado;
import Codigo.iAdministrador2;
import Codigo.iUsuario_No_Registrado;

public class BD_Principal implements iUsuario_Registrado, iAdministrador2, iUsuario_No_Registrado {
	public BD_Categorias categoria = new BD_Categorias();
	public BD_Videos videos = new BD_Videos();
	public BD_Listas_De_Reproduccion listas = new BD_Listas_De_Reproduccion();
	public BD_Comentarios _bd_coment;
	public BD_Registrados registrados = new BD_Registrados();
	public BD_Administradores admin = new BD_Administradores();

	public void anadirAListaRep(int aID) {
		try {
			listas.anadirAListaRep(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}

	public void borrarLista(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarVideo(int aID) {
		throw new UnsupportedOperationException();
	}
	public List<diagramaclasesbd.Registrado> buscar(String buscador) {
		try {
			return registrados.buscar(buscador);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<diagramaclasesbd.Video> buscar(String buscador, TipoBusqueda aTipoBusqueda) {
		try {
			return videos.buscar(buscador, aTipoBusqueda);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public List<diagramaclasesbd.Categoria> cargarCategorias() {
		try {
			return categoria.cargarCategorias();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Usuario2 cargarDatosUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public diagramaclasesbd.Video cargarDatosVideo(int aID) {
		diagramaclasesbd.Video video = null;
		try {
			video = videos.cargarDatosVideo(aID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return video;
	}

	public List cargarListaComentarios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearListaRep(String aTitulo, List aVideo) {
		try {
			listas.crearListaRep(aTitulo, null);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void darMegusta(int aID) {
		
		try {
			videos.darMegusta(aID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void descargarVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public void eliminarComentario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatos(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aEmail, String aPass, String aNuevaPass, String aRepPass, String aAvatar) {
		try {
			registrados.modificarDatos(aNombre, aApellido1, aApellido2, null, aApodo, aEmail, null, aNuevaPass, aRepPass, null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura) {
		try {
			videos.modificarDatosVideo(aTitulo, aCategoria, aEtiqueta, aDescripcion, aMiniatura);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quitarMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion) {
		try {
			videos.subirVideo(aID, aMiniatura, aTitulo, aCategoria, aEtiqueta, aDescripcion, aUrl, aFechaCreacion);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	
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
		try {
			categoria.crearCategoria(aCategoria, aEdad);
		}catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarUsuario(int aID) {
		try {
			registrados.eliminarUsuario(aID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta() {
		try {
			return videos.cargar_Videos_Masmegusta();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<diagramaclasesbd.Video> cargar_Videos_Ultimos() {
		try {
			return videos.cargar_Videos_Ultimos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean iniciarSesion(String aUser, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aNombre, String aApellido1, String aApellido2, Date aFechaN, String aApodo, String aPass, String aRepPass, String aEmail, String aAvatar) {
		try {
			registrados.registrarse(aNombre, aApellido1, aApellido2, aFechaN, aApodo, aPass, aRepPass, aEmail, aAvatar);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void registrarAdministrador(String aNombre, String aApellido1, String aApellido2, Date fechaFinal, String aApodo,
			String aPass, String aRepPass, String aEmail, String aAvatar) throws PersistentException {
			admin.registrarAdministrador(aNombre, aApellido1, aApellido2, fechaFinal, aApodo, aPass, aRepPass, aEmail, aAvatar);
	}
	
	public List cargarUsuarioAdmin(){
		
		try {
			return admin.cargarUsuarioAdmin();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Registrado> cargarUsuariosRegis(){
		
		try {
			return registrados.cargarUsuariosRegis();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean videoPropio(int id) {
		try {
			videos.videoPropio(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List cargarVideosPropios(int ID) {
		//Va a la bbdd de videos para cargar los videos de ese user
		try {
			videos.cargarVideosPropios(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}