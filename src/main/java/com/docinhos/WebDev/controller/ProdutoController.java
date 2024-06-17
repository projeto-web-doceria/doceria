package com.docinhos.webdev.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import com.docinhos.webdev.dtos.ProdutoRecordDto;
import com.docinhos.webdev.models.ProdutoModel;
import com.docinhos.webdev.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ProdutoController {
    
    @Autowired
    ProdutoRepository produtoProdutoRepository;

    // @PostMapping("/produtos/cadastro")
    // public ResponseEntity<ProdutoModel> salvarProduto(@ModelAttribute @Validated ProdutoRecordDto produtoRecordDto) {
    //     var produtoModel = new ProdutoModel();
    //     BeanUtils.copyProperties(produtoRecordDto, produtoModel);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(produtoProdutoRepository.save(produtoModel));
    // }

    @GetMapping("/criar")
    public String produtoCriaro(Model model) {
        ProdutoRecordDto produtoDto = new ProdutoRecordDto(null, null, 0, null, null);
        model.addAttribute("produtoDto", produtoDto);
        return "criado";
    }

    @PostMapping("/novoProduto")
    public String cadastrarProduto(@ModelAttribute ProdutoRecordDto produtoRecordDto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(produtoRecordDto.nome());
        produto.setDescricao(produtoRecordDto.descricao());
        produto.setPreco(produtoRecordDto.preco());
        produto.setDtFabricacao(produtoRecordDto.dtFabricacao());
        produto.setDtValidade(produtoRecordDto.dtValidade());   
        produtoProdutoRepository.save(produto);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/listarProdutos")
     public String getAllproducts(Model model) {
         List<ProdutoModel> produtos = produtoProdutoRepository.findAll();
         model.addAttribute("produto", produtos);
         return "listarProdutos";
     }

    @GetMapping("/produtos/{idProduto}")
    public ResponseEntity<Object> getOneProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        Optional<ProdutoModel> produto0 = produtoProdutoRepository.findById(idProduto);
        if (produto0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto0.get());
    }

    @PutMapping("produtos/{idProdutos}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "idProduto") UUID idProdutos,
            @RequestBody @Validated ProdutoRecordDto produtoRecordDto) {

        Optional<ProdutoModel> produto0 = produtoProdutoRepository.findById(idProdutos);
        if (produto0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Econtrado!!");
        }
        var produtoModel = produto0.get();
        BeanUtils.copyProperties(produtoRecordDto, produto0);
        return ResponseEntity.status(HttpStatus.OK).body(produtoProdutoRepository.save(produtoModel));
    }

    @DeleteMapping("/produtos/{idProduto}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        Optional<ProdutoModel> produto0 = produtoProdutoRepository.findById(idProduto);
        if (produto0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoProdutoRepository.delete(produto0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso");
    }
}
