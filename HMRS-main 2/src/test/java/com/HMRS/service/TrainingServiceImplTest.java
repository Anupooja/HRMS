package com.HMRS.service;
import com.HMRS.model.Training;
import com.HMRS.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TrainingServiceImplTest {
    @Autowired
    private TrainingRepository trainingRepository;
    @Test
    void getAllCourses(){
        List<Training> items = trainingRepository.findAll();
        assertEquals(6, items.size());
    }

    @Test
    public void testFindOne(){
        Training training = trainingRepository.getReferenceById(3L);
        assertEquals("Software Systems", training.getClassName());
    }
}
