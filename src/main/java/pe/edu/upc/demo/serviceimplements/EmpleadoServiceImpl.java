package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Empleado;
import pe.edu.upc.demo.repositories.IEmpleadoRepository;
import pe.edu.upc.demo.serviceinterface.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Override
	public void insert(Empleado empl) {
		
		empleadoRepository.save(empl);
	}

	@Override
	public List<Empleado> list() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public void delete(int idEmpl) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(idEmpl);
	}

	@Override
	public Optional<Empleado> ListId(int idEmpl) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(idEmpl);
	}

	@Override
	public void update(Empleado empl) {
		// TODO Auto-generated method stub
		empleadoRepository.save(empl);
	}

	
	
}
