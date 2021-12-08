package com.example.samplespringapp.service.validation;

import com.example.samplespringapp.exception.ValidationException;
import com.example.samplespringapp.service.dto.TeacherDTO;

import java.util.ArrayList;
import java.util.List;

import static com.example.samplespringapp.service.validation.ArgumentValidation.*;

public class TeacherValidation {

    private final TeacherDTO teacherDTO;

    public TeacherValidation(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public void validate(){
        List<String> exceptionList = new ArrayList<>();

        if(isNull(teacherDTO.getEmail()) || isEmpty(teacherDTO.getEmail())){
            exceptionList.add("Wpisz adres email!");
        } else{
            if (!isEmail(teacherDTO.getEmail())){
                exceptionList.add("Podany email nie jest poprawny!");
            }
            if (minLength(teacherDTO.getEmail(), 5)){
                exceptionList.add("Email musi mieć minimum 5 znaków!");
            } else if (maxLength(teacherDTO.getEmail(), 40)){
                exceptionList.add("Email musi mieć maksymalnie 40 znaków!");
            }
        }

        if (isNull(teacherDTO.getFirstName()) || isEmpty(teacherDTO.getFirstName())){
            exceptionList.add("Wpisz imię!");
        } else if (minLength(teacherDTO.getFirstName(), 2)){
            exceptionList.add("Imię musi mieć minimum 2 znaki!");
        } else if (maxLength(teacherDTO.getFirstName(), 40)){
            exceptionList.add("Imię musi mieć maksymalnie 40 znaków!");
        }

        if (isNull(teacherDTO.getLastName()) || isEmpty(teacherDTO.getLastName())){
            exceptionList.add("Wpisz nazwisko!");
        } else if (minLength(teacherDTO.getLastName(), 2)){
            exceptionList.add("Nazwisko musi mieć minimum 2 znaki!");
        } else if (maxLength(teacherDTO.getLastName(), 40)){
            exceptionList.add("Nazwisko musi mieć maksymalnie 40 znaków!");
        }

        if (isNull(teacherDTO.getAge())){
            exceptionList.add("Wpisz wiek!");
        } else if (minValue(teacherDTO.getAge(), 18)){
            exceptionList.add("Wiek musi być większy od 18!");
        }

        if (isNull(teacherDTO.getSchoolSubject()) || isEmpty(teacherDTO.getSchoolSubject())){
            exceptionList.add("Wpisz przedmiot!");
        } else if (minLength(teacherDTO.getSchoolSubject(), 2)){
            exceptionList.add("Przedmiot musi mieć minimum 2 znaki!");
        } else if (maxLength(teacherDTO.getSchoolSubject(), 40)){
            exceptionList.add("Przedmiot musi mieć maksymalnie 40 znaków!");
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
