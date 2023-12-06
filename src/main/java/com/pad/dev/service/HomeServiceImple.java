package com.pad.dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.VO.boardVO.BoardVO;
// import com.pad.dev.dao.HomeDaoImple;
import com.pad.dev.dao.HomeDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeServiceImple implements HomeService {
    private final HomeDao hm;

    public List<BoardVO> getBoardList() {
        System.out.println("Service");
        List<BoardVO> boardList = hm.getBoardList();
        return boardList;
    }
}
