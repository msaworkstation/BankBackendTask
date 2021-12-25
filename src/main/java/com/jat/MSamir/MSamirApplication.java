package com.jat.MSamir;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class MSamirApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MSamirApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");


		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			RequestBody body = RequestBody.create(mediaType, "{\n    \"name\" : \"Mohamed"+c+"\"\n}");
			Request request = new Request.Builder()
					.url("http://localhost:8080/users")
					.method("POST", body)
					.addHeader("Accept", "application/json")
					.addHeader("Content-Type", "application/json")
					.build();
			client.newCall(request).execute();
		}

	}
}
