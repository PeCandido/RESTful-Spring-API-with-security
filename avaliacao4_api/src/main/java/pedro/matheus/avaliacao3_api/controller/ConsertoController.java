package pedro.matheus.avaliacao3_api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pedro.matheus.avaliacao3_api.conserto.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto conserto, UriComponentsBuilder uriBuilder) {
        var newconserto = new Conserto(conserto);
        repository.save(newconserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(newconserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(newconserto));
    }

    @GetMapping
    public ResponseEntity listar(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping
    @RequestMapping("algunsdados")
    public ResponseEntity listarAtivos(
            @PageableDefault(size = 10, sort={"entrada", "saida"}) Pageable paginacao){

        var pagina = repository.findAllByAtivoTrue(paginacao).map(DadosListagemConserto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);

        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        else return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarinformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
