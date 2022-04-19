package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static  org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    private ObterDiplomaService obterDiplomaService;

    @Mock
    private StudentDAO studentDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        obterDiplomaService = new ObterDiplomaService();
        obterDiplomaService.setStudentDAO(studentDAO);
    }

    @Test
    public void testWhenStudentIdIsFound() {
        SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setName("Filosofia");
            subjectDTO.setScore(9.0);

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Matematica");
        subjectDTO1.setScore(8.0);

        StudentDTO studentDTO =  new StudentDTO();
            studentDTO.setId(1L);
            studentDTO.setStudentName("Hugo");
            studentDTO.setMessage("Testando");
            studentDTO.setSubjects(Arrays.asList(subjectDTO, subjectDTO1));

        Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);

        StudentDTO student = obterDiplomaService.analyzeScores(1L);

        System.out.println(student);
//        assertNotNull(student);
        assertEquals("Hugo", student.getStudentName());
    }
}
