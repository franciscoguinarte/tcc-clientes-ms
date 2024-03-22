package br.com.francisco.service

import br.com.francisco.model.Veiculo
import br.com.francisco.persistence.VeiculoRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton

@Singleton
class VeiculoService(
    private val veiculoRepository: VeiculoRepository
) {

    fun create(veiculo: Veiculo): Veiculo {
        try {
            return veiculoRepository.save(veiculo);
        } catch (e : Exception){
            throw e;
        }
    }

    fun findById(id: Long): Veiculo {
        return veiculoRepository.findById(id).orElseThrow();
    }

    fun findAll(): List<Veiculo> {
        return veiculoRepository.findAll();
    }

    fun delete(id: Long) {
        try {
            val veiculo: Veiculo = veiculoRepository.findById(id).get();
            veiculoRepository.delete(veiculo);
        }
        catch (e : Exception) {
            if(e.message?.contains("No value present") == true){
                throw HttpStatusException(HttpStatus.NOT_FOUND,"Veiculo nao encontrado")
            }
            else{
                throw HttpStatusException(HttpStatus.BAD_GATEWAY,"Verifique o log para mais informacoes")
            }
        }
    }
}