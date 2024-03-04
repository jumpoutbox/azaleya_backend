package com.flawless.backend.ecommerce.services;

import com.flawless.backend.ecommerce.Repository.ImagesRepository;
import com.flawless.backend.ecommerce.dto.ImagesDTO;
import com.flawless.backend.ecommerce.entities.Images;
import com.flawless.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ImagesServices {
    @Autowired
    ImagesRepository repository;

    @Transactional(readOnly = true)
    public Page<ImagesDTO> findall(PageRequest pageRequest){
        Page<Images> list = repository.findAll(pageRequest);
        return list.map(x->new ImagesDTO(x));
    }
    @Transactional(readOnly = true)
    public ImagesDTO findById(String id){
        Optional<Images> findId =repository.findById(id);
        Images entity = findId.orElseThrow(()->new ResourceNotFoundException("Erro ao prcurar"));
        return new ImagesDTO(entity);
    }
    @Transactional
    public ImagesDTO saveImage(ImagesDTO imagesDTO){
        Images entity = new Images();
        entity.setUrl(imagesDTO.getUrl());
        entity=repository.save(entity);
        return new ImagesDTO(entity);
    }
    @Transactional
    public ImagesDTO updateImages(String id, ImagesDTO dto){
        try{
            Images entity=repository.getReferenceById(id);
            entity.setUrl(dto.getUrl());
            entity=repository.save(entity);
            return new ImagesDTO(entity);
        }catch (Exception e){
            throw new ResourceNotFoundException("Erro ao encontrar a img esclhida");
        }
    }
    @Transactional
    public void deleteImg(String id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Naõ podes deletar uma imagem que nao existite");
        }
    }
}
