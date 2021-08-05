package com.driva.drivaapi.controller;

import com.driva.drivaapi.mapper.dto.LessonStudentDTO;
import com.driva.drivaapi.model.lesson.Lesson;
import com.driva.drivaapi.model.product.Product;
import com.driva.drivaapi.model.user.Instructor;
import com.driva.drivaapi.service.InstructorService;
import com.driva.drivaapi.service.LessonService;
import com.driva.drivaapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/lessons")
public class LessonController {
   
   private final LessonService lessonService;
   private final ProductService productService;
   private final InstructorService instructorService;
   
   @GetMapping
   @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
   List<LessonStudentDTO> getAllLessons() {
      return lessonService.findAll();
   }
   
   @GetMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
   LessonStudentDTO getLesson(@PathVariable Long id) {
      
      return lessonService.find(id);
   }
   
   @PostMapping
   @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
   @ResponseStatus(code = HttpStatus.CREATED)
   LessonStudentDTO createLesson(@RequestBody @Valid LessonStudentDTO lessonStudentDTO) {
      final Product product = productService.find(lessonStudentDTO.getProductId());
      final Instructor instructor = instructorService.findEntity(lessonStudentDTO.getInstructorId());
      return lessonService.save(lessonStudentDTO, product, instructor);
   }
   
   @PutMapping
   @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
   @ResponseStatus(code = HttpStatus.OK)
   Lesson updateLesson(@RequestBody @Valid Lesson lesson) {
      return lessonService.update(lesson);
   }
   
   @DeleteMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   void deleteLesson(@PathVariable Long id) {
      lessonService.delete(id);
   }
}
