package diagramaclasesbd;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import diagramaclasesbd.Categoria;

public class BD_Categorias {
	public BD_Principal _bd_prin_categ;
	//public Vector<Categoria> _contiene_categ = new Vector<Categoria>();

	public List<diagramaclasesbd.Categoria> cargarCategorias() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Categoria> listaCategorias = null;
		try {
			listaCategorias = CategoriaDAO.queryCategoria(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return listaCategorias;
	}

	public void crearCategoria(String aCategoria, int aEdad) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Categoria c = diagramaclasesbd.CategoriaDAO.createCategoria();
			c.setNombre(aCategoria);
			c.setEdad(aEdad);
			diagramaclasesbd.CategoriaDAO.save(c);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}

	}
}