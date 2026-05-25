package zencash_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zencash_backend.model.Transacao;
import zencash_backend.repository.TransacaoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    // LISTAR TODAS
    public List<Transacao> listarTodas() {
        return repository.findAllByOrderByIdAsc();
    }

    // BUSCAR POR ID
    public Optional<Transacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // SALVAR
    public Transacao salvar(Transacao transacao) {
        return repository.save(transacao);
    }

    // DELETAR
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}