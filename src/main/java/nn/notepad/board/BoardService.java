package nn.notepad.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    @Value("${file.save-path}")
    private String path;


    public List<BoardDto> getList(String keyword){
        List<Board> result = StringUtils.hasText(keyword) ? repository.findByTitleLike(keyword) : repository.findAll();
        return result.stream().map(BoardDto::new).toList();
    }

    public BoardDto getOne(Long id)  {
        BoardDto boardDto = new BoardDto(repository.findById(id).get());

        String filePath = String.join(File.separator,path,String.valueOf(id));

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            boardDto.setContent(sb.toString());
            sb.setLength(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return boardDto;
    }

    public void save(BoardDto dto){
        Board entity = dto.toEntity();
        Board save = repository.save(entity);

        String savePath = String.join("/",path,save.getId()+"");
        File file = new File(savePath);
        if(file.exists()){
            file.delete();
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(dto.getContent());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
