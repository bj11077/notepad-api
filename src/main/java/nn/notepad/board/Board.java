package nn.notepad.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @GeneratedValue
    @Id
    private Long id;

    private String title;

    @UpdateTimestamp
    private LocalDateTime regDate;



    @Builder
    public Board(Long id,String title, String regDate){
        this.id = Objects.nonNull(id)? id:null;
        this.title = title;
        this.regDate = Objects.nonNull(regDate)?LocalDateTime.parse(regDate,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")): null;
    }





}
