/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author chrismoran
 */
@SpringBootApplication
public class ManifestApplication {
    
    public static void main(String[] args) {

        SpringApplication.run(ManifestApplication.class, args);

        System.out.println("CBP Air Manifest Service Started Successfully!!!");
        System.out.println("Test Using Swagger :  http://localhost:8080/api/v1/air/swagger-ui.html");
    }
    
}
