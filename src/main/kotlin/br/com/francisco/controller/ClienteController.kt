package br.com.francisco.controller

import br.com.francisco.model.Cliente
import br.com.francisco.service.ClienteService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*


@Controller("/cliente")
class ClienteController(
    private val clienteService: ClienteService
) {

    @Post
    fun create (@Body cliente: Cliente): HttpResponse<Cliente>{
        return HttpResponse.created(clienteService.create(cliente))
    }

    @Get("/{id}")
    fun findById(@PathVariable id : Long) : HttpResponse<Cliente> {
       return HttpResponse.ok(clienteService.findById(id))
    }

    @Get()
    fun findAll() : HttpResponse<List<Cliente>> {
        return HttpResponse.ok(clienteService.findAll())
    }

    @Delete("/{id}")
    fun delete(@PathVariable id : Long) : HttpResponse<Cliente> {
        clienteService.delete(id)
        return HttpResponse.noContent()
    }
}