package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Convocatoria;
import pe.edu.upc.demo.repositories.IConvocatoriaRepository;
import pe.edu.upc.demo.serviceinterface.IConvocatoriaService;

@Service
public class ConvocatoriaServiceImpl implements IConvocatoriaService{

	@Autowired
	private IConvocatoriaRepository convocatoriaRepository;
	
	@Override
	public void insert(Convocatoria conv) {
		// TODO Auto-generated method stub
		convocatoriaRepository.save(conv);
	}

	@Override
	public List<Convocatoria> list() {
		// TODO Auto-generated method stub
		return convocatoriaRepository.findAll();
	}

	@Override
	public void delete(int idConv) {
		// TODO Auto-generated method stub
		convocatoriaRepository.deleteById(idConv);
	}

	@Override
	public Optional<Convocatoria> listId(int idConv) {
		// TODO Auto-generated method stub
		return convocatoriaRepository.findById(idConv);
	}

	@Override
	public void update(Convocatoria conv) {
		// TODO Auto-generated method stub
		convocatoriaRepository.save(conv);
	}

}