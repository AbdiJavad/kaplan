package com.avin.kaplan.service;

import com.avin.kaplan.model.Paint;
import com.avin.kaplan.model.Product;
import com.avin.kaplan.repository.PaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaintService {
    @Autowired
    PaintRepository paintRepository;
    public Paint updatePaint(Long id, Paint paint) {
        Paint paint1 ;
        Optional<Paint> paintData = paintRepository.findById(id);
        if (paintData.isPresent()) {
            paint = paintData.get();
        } else {
            return null;
        }
        if (paint.getId() != null && paint.getId() > 0) {
            paint.setId(paint.getId());
        }
        if (paint.getName() != null) {
            paint.setName(paint.getName());
        }
        if(paint.getWeight() !=0){
            paint.setWeight(paint.getWeight());
        }
        if(paint.getDateCreated()!=null){
            paint.setDateCreated(paint.getDateCreated());
        }
        return paintRepository.save(paint);
    }
}
