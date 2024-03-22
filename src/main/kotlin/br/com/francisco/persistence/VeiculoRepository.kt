package br.com.francisco.persistence

import br.com.francisco.model.Veiculo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface VeiculoRepository : JpaRepository<Veiculo,Long>{
}