package zencash_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zencash_backend.model.Transacao;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findAllByOrderByIdAsc();

}