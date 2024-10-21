package no.digdir.accessrequestapi.integration

import no.digdir.accessrequestapi.utils.ApiTestContext
import no.digdir.accessrequestapi.utils.apiGet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(
    properties = ["spring.profiles.active=test"],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
)
@ContextConfiguration()
@Tag("integration")
class StatusTest : ApiTestContext() {
    @Test
    fun ping() {
        val response = apiGet(port, "/ping", null)
        assertEquals(HttpStatus.OK.value(), response["status"])
    }

    @Test
    fun ready() {
        val response = apiGet(port, "/ready", null)
        assertEquals(HttpStatus.OK.value(), response["status"])
    }
}
