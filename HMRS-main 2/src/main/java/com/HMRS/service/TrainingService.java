package com.HMRS.service;

import com.HMRS.model.Training;
import org.springframework.data.domain.Page;
import java.util.List;

public interface TrainingService {
    List<Training> getAllClasses();
    void saveClass(Training training);
    Training getClassByID(long id);
    void deleteClassByID(long id);
    Page<Training> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
