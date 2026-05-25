package zencash_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zencash_backend.model.Investimento;
import zencash_backend.service.InvestimentoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    @GetMapping
    public List<Investimento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investimento> buscarPorId(@PathVariable Long id) {
        Optional<Investimento> investimento = service.buscarPorId(id);

        return investimento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Investimento> salvar(@RequestBody Investimento investimento) {
        Investimento novoInvestimento = service.salvar(investimento);
        return ResponseEntity.ok(novoInvestimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investimento> atualizar(
            @PathVariable Long id,
            @RequestBody Investimento investimento
    ) {
        Optional<Investimento> existente = service.buscarPorId(id);

        if (existente.isPresent()) {
            investimento.setId(id);
            Investimento atualizado = service.salvar(investimento);
            return ResponseEntity.ok(atualizado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Investimento> existente = service.buscarPorId(id);

        if (existente.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}