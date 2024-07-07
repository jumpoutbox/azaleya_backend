package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.dto.MesasDTO;
import com.flawless.backend.weddingPlanner.entites.Mesas;
import com.flawless.backend.weddingPlanner.entites.Users;
import com.flawless.backend.weddingPlanner.repository.GuestRepository;
import com.flawless.backend.weddingPlanner.repository.MesasRepository;
import com.flawless.backend.weddingPlanner.repository.UsersRepository;
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
public class MesasServices {
    @Autowired
    MesasRepository repository;
    @Autowired
    GuestRepository guestRepository;

    @Autowired
    AuthorizationService authService;


    @Transactional(readOnly = true)
    public List<MesasDTO> findAll(){
        List<Mesas> list = repository.findAll();
        return list.stream().map(x -> new MesasDTO(x, x.getGuests(), x.getUser())).collect(Collectors.toList());
    }
   @Transactional(readOnly = true)
    public MesasDTO findById(String id) {
        Optional<Mesas> mesa = repository.findById(id);
        Mesas entity=mesa.orElseThrow(()->new ResourceNotFoundException("Mesa not found"));
        return new MesasDTO(entity);
    }
    @Transactional
    public MesasDTO insertMesa(MesasDTO mesa) {
        Mesas entity=new Mesas();
        copyDtoToEntity(mesa, entity);
        entity=repository.save(entity);
        return new MesasDTO(entity);
    }
    @Transactional
    public MesasDTO update(String id, MesasDTO mesa) {
        try {
            Mesas entity = repository.getReferenceById(id);
            copyDtoToEntity(mesa, entity);
            entity=repository.save(entity);
            return new MesasDTO(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found "+id);
        }
    }
    @Transactional
    public void delete(String id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found "+id);
        }catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade");
        }
    }

    private void copyDtoToEntity(MesasDTO dto, Mesas entity) {
        entity.setNome(dto.getNome());
        entity.setUser(authService.authenticated());
    }
}
