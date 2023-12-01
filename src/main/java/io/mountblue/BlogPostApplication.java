package io.mountblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication()
@Service
public class BlogPostApplication {

<<<<<<< HEAD
=======
	public String PORT = System.getenv("PORT");
>>>>>>> 98365a2 (final commit)
	public static void main(String[] args) {
		SpringApplication.run(BlogPostApplication.class, args);
	}

}
