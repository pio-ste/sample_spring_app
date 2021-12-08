package com.example.samplespringapp.service.validation;

import com.example.samplespringapp.exception.ValidationException;
import com.example.samplespringapp.service.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

import static com.example.samplespringapp.service.validation.ArgumentValidation.*;

public class StudentValidation {

    private final StudentDTO studentDTO;

    public StudentValidation(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public void validate() {
        List<String> exceptionList = new ArrayList<>();

        if(isNull(studentDTO.getEmail()) || isEmpty(studentDTO.getEmail())){
            exceptionList.add("Wpisz adres email!");
        } else{
            if (!isEmail(studentDTO.getEmail())){
                exceptionList.add("Podany email nie jest poprawny!");
            }
            if (minLength(studentDTO.getEmail(), 5)){
                exceptionList.add("Email musi mieć minimum 5 znaków!");
            } else if (maxLength(studentDTO.getEmail(), 40)){
                exceptionList.add("Email musi mieć maksymalnie 40 znaków!");
            }
        }

        if (isNull(studentDTO.getFirstName()) || isEmpty(studentDTO.getFirstName())){
            exceptionList.add("Wpisz imię!");
        } else if (minLength(studentDTO.getFirstName(), 2)){
            exceptionList.add("Imię musi mieć minimum 2 znaki!");
        } else if (maxLength(studentDTO.getFirstName(), 40)){
            exceptionList.add("Imię musi mieć maksymalnie 40 znaków!");
        }

        if (isNull(studentDTO.getLastName()) || isEmpty(studentDTO.getLastName())){
            exceptionList.add("Wpisz nazwisko!");
        } else if (minLength(studentDTO.getLastName(), 2)){
            exceptionList.add("Nazwisko musi mieć minimum 2 znaki!");
        } else if (maxLength(studentDTO.getLastName(), 40)){
            exceptionList.add("Nazwisko musi mieć maksymalnie 40 znaków!");
        }

        if (isNull(studentDTO.getAge())){
            exceptionList.add("Wpisz wiek!");
        } else if (minValue(studentDTO.getAge(), 18)){
            exceptionList.add("Wiek musi być większy od 18!");
        }

        if (isNull(studentDTO.getFieldOfStudy()) || isEmpty(studentDTO.getFieldOfStudy())){
            exceptionList.add("Wpisz kierunek studiów!");
        } else if (minLength(studentDTO.getFieldOfStudy(), 2)){
            exceptionList.add("Kierunek musi mieć minimum 2 znaki!");
        } else if (maxLength(studentDTO.getFieldOfStudy(), 40)){
            exceptionList.add("Kierunek musi mieć maksymalnie 40 znaków!");
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
