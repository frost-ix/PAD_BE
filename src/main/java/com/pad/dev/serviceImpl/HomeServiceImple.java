package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.HomeDao;
import com.pad.dev.service.HomeService;
import com.pad.dev.vo.boardVO.BoardVO;

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
