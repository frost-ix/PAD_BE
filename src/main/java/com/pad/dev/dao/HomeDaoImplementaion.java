package com.pad.dev.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HomeDaoImplementaion implements HomeDao {
    private final SqlSession session;

}
