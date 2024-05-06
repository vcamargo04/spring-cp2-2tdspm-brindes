package br.com.fiap.brindes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.brindes.dto.LojaRequest;
import br.com.fiap.brindes.dto.LojaResponse;
import br.com.fiap.brindes.dto.ProdutoRequest;
import br.com.fiap.brindes.service.LojaService;

@RestController
@RequestMapping("/lojas")
public class LojaResource {

    @Autowired
    private LojaService lojaService;

    @PostMapping
    public ResponseEntity<LojaResponse> criarLoja(@RequestBody LojaRequest request) {
        LojaResponse response = lojaService.criarLoja(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<LojaResponse> getLojaByExample(@RequestBody LojaRequest request) {
        LojaResponse response = lojaService.getLojaByExample(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LojaResponse> buscarLojaPorId(@PathVariable Long id) {
        LojaResponse response = lojaService.buscarLojaPorId(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/produtos-comercializados")
    public ResponseEntity<Void> adicionarProdutoComercializado(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        lojaService.adicionarProdutoComercializado(id, produtoRequest);
        return ResponseEntity.ok().build();
    }
}
