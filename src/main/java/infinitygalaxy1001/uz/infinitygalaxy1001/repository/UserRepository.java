package infinitygalaxy1001.uz.infinitygalaxy1001.repository;

import infinitygalaxy1001.uz.infinitygalaxy1001.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
