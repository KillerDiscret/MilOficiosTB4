package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Empleado;

public interface IEmpleadoService {

	public void insert(Empleado empl);
	
	public List<Empleado> list();
	
	public void delete (int idEmpl);
	
	Optional<Empleado> ListId(int idEmpl);
	
	public void update(Empleado empl);
}
