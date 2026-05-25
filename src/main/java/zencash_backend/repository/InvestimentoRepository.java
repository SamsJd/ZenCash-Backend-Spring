package zencash_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zencash_backend.model.Investimento;
import java.util.List;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

    List<Investimento> findAllByOrderByIdAsc();

}