package com.avin.kaplan.controller;

import com.avin.kaplan.model.Paint;
import com.avin.kaplan.repository.PaintRepository;
import com.avin.kaplan.service.PaintService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Paint")
public class PaintController {
    @Autowired
    public PaintRepository paintRepository;
    @Autowired
    public PaintService paintService;

    @GetMapping
    public List<Paint> getPaint() {
        return paintRepository.findAll();
    }

    @PostMapping
    public Paint save(@RequestBody Paint paint) {
        return paintRepository.save(paint);
    }

  @DeleteMapping("/{id}")
    public void delet(@PathVariable("id") Long id,@RequestBody Paint paint) {
        paintRepository.delete(paint);
    }
    @PutMapping("/{id}")
    public Paint updatePaint(@PathVariable("id") Long id,@RequestBody Paint paint){
        return paintService.updatePaint(id,paint);
    }

}
