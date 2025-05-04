package com.homework.springBoot.service.impl;

import com.homework.springBoot.model.Television;
import com.homework.springBoot.repository.TelevisionRepository;
import com.homework.springBoot.service.TelevisionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TelevisionServiceImpl implements TelevisionService {

    private TelevisionRepository televisionRepository;

    @Autowired
    public void TelevisionRepository(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }
    @Override
    public List<Television> findAll() {
        return televisionRepository.findAll();
    }

    @Override
    public Television getTelevisionById (final Long id) {
        return televisionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Television not found"));

    }

    @Override
    public Television save(final Television newTelevision) {
        return televisionRepository.save(newTelevision);
    }

    @Override
    public Television update(final Television newInfo,
                          final Long id) {
        Television existingTelevision = getTelevisionById(id);
        existingTelevision.setPrice(newInfo.getPrice());
        return televisionRepository.save(existingTelevision);
    }

    @Override
    public void deleteById(final Long id) {
        televisionRepository.deleteById(id);
    }
}
