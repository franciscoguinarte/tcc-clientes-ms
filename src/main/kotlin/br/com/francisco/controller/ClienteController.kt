package br.com.francisco.controller

import br.com.francisco.model.Veiculo
import br.com.francisco.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*


@Controller("/cliente")
class ClienteController(
    private val veiculoService: VeiculoService
) {

    @Post
    fun create (@Body veiculo: Veiculo): HttpResponse<Veiculo>{
        return HttpResponse.created(veiculoService.create(veiculo))
    }

    @Get("/{id}")
    fun findById(@PathVariable id : Long) : HttpResponse<Veiculo> {
       return HttpResponse.ok(veiculoService.findById(id))
    }

    @Get()
    fun findAll() : HttpResponse<List<Veiculo>> {
        return HttpResponse.ok(veiculoService.findAll())
    }

    @Delete("/{id}")
    fun delete(@PathVariable id : Long) : HttpResponse<Veiculo> {
        veiculoService.delete(id)
        return HttpResponse.noContent()
    }
}