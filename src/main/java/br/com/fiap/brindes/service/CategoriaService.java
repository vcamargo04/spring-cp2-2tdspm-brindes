package br.com.fiap.brindes.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.CategoriaRequest;
import br.com.fiap.brindes.dto.CategoriaResponse;
import br.com.fiap.brindes.entity.Categoria;
import br.com.fiap.brindes.repository.CategoriaRepository;

@Service
public class CategoriaService implements ServiceDTO<Categoria, CategoriaRequest, CategoriaResponse> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Collection<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Collection<Categoria> findAll(Example<Categoria> example) {
        return categoriaRepository.findAll(example);
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria toEntity(CategoriaRequest dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        return categoria;
    }

    @Override
    public CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public CategoriaResponse criarCategoria(CategoriaRequest request) {
        Categoria categoria = toEntity(request);
        categoria = save(categoria);
        return toResponse(categoria);
    }

    public CategoriaResponse getCategoriaByExample(CategoriaRequest request) {
        Categoria categoriaExample = toEntity(request);
        Example<Categoria> example = Example.of(categoriaExample);
        Categoria categoria = categoriaRepository.findOne(example)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return toResponse(categoria);
    }

    public CategoriaResponse buscarCategoriaPorId(Long id) {
        Categoria categoria = findById(id);
        return toResponse(categoria);
    }
}
