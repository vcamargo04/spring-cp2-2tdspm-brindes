package br.com.fiap.brindes.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.LojaRequest;
import br.com.fiap.brindes.dto.LojaResponse;
import br.com.fiap.brindes.dto.ProdutoRequest;
import br.com.fiap.brindes.dto.ProdutoResponse;
import br.com.fiap.brindes.entity.Loja;
import br.com.fiap.brindes.entity.Produto;
import br.com.fiap.brindes.repository.LojaRepository;

@Service
public class LojaService implements ServiceDTO<Loja, LojaRequest, LojaResponse> {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public Collection<Loja> findAll() {
        return lojaRepository.findAll();
    }

    @Override
    public Collection<Loja> findAll(Example<Loja> example) {
        return lojaRepository.findAll(example);
    }

    @Override
    public Loja findById(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
    }

    @Override
    public Loja save(Loja loja) {
        return lojaRepository.save(loja);
    }

    @Override
    public Loja toEntity(LojaRequest dto) {
        Loja loja = new Loja();
        loja.setNome(dto.getNome());
        return loja;
    }

    @Override
    public LojaResponse toResponse(Loja loja) {
        return new LojaResponse(loja.getId(), loja.getNome());
    }

    public LojaResponse criarLoja(LojaRequest request) {
        Loja loja = toEntity(request);
        loja = save(loja);
        return toResponse(loja);
    }

    public LojaResponse getLojaByExample(LojaRequest request) {
        Loja lojaExample = toEntity(request);
        Example<Loja> example = Example.of(lojaExample);
        Loja loja = lojaRepository.findOne(example)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        return toResponse(loja);
    }

    public LojaResponse buscarLojaPorId(Long id) {
        Loja loja = findById(id);
        return toResponse(loja);
    }

    public void adicionarProdutoComercializado(Long id, ProdutoRequest produtoRequest) {
        Loja loja = findById(id);
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        
        produto.setCategoriaId(produtoRequest.getCategoriaId());
        loja.adicionarProduto(produto);
        save(loja);
    }

    public List<ProdutoResponse> getProdutosComercializados(Long id) {
        Loja loja = findById(id);
        return loja.getProdutos().stream()
                .map(produto -> new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoriaId()))
                .collect(Collectors.toList());
    }
}
