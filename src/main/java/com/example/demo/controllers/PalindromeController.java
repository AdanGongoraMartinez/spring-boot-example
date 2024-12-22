package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palindromos
 */
@RestController
public class PalindromeController {

    /**
     * Endpotn para verifcar si una palabra es palíndormo o no
     * 
     * @param word es la palabra a identificar
     * @return es un mensaje identificando si la palabra es palíndormo o no
     */
    @GetMapping("/validar-palindromo/{word}")
    public String Palindorme(@PathVariable String word) {
        if (isPalindrome(word)) {
            return "La palabra " + word + "es un palíndormo.";
        }
        return "La palabra " + word + " NO es un palíndormo.";
    }

    /**
     * Método para identidicar si la palabra es palíndromo
     * 
     * @param word es la palabra a identificar
     * @return true si la palabra es palíndormo, false de lo contrario
     */
    private boolean isPalindrome(String word) {
        int lenght = word.length();
        for (int i = 0; i < lenght / 2; i++) {
            if (word.charAt(i) != word.charAt(lenght - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
