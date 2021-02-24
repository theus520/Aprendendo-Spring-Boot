package com.matheusrabelo.mr.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusrabelo.mr.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository< Pagamento, Integer> {

	
}
