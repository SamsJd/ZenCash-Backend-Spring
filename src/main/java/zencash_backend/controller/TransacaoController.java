package zencash_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zencash_backend.model.Transacao;
import zencash_backend.service.TransacaoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    // GET - LISTAR TODAS
    @GetMapping
    public List<Transacao> listarTodas() {
        return service.listarTodas();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        Optional<Transacao> transacao = service.buscarPorId(id);
        return transacao.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<Transacao> salvar(@RequestBody Transacao transacao) {
        Transacao novaTransacao = service.salvar(transacao);
        return ResponseEntity.ok(novaTransacao);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(
            @PathVariable Long id,
            @RequestBody Transacao transacao
    ) {
        Optional<Transacao> existente = service.buscarPorId(id);
        if (existente.isPresent()) {
            transacao.setId(id);
            Transacao atualizada = service.salvar(transacao);
            return ResponseEntity.ok(atualizada);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Transacao> existente = service.buscarPorId(id);
        if (existente.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}