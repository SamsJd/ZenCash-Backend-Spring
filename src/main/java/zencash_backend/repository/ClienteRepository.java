package zencash_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zencash_backend.model.Cliente;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByOrderByIdAsc();

}