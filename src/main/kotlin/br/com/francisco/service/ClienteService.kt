package br.com.francisco.service

import br.com.francisco.model.Cliente
import br.com.francisco.persistence.ClienteRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton

@Singleton
class ClienteService(
    private val clienteRepository: ClienteRepository
) {

    fun create(veiculo: Cliente): Cliente {
        try {
            return clienteRepository.save(veiculo);
        } catch (e : Exception){
            throw e;
        }
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).orElseThrow();
    }

    fun findAll(): List<Cliente> {
        return clienteRepository.findAll();
    }

    fun delete(id: Long) {
        try {
            val veiculo: Cliente = clienteRepository.findById(id).get();
            clienteRepository.delete(veiculo);
        }
        catch (e : Exception) {
            if(e.message?.contains("No value present") == true){
                throw HttpStatusException(HttpStatus.NOT_FOUND,"Cliente nao encontrado")
            }
            else{
                throw HttpStatusException(HttpStatus.BAD_GATEWAY,"Verifique o log para mais informacoes")
            }
        }
    }
}