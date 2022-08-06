import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Postman_EchoTest {
    @Test
    public void shouldSendTheRequestBody() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Test") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Test"))
        ;
    }

    @Test
    public void shouldSendTheRequestBody1() {
        // Given - When - Then
        given()
                .baseUri("https://postman-echo.com")
                .body("id:7")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("id:7"))
        ;
    }
}
