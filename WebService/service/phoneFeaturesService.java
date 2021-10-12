package com.team14.WebService.service;

import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.entity.phoneComments;
import com.team14.WebService.entity.phoneFeatures;
import com.team14.WebService.repository.PhoneFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class phoneFeaturesService {
    @Autowired
    PhoneFeatureRepository phoneFeatureRepository;

    /***
     * Saves Phone Feature into database
     * @param phonFeature is a Phone Feature to be saved into database
     * @return
     */
    public phoneFeatures savePhoneFeature (phoneFeatures phonFeature){ return phoneFeatureRepository.save(phonFeature);}

    /***
     * Gets a Phone Feature by its Phone Feature ID from database
     * @param id is an integer to specify its Phone Feature ID
     * @return a Phone Feature
     */
    public phoneFeatures getPhoneFeature (int id){ return phoneFeatureRepository.findById(id).orElse(null);}

    /***
     * Gets a list of all Phone Features from database
     * @return a list of Phone Features
     */
    public List<phoneFeatures> getAllPhoneFeatures() { return phoneFeatureRepository.findAll(); }

    /***
     * Gets a list of all Phone Features by its Phone ID
     * @param id is an integer to specify its Phone ID
     * @return a list of Phone Features
     */
    public List<phoneFeatures> getAllPhoneFeaturesByPhoneID(int id){
        List<phoneFeatures> pList1 = new ArrayList<>();
        List<phoneFeatures> pList2 = new ArrayList<>();
        pList1 = getAllPhoneFeatures();
        for(int i = 0; i<pList1.size();i++ ){
            if(pList1.get(i).getPhoneFeatures().getPhone_id() == id)
                pList2.add(pList1.get(i));
        }
        return pList2;
    }
}
