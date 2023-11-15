package nn.notepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class NotepadApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotepadApplication.class, args);
    }

}
