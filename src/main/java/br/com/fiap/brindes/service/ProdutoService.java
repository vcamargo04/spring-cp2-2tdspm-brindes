package br.com.fiap.brindes.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.ProdutoRequest;
import br.com.fiap.brindes.dto.ProdutoResponse;
import br.com.fiap.brindes.entity.Produto;
import br.com.fiap.brindes.repository.ProdutoRepository;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Collection<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Collection<Produto> findAll(Example<Produto> example) {
        return produtoRepository.findAll(example);
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto toEntity(ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setCategoriaId(dto.getCategoriaId());
        return produto;
    }

    @Override
    public ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoriaId());
    }

    public ProdutoResponse criarProduto(ProdutoRequest request) {
        Produto produto = toEntity(request);
        produto = save(produto);
        return toResponse(produto);
    }

    public ProdutoResponse getProdutoByExample(ProdutoRequest request) {
        Produto produtoExample = toEntity(request);
        Example<Produto> example = Example.of(produtoExample);
        Produto produto = produtoRepository.findOne(example)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toResponse(produto);
    }

    public ProdutoResponse buscarProdutoPorId(Long id) {
        Produto produto = findById(id);
        return toResponse(produto);
    }
    
    // Vinicius de Araújo Camargo rm99494
}
