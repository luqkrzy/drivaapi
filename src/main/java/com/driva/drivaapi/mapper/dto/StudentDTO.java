package com.driva.drivaapi.mapper.dto;

import com.driva.drivaapi.config.Constants;
import com.driva.drivaapi.model.user.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank(message = "first name can't be blank")
    @Size(max = 50)
    @Pattern(regexp = Constants.FIRST_LAST_NAME_REGEX, message = "allowed only letters")
    private String firstName;

    @NotBlank(message = "last name can't be blank")
    @Size(max = 50)
    @Pattern(regexp = Constants.FIRST_LAST_NAME_REGEX, message = "allowed only letters")
    private String lastName;

    @Email
    @Pattern(regexp = Constants.EMAIL_REGEX)
    @NotBlank(message = "email can't be blank")
    @Size(min = 5, max = 50)
    private String email;

    @Pattern(regexp = Constants.PHONE_REGEX, message = "phone number should have 9-13 digits without space")
    @NotBlank(message = "phone number can't be blank")
    private String phoneNumber;

    private Long createdBy;

    private Instant createdDate;

    private Long userId;

    private List<ProductDTO> products;

    public StudentDTO(Student student) {
        this.id = student.getId();
        // this.products = student.getProducts();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.phoneNumber = Integer.toString(student.getPhoneNumber());
        this.createdBy = student.getCreatedBy();
        this.createdDate = student.getCreatedDate();
        this.userId = student.getId();
    }
}