package springBoot_Testing.service.controller

import com.example.demo.Item              // <-- Importa la clase Item
import com.example.demo.OrdenDeCompra     // <-- Importa la clase OrdenDeCompra
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ordenes")
class OrdenDeCompraController {

    @GetMapping("/total")
    fun obtenerTotal(): Map<String, Int> {
        val orden = OrdenDeCompra()
        orden.agregarItem(Item("Un producto", 100))
        orden.agregarItem(Item("Manteca", 20))

        return mapOf("total" to orden.calcularTotal())
    }
}
