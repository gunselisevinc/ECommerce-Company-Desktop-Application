package com.team14.WebService.service;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.entity.phoneFeatures;
import com.team14.WebService.repository.ComputerFeatureRepository;
import com.team14.WebService.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class computerFeaturesService {
    @Autowired
    ComputerFeatureRepository computerFeatureRepository;

    /**
     * Saves the entered computer features to database
     * @param compFeature used for saving the computer feature
     * @return saves the given computer feature
     */
    public computerFeatures saveComputerFeature (computerFeatures compFeature){ return computerFeatureRepository.save(compFeature);}

    /**
     * Returns the specific desired computer feature
     * @param id belongs to a computer feature
     * @return the computer feature with given id
     */
    public computerFeatures getComputerFeature (int id){ return computerFeatureRepository.findById(id).orElse(null);}

    /**
     * Returns all computer features stored
     * @return all the computer features stored int the database
     */
    public List<computerFeatures> getAllComputerFeatures() { return computerFeatureRepository.findAll(); }

    /**
     * Returns all the features of a specific computer with given id
     * @param id belongs to a computer
     * @return all the features of the given computer by id taken
     */
    public List<computerFeatures> getAllComputerFeaturesByComputerID(int id){
        List<computerFeatures> pList1 = new ArrayList<>();
        List<computerFeatures> pList2 = new ArrayList<>();
        pList1 = getAllComputerFeatures();
        for(int i = 0; i<pList1.size();i++ ){
            if(pList1.get(i).getComputerFeature().getComputerID() == id)
                pList2.add(pList1.get(i));
        }
        return pList2;
    }


}
