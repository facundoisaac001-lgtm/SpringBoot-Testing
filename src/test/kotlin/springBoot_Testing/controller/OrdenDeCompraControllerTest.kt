package springBoot_Testing.service.controller

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(OrdenDeCompraController::class)
class OrdenDeCompraControllerTest(
    private val mockMvc: MockMvc
) : BehaviorSpec({

    Given("un cliente realiza una petición HTTP GET para obtener el total de la orden") {
        When("consulta el endpoint /api/ordenes/total") {
            Then("el controlador debe responder con estado 200 OK y el JSON del total") {
                mockMvc.get("/api/ordenes/total")
                    .andExpect {
                        status { isOk() }
                        jsonPath("$.total") { value(120) }
                    }
            }
        }
    }
})
