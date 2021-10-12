package com.team14.WebService.service;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.repository.ComputerCommentRepository;
import com.team14.WebService.repository.ComputerFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class computerCommentsService {
    @Autowired
    ComputerCommentRepository computerCommentRepository;

    /**
     * Saves the entered computer comments to database
     * @param compComments used for saving the computer comment
     * @return saves the given comment
     */
    public computerComments saveComputerComments (computerComments compComments){ return computerCommentRepository.save(compComments);}

    /**
     * Returns the specific desired computer comment
     * @param id belongs to a computer comment
     * @return returns the computer comments with given id
     */
    public computerComments getComputerComments (int id){ return computerCommentRepository.findById(id).orElse(null);}

    /**
     * Returns all computer comments stored
     * @return all the computer comments stored in database
     */
    public List<computerComments> getAllComputerComments() { return computerCommentRepository.findAll(); }

    /**
     * Returns all the comments made on a specific computer with given id
     * @param id belongs to a computer
     * @return all the comments of a given computer by id taken
     */
    public List<computerComments> getAllComputerByComputerID(int id){
        List<computerComments> pList1 = new ArrayList<>();
        List<computerComments> pList2 = new ArrayList<>();
        pList1 = getAllComputerComments();
        for(int i = 0; i<pList1.size();i++ ){
            if(pList1.get(i).getComputerComments().getComputerID() == id)
                pList2.add(pList1.get(i));
        }
        return pList2;

    }

}
