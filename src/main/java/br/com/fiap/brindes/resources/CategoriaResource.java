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

import br.com.fiap.brindes.dto.CategoriaRequest;
import br.com.fiap.brindes.dto.CategoriaResponse;
import br.com.fiap.brindes.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarCategoria(@RequestBody CategoriaRequest request) {
        CategoriaResponse response = categoriaService.criarCategoria(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CategoriaResponse> getCategoriaByExample(@RequestBody CategoriaRequest request) {
        CategoriaResponse response = categoriaService.getCategoriaByExample(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable Long id) {
        CategoriaResponse response = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok(response);
    }
    
 // Vinicius de Araújo Camargo rm99494
}
