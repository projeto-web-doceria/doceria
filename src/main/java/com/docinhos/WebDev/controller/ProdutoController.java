package com.docinhos.webdev.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.docinhos.webdev.dtos.ProdutoRecordDto;
import com.docinhos.webdev.models.ProdutoModel;
import com.docinhos.webdev.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoProdutoRepository;

    @GetMapping("/listarProdutos")
    public String getAllproducts(Model model) {
        List<ProdutoModel> produto = produtoProdutoRepository.findAll();
        model.addAttribute("produto", produto);
        return "listarProdutos";
    }

    @GetMapping("/novoProduto")
    public String cadProd(Model model) {
        ProdutoRecordDto produtoDto = new ProdutoRecordDto(null, null, 0, null, null);
        model.addAttribute("produtoDto", produtoDto);
        return "novoProduto";
    }

    @PostMapping("/novoProduto")
    public String cadProd(@ModelAttribute("produtoDto") ProdutoRecordDto produtoDto) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoDto.nome());
        produtoModel.setDescricao(produtoDto.descricao());
        produtoModel.setPreco(produtoDto.preco());
        produtoModel.setDtFabricacao(produtoDto.dtFabricacao());
        produtoModel.setDtValidade(produtoDto.dtValidade());
        produtoProdutoRepository.save(produtoModel);

        return "redirect:/listarProduto";
    }

    // @GetMapping("/produtos/{idProduto}")
    // public ResponseEntity<Object> getOneProduto(@PathVariable(value =
    // "idProduto") UUID idProduto) {
    // Optional<ProdutoModel> produto0 =
    // produtoProdutoRepository.findById(idProduto);
    // if (produto0.isEmpty()) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não
    // encontrado");
    // }
    // return ResponseEntity.status(HttpStatus.OK).body(produto0.get());
    // }

    // @GetMapping("/editaProduto/{idProduto}")
    // public String editaProduto(Model model) {
    //     ProdutoRecordDto produtoDto = new ProdutoRecordDto(null, null, 0, null, null);
    //     model.addAttribute("produtoDto", produtoDto);
    //     return "listarProdutos";
    // }

    @RequestMapping("/editarProduto/{idProduto}")
    public String editaProduto(Model model, @PathVariable(value="idProduto") UUID idProduto ) {
            Optional<ProdutoModel> produto = produtoProdutoRepository.findById(idProduto);
           // var produtoModel = produto.get();
             model.addAttribute("produto", produto);
            //   produtoModel.getIdProduto();
            //   produtoModel.getNome();
            //   produtoModel.getDescricao();
            //   produtoModel.getDtFabricacao();
            //   produtoModel.getDtValidade();
        return "redirect:/listarProdutos";
    }

    @DeleteMapping("{idProduto}")
    public String delete(@PathVariable @RequestParam UUID idProduto){
            produtoProdutoRepository.deleteById(idProduto);

            return "redirect:/listarProdutos";
    }
    
}
