package br.com.ada.users.user.service.impl;
import br.com.ada.users.user.model.dto.UserDTO;
import br.com.ada.users.user.model.entity.User;
import br.com.ada.users.user.model.mapper.UserMapper;
import br.com.ada.users.user.repository.UserRepository;
import br.com.ada.users.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public List<UserDTO> findAll() {
        return mapper.parseListDTO(repository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return mapper.parseDTO(user);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public UserDTO create(UserDTO entity) {
        User user = mapper.parseEntity(entity);
        user.setId(null);
        repository.save(user);
        return mapper.parseDTO(user);
    }

    @Override
    public UserDTO edit(Long id, UserDTO entity) {
        if (repository.existsById(id)) {
            User user = mapper.parseEntity(entity);
            user.setId(id);
            user = repository.save(user);
            return mapper.parseDTO(user);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }
}
