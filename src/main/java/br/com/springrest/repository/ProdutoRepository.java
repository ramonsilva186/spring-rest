package br.com.springrest.repository;

import br.com.springrest.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
