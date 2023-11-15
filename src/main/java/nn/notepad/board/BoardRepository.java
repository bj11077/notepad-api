package nn.notepad.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findByTitleLike(String title);

    Page<Board> findByTitleLike(String title, Pageable page);


}
