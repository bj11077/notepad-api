package nn.notepad.common;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Slf4j
@Component
public class InitRunner implements CommandLineRunner {

    @Value("${file.save-path}")
    private String path;

    @Override
    public void run(String... args) throws Exception {
        log.info("commandLine Runner");
        File directory = new File(path);
        if(directory.exists()){
            log.info("save path already exist");
        }else{
            log.info("save path mkdirs");
            directory.mkdirs();
        }

    }

}
