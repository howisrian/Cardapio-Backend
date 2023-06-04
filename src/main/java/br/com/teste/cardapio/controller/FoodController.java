package br.com.teste.cardapio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.teste.cardapio.food.Food;
import br.com.teste.cardapio.food.FoodRepository;
import br.com.teste.cardapio.food.FoodRequestDTO;
import br.com.teste.cardapio.food.FoodResponseDTO;

@RestController
@RequestMapping("food")
public class FoodController {


    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList =  (List<FoodResponseDTO>) repository.findAll().stream().map(FoodResponseDTO::new);
        return foodList;
    }
    
    
}
