package test.com.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.com.sort.HeapSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/array")
public class ArrayController {

    @GetMapping("")
    public ResponseEntity<List<int[]>> get(@RequestParam int n) {
        List<int[]> result = new ArrayList<>();

       int[] numbers = new Random().ints(n).toArray();
        result.add(numbers.clone());

        HeapSort.sort(numbers);
        result.add(numbers);

        return ResponseEntity.ok(result);
    }
}
