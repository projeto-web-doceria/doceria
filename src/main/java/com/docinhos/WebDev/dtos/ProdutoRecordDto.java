package com.docinhos.webdev.dtos;

import java.sql.Date;

public record ProdutoRecordDto( String nome,
                                String descricao, 
                                float preco, 
                                Date dtFabricacao, 
                                Date dtValidade) {
    
}
