package br.com.francisco.persistence

import br.com.francisco.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository : JpaRepository<Cliente,Long>