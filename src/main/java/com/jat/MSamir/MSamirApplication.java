package com.jat.MSamir;

import com.squareup.okhttp.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class MSamirApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MSamirApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            RequestBody body = RequestBody.create(mediaType, "{\n    \"name\" : \"Mohamed" + c + "\"\n}");
            Request request = new Request.Builder().url("http://localhost:8080/users").method("POST", body).addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").build();
            client.newCall(request).execute();
        }

        RequestBody body = RequestBody.create(mediaType, "{\n  \"accountType\": \"CURRENT\",\n  \"accountNumber\": 12345566,\n  \"balance\": 1231321321,\n  \"iban\": \"AL35202111090000000001234567\",\n  \"currency\": \"USD\"\n}");
        for (int i = 1; i < 7; i++) {
            Request request = new Request.Builder().url("http://localhost:8080/accounts/" + i).method("POST", body).addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").build();
            client.newCall(request).execute();
        }

        for (int i = 0; i < 3; i++) {
            RequestBody body1 = RequestBody.create(mediaType, "{\n  \"amount\": 222"+i+",\n  \"description\": \"TeData\"\n}");
            Request request = new Request.Builder().url("http://localhost:8080/statements/1").method("POST", body1).addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").build();
            client.newCall(request).execute();
        }

    }
}
