package br.com.fiap.brindes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.brindes.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
