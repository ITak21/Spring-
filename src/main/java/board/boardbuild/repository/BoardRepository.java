package board.boardbuild.repository;

import board.boardbuild.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //update board_table set board_hits=board_hits+1 where id=? mysql기준
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits= b.boardHits+1 where b.id =:id")
    void updateHits(@Param("id") Long id); //콜론(:)뒤에 id는 밑에 파람 id와 매칭된다 생각하면 됨
}
