package nn.notepad.board;

import lombok.RequiredArgsConstructor;
import nn.notepad.common.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService service;

    @GetMapping
    public Response<List<BoardDto>> getList(){
        return new Response<>(true,service.getList());
    }

    @GetMapping("/{id}")
    public Response<BoardDto> getById(@PathVariable Long id){
        return new Response<>(true,service.getOne(id));
    }

    @PostMapping
    public Response<Boolean> save(@RequestBody BoardDto dto){
        service.save(dto);
        return new Response<>(true,true);
    }


    @PutMapping
    public Response<Boolean> modify(@RequestBody BoardDto dto){
        service.save(dto);
        return new Response<>(true,true);
    }

}
