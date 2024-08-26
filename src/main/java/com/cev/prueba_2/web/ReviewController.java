package com.cev.prueba_2.web;

import com.cev.prueba_2.domain.Review;
import com.cev.prueba_2.repository.ReviewRepository;
import com.cev.prueba_2.service.CustomError.CustomError;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Buscar todas las Reviews
    @GetMapping
    List<Review> findAll(){
        return reviewRepository.findAll();
    }

    // Buscar Review por titulos
    @GetMapping(path = "/title")
    List<Review> findByTitle(@RequestParam(required = false) String title){
        if (title != null){
            List<Review> totalReviews = reviewRepository.findByMovie_Title(title);
            totalReviews.sort(Comparator.comparing(Review::getPunctuation).reversed());
            return totalReviews;
        }else throw new CustomError("Es obligatorio indicar el título para poder buscar las reviews.");
    }

    // Creamos una nueva Review
    @PostMapping
    Review createReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }
}
