package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.TipoNotificacion;
import pe.edu.upc.demo.repositories.ITipoNotificacionRepository;
import pe.edu.upc.demo.serviceinterface.ITipoNotificacionService;

@Service
public class TipoNotificacionServiceImpl implements ITipoNotificacionService{

	@Autowired
	private ITipoNotificacionRepository tipoNotificacionRepository;
	
	@Override
	public void insert(TipoNotificacion tipn) {
		// TODO Auto-generated method stub
		tipoNotificacionRepository.save(tipn);
	}

	@Override
	public List<TipoNotificacion> list() {
		// TODO Auto-generated method stub
		return tipoNotificacionRepository.findAll();
	}

	@Override
	public void delete(int idTipn) {
		// TODO Auto-generated method stub
		tipoNotificacionRepository.deleteById(idTipn);
	}

	@Override
	public Optional<TipoNotificacion> listId(int idTipn) {
		// TODO Auto-generated method stub
		return tipoNotificacionRepository.findById(idTipn);
	}

	@Override
	public void update(TipoNotificacion tipn) {
		// TODO Auto-generated method stub
		tipoNotificacionRepository.save(tipn);
	}

}
