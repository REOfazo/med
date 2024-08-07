package infinitygalaxy1001.uz.infinitygalaxy1001.service;

import infinitygalaxy1001.uz.infinitygalaxy1001.entity.Users;
import infinitygalaxy1001.uz.infinitygalaxy1001.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Users> getAllUsers() {
        return repository.findAll();
    }
    public Users getOneUser(Long id) {
        return repository.getOne(id);
    }
    public void save(Users users) {
        repository.save(users);
    }
}
