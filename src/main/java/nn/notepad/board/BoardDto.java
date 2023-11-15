package nn.notepad.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String regDate;

    public BoardDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.regDate = Objects.nonNull(entity.getRegDate())? entity.getRegDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")):null;
    }

    public Board toEntity(){
        return Board.builder().
                id(this.id)
                .title(this.title)
                .regDate(this.regDate)
                .build();
    }
}
