package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Users;
import pe.edu.upc.demo.repositories.IUsersRepository;
import pe.edu.upc.demo.serviceinterface.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{

	@Autowired
	private IUsersRepository usersRepository;
	
	
	@Override
	public void insert(Users users) {
		
		usersRepository.save(users);
		
	}

	@Override
	public List<Users> list() {
		
		return usersRepository.findAll();
	}

	@Override
	public void delete(Long idUsers) {
		
		usersRepository.deleteById(idUsers);
		
	}

	@Override
	public Optional<Users> listId(Long idUsers) {
		
		return usersRepository.findById(idUsers);
	}

	@Override
	public void update(Users users) {
	
		usersRepository.save(users);
	}

	
	
	
	
	
}
