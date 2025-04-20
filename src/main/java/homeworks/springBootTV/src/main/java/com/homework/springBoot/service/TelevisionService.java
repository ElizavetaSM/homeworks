package com.homework.springBoot.service;

import com.homework.springBoot.model.Television;

import java.util.List;

public interface TelevisionService {
    List<Television> findAll ();
    Television getTelevisionById (Long id);
    Television save(Television television);
    Television update (Television newInfo, Long id);
    void deleteById(Long id);

}
