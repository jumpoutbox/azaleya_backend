package com.azaleya.backend.ecommerce.services;

import com.azaleya.backend.ecommerce.Repository.CategoriaRepository;
import com.azaleya.backend.ecommerce.Repository.ImagesRepository;
import com.azaleya.backend.ecommerce.Repository.ProdutosRepository;
import com.azaleya.backend.ecommerce.dto.ProdutoDTO;
import com.azaleya.backend.ecommerce.entities.Categoria;
import com.azaleya.backend.ecommerce.entities.Images;
import com.azaleya.backend.ecommerce.entities.Produtos;
import com.azaleya.backend.weddingPlanner.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutosServices {
    @Autowired ProdutosRepository repository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ImagesRepository imagesRepository;

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findPage(PageRequest pageRequest){
        Page<Produtos> list=repository.findAll(pageRequest);
        return list.map(x->new ProdutoDTO(x));
    }
    @Transactional(readOnly = true)
    public ProdutoDTO findByID(String id){
        Optional<Produtos> entity=repository.findById(id);
        Produtos objeto=entity.orElseThrow(()->new ResourceNotFoundException("Nao encontramos este produto"));
        return new ProdutoDTO(objeto,objeto.getCategoria(),objeto.getImages());
    }
    @Transactional
    public ProdutoDTO saveProduto(ProdutoDTO dto){
        Produtos entity = new Produtos();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        Categoria categoria = categoriaRepository.getReferenceById(dto.getCategoriaDTO().getId());
        entity.setCategoria(categoria);
        Images images = imagesRepository.getReferenceById(dto.getImagesDTO().getId());
        entity.setImages(images);
        repository.save(entity);
        return  new ProdutoDTO(entity);
    }
    @Transactional
    public ProdutoDTO updateProduto (ProdutoDTO dto){
        try{
            Produtos entity = new Produtos();
            entity.setNome(dto.getNome());
            entity.setDescricao(dto.getDescricao());
            entity.setPreco(dto.getPreco());
            /*Categoria categoria = categoriaRepository.getReferenceById(dto.getCategoriaDTO().getId());
            Images images= imagesRepository.getReferenceById(dto.getImagesDTO().getId());
            entity.setCategoria(categoria);
            entity.setImages(images);*/
            entity=repository.save(entity);
            return new ProdutoDTO(entity);
        }catch (Exception e){
            throw new ResourceNotFoundException("Erro ao atualizar");
        }
    }
    public void delete(String id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Naõ podes deletar uma imagem que nao existente");
        }
    }
}
