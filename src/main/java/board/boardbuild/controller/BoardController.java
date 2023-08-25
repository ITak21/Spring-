package board.boardbuild.controller;

import board.boardbuild.controller.dto.BoardDTO;
import board.boardbuild.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private  final BoardService boardService;
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/")
    public String finAll(Model model) {
        //DB에서 전체 게시글 데이터를 가져와서 list.html에 보낸다
        List<BoardDTO> boardDTOList=boardService.finAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){ //경로상의 값을 가져올때는 pathvariable을 사용한다
        /*
        해당 게시글의 조회수를 하나 올리고
        게시글의 데이터를 가져와서 detail.html에 출력한다
         */
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "detail";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        //Long을 사용하는 이유는 Long은 wrapper type으로 long과 다르며 null값을 사용할 수 있어 id값이 제대로 입력됐는지 알 수 있다.
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
        return "update";

    }
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board", board);
        return "detail";
//        return "redirect:/board/"+boardDTO.getId(); 이렇게 사용할 시 수정할때도 조회수가 올라감
    }


}
