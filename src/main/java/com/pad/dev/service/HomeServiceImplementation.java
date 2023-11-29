package com.pad.dev.service;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.HomeDaoImplementaion;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeServiceImplementation implements HomeService {
    public final HomeDaoImplementaion hd;
}
