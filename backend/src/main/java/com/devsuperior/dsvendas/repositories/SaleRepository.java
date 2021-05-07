package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessSumDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	//Quantia vendida agrupada por vendedor
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	//Quantidade de visitas e vendas concretizadas
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessSumDTO(obj.seller, SUM(obj.visited), "
			+ " SUM(obj.deals)) FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessSumDTO> successGroupedBySeller();
}
