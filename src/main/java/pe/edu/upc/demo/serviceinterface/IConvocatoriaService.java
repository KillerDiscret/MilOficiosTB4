package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Convocatoria;

public interface IConvocatoriaService {
	
	public void insert(Convocatoria conv);

	public List<Convocatoria> list();

	public void delete(int idConv);

	Optional<Convocatoria> listId(int idConv);

	public void update(Convocatoria conv);

}