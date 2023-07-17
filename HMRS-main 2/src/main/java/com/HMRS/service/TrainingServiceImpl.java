package com.HMRS.service;

import java.util.List;
import java.util.Optional;

import com.HMRS.model.Training;
import com.HMRS.repository.TrainingRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<Training> getAllClasses()
    {
        return trainingRepository.findAll();
    }

    @Override
    public void saveClass(Training training)
    {
        this.trainingRepository.save(training);
    }

    @Override
    public Training getClassByID(long ID)
    {
        Optional<Training> optional = trainingRepository.findById(ID);
        Training training = null;
        if (optional.isPresent())
        {
            training = optional.get();
        }
        else
        {
            throw new RuntimeException("Course not found for id:" + ID);
        }
        return training;
    }

    @Override
    public void deleteClassByID(long ID)
    {
        this.trainingRepository.deleteById(ID);
    }

    @Override
    public Page<Training> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
             Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1 , pageSize, sort);
        return this.trainingRepository.findAll(pageable);
    }
}
