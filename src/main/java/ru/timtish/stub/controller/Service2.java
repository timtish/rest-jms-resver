package ru.timtish.stub.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class Service2 {

    @GetMapping("/")
    @ResponseBody
    public String info() {
        return "running";
    }

    @Operation(description = "Найти по ИНН")
    @GetMapping("find")
    public List<String> find(String inn) {
        log.info("find " + inn);
        return Collections.emptyList();
    }

    @Operation(description = "Сложить числа")
    @PostMapping("sum")
    public Integer sum(@RequestBody Number... values) {
        log.info("sum " + values);
        int sum = 0;
        for (Number v : values) {
            log.debug("");
            sum += v.intValue();
        }
        return sum;
    }

}
