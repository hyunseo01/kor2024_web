package day65.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.BoardRepository;
import day65.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    // [1] 내가 쓴글 전체 조회
    public List<BoardDto> myBoardList(int mno ){
        // 1. mno 의 회원 엔티티를 찾는다.
        // Optional 클래스 : null 값을 포함 할수 있는 객체
        // 특징 : Null 값을  안전하게 유무 판단
        // 주요메소드 :
        // 1. isPresent() : 값 존재 여부 판단 함수
        // 2. get() : Optional 객체가 갖고 있는 값 반환 함수
        // 사용처 : JPA의 findById() 함수의 반환 타입
        Optional<MemberEntity> optionalMember = memberRepository.findById( mno );
        if( optionalMember.isPresent() ) { // 만약에 findById함수로 찾은 mno의 엔티티가 존재하면
            MemberEntity entity = optionalMember.get(); // Optional 객체에서 엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();

            // 3. 모든 게시물 엔티티를 DTO로 변환
            // 방법1 , 일반 for문
            /*
            List<BoardDto> list = new ArrayList<>();
            for( int index = 0 ; index <= boardEntityList.size() - 1 ; index++ ){
                // 0부터 게시물엔티티리스트의 마지막 인덱스 까지
                BoardEntity boardEntity = boardEntityList.get(index); // index번째 엔티티 호출
                BoardDto boardDto = boardEntity.toDto();// 엔티티 dto로 변환
                list.add( boardDto ); // dto를 리스트에 저장
            }// for end
            */
            // 방법2  , forEach( 반복변수 -> { 실행문; } )    , -> JAVA방법 / => JS방법
            /*
            List<BoardDto> list = new ArrayList<>();
            boardEntityList.forEach( boardEntity -> {
                list.add( boardEntity.toDto() );
            } );
            */
            // 방법3 , .stream().map( 타입 :: 실행함수명 ).collect( Collectors.반환할컬렉션타입 );
            List<BoardDto> list = boardEntityList.stream()
                    .map( BoardEntity :: toDto )
                    .collect(Collectors.toList() ); // 반환타입

            return list;

        } // if end
        return null;
    } // f end
    @Autowired BoardRepository boardRepository;

    @Transactional
    //2. 게시물 작성, 양뱡향 관계일떄
    public boolean myBoardWriter(BoardDto boardDto){
        int loginMno = 1; //1번 회원이 로그인된 상태일 떄

        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);
        if (optionalMember.isPresent()==false){
            return false;
        }
        MemberEntity memberEntity = optionalMember.get();
        BoardEntity boardEntity = boardDto.toEntity();
        boardEntity.setMemberEntity(memberEntity);
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        if (saveEntity.getBno()>0){
            return true;
        }
        return false;
    }

} // c end