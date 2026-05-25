package zencash_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zencash_backend.model.Investimento;
import zencash_backend.repository.InvestimentoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository repository;

    public List<Investimento> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Optional<Investimento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Investimento salvar(Investimento investimento) {
        return repository.save(investimento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}