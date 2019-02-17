package pack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public  interface TaxCalculator {

    @RequestMapping(value = "calculateTax/{userId}", produces = "application/json", method = RequestMethod.GET)
    default ResponseEntity<Double> calculateTax(@RequestParam(value = "userId") String userId) {
        return new ResponseEntity<Double>(HttpStatus.NOT_IMPLEMENTED);
    }
}
