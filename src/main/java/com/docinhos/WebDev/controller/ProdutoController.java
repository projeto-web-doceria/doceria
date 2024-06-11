package com.docinhos.webdev.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import com.docinhos.webdev.Repositories.ProdutoRepository;
import com.docinhos.webdev.dtos.ProdutoRecordDto;
import com.docinhos.webdev.models.ProdutoModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProdutoController {
    
    @Autowired
    ProdutoRepository produtoProdutoRepository;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody @Validated ProdutoRecordDto produtoRecordDto){
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoRecordDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoProdutoRepository.save(produtoModel));
    }
}
