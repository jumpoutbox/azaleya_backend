package com.azaleya.backend.weddingPlanner.services;

import com.azaleya.backend.weddingPlanner.dto.CheckListDTO;
import com.azaleya.backend.weddingPlanner.dto.GuestDTO;
import com.azaleya.backend.weddingPlanner.dto.MesasDTO;
import com.azaleya.backend.weddingPlanner.dto.UsersDTO;
import com.azaleya.backend.weddingPlanner.entites.CheckList;
import com.azaleya.backend.weddingPlanner.entites.Guest;
import com.azaleya.backend.weddingPlanner.entites.Mesas;
import com.azaleya.backend.weddingPlanner.entites.Users;
import com.azaleya.backend.weddingPlanner.repository.GuestRepository;
import com.azaleya.backend.weddingPlanner.repository.MesasRepository;
import com.azaleya.backend.weddingPlanner.repository.UsersRepository;
import com.azaleya.backend.weddingPlanner.services.exception.DataBaseException;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    UsersRepository userRepository;


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
            Mesas entity = repository.getOne(id);
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
        Users user = userRepository.getReferenceById(dto.getUser().getId());
        entity.setUser(user);
    }
}
