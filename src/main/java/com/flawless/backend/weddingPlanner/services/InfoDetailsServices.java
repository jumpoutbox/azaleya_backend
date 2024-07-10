package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.dto.InfoDetailsDTO;
import com.flawless.backend.weddingPlanner.entites.InfoDetails;
import com.flawless.backend.weddingPlanner.repository.InfoDetailsRepository;
import com.flawless.backend.weddingPlanner.services.exception.DataBaseException;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InfoDetailsServices {
    @Autowired
    private InfoDetailsRepository infoDetailsRepository;
    @Autowired
    private AuthorizationService authService;

    @Transactional(readOnly = true)
    public List<InfoDetailsDTO> findAll(){
        List<InfoDetails> list = infoDetailsRepository.findAll();
        return list.stream().map(x -> new InfoDetailsDTO(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public InfoDetailsDTO findById(String id){
        Optional<InfoDetails> obj = infoDetailsRepository.findById(id);
        InfoDetails entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found!"));
        return new InfoDetailsDTO(entity, entity.getUser());
    }
    @Transactional
    public InfoDetailsDTO insert(InfoDetailsDTO dto) {
        InfoDetails entity = new InfoDetails();
        entity.setDataCasamento(dto.getDataCasamento());
        entity.setUser(authService.authenticated());
        entity = infoDetailsRepository.save(entity);
        return new InfoDetailsDTO(entity);
    }
    @Transactional
    public InfoDetailsDTO update(String id, InfoDetailsDTO dto) {
        try{
            InfoDetails entity = infoDetailsRepository.getReferenceById(id);
            entity.setDataCasamento(dto.getDataCasamento());
            entity = infoDetailsRepository.save(entity);
            return new InfoDetailsDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found "+ id);
        }
    }

    @Transactional
    public void delete(String id) {
        try {
            infoDetailsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found "+id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade!");
        }
    }
}
