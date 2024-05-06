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

import br.com.fiap.brindes.dto.ProdutoRequest;
import br.com.fiap.brindes.dto.ProdutoResponse;
import br.com.fiap.brindes.service.ProdutoService;

// Vinicius de Araujo Camargo - rm99494

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = produtoService.criarProduto(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ProdutoResponse> getProdutoByExample(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = produtoService.getProdutoByExample(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoResponse response = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(response);
    }
}
