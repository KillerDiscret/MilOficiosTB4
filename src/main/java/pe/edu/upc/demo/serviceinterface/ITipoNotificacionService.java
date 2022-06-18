package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.TipoNotificacion;

public interface ITipoNotificacionService {

	public void insert(TipoNotificacion tipn);
	
	public List<TipoNotificacion> list();
	
	public void delete(int idTipn);
	
	Optional<TipoNotificacion> listId(int idTipn);
	
	public void update(TipoNotificacion tipn);
}
