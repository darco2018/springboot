package cloud.javacoder.car.sbtesting;

import cloud.javacoder.car.sbtesting.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // goes with starter-web

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // support for Junit4; alias for @SpringJUnit4ClassRunner

// bootstrao test with SpringBoot; load app.props
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    // happy path test for integration, as opoosed to Controlelr test which will also test unhappy path

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCar_returnsCarDetails() throws Exception{
        //arr

        //act
        ResponseEntity<Car> res = restTemplate.getForEntity("/car/prius", Car.class);

        //ass
        // AssertJ - fluent assertions java library
        // <groupId>org.assertj</groupId>
        //  <artifactId>assertj-core</artifactId>
        //org.junit.jupiter.api.Assertions.assertThat()
        org.assertj.core.api.Assertions
                .assertThat(res.getStatusCode())
                .isEqualTo(org.springframework.http.HttpStatus.OK);

        org.assertj.core.api.Assertions
                .assertThat(res.getBody().getName()).isEqualTo("prius");

        org.assertj.core.api.Assertions
                .assertThat(res.getBody().getType()).isEqualTo("hybrid");

        // as() is used to describe the test and will be shown before the error message
        //assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
    }
}
