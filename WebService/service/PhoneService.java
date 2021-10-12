package com.team14.WebService.service;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.Phone;
import com.team14.WebService.entity.phoneComments;
import com.team14.WebService.entity.phoneFeatures;
import com.team14.WebService.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;
    Lock lock = new ReentrantLock();

    /***
     * saves Phone into Phone Repository
     * @param p
     * @return
     * @throws InterruptedException
     */
    public Phone savePhone(Phone p) throws InterruptedException{
        lock.lock();
        //Thread.sleep(10000);
        Phone temp = phoneRepository.save(p);
        lock.unlock();
        return temp;
    }

    /***
     * gets a Phone by its ID from Phone Repository
     * @param id
     * @return
     * @throws InterruptedException
     */
    public Phone getPhone(int id) throws InterruptedException{
        lock.lock();
        Phone temp = phoneRepository.findById(id).orElse(null);
        lock.unlock();
        return temp;
    }

    /***
     * lists of all Phones from Phone Repository
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getAllPhone() throws InterruptedException{
        lock.lock();
        List<Phone> tempPhoneList = phoneRepository.findAll();
        lock.unlock();
        return tempPhoneList;
    }


    /**
     *
     * @param id of phone
     * @return all comments of phone with specific id
     * @throws InterruptedException
     */
    public List<phoneComments> getAllPhoneCommentsById(int id) throws InterruptedException {
        phoneComments phonecomments = new phoneComments();
        List<Phone> phones = new ArrayList<>();
        List<phoneComments> retrievedComments = new ArrayList<>();
        phones = getAllPhone();
        int flag=0;

        for (int i =0;i<phones.size();i++){
            if(id == phones.get(i).getPhone_id())
                flag=i;

        }
        retrievedComments=phones.get(flag).getPhoneComments();
        return retrievedComments;
    }



    /***
     * gets a list of Phone by its brand from Phone Repository.
     * @param s is a string to specify its brand.
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getPhoneByBrand(String s) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();
        for (Phone phone : phones) {
            if (phone.getPhone_brand().equals(s)) {
                temp = phone;
                phones2.add(temp);
            }
        }
        return phones2;
    }

    /***
     * gets a list of Phone by its model from database
     * @param s is a string to specify its model
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getPhoneByModel(String s) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();
        for (Phone phone : phones) {
            if (phone.getPhone_brand().equals(s)) {
                temp = phone;
                phones2.add(temp);
            }
        }
        return phones2;
    }

    /***
     * gets a list of Phone by its screen size from database
     * @param s is a string to specify its screen size
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getPhoneByScreenSize(String s) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();
        for (Phone phone : phones) {
            if (phone.getPhone_screenSize().equals(s)) {
                temp = phone;
                phones2.add(temp);
            }
        }
        return phones2;
    }

    /***
     * Gets a list of Phone by its internal memory from database
     * @param s is a string to specify its internal memory
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getPhoneByInternalMemory(String s) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();
        for (Phone phone : phones) {
            if (phone.getPhone_internalMemory().equals(s)) {
                temp = phone;
                phones2.add(temp);
            }
        }
        return phones2;
    }

    /***
     * Gets a list of Phone by its price from database
     * @param s is a float to specify its price
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> getPhoneByPrice(float s) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();
        for (Phone phone : phones) {
            if (phone.getPrice() == s) {
                temp = phone;
                phones2.add(temp);
            }
        }
        return phones2;
    }

    /***
     * gets a list of Phone by its model and brand from database
     * @param model is a string to specify its model
     * @param brand is a string to specify its brand
     * @return a List of Phones
     * @throws InterruptedException
     */
    public List<Phone> SearchPhoneByModelAndBrand(String  model,String brand) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();

        for (Phone phone : phones) {
            if(model.equals(phone.getPhone_model()) && brand.equals(phone.getPhone_brand())) {
                temp = phone;
                phones2.add(temp);
            }

        }
        return phones2;
    }

    /***
     * Gets a list of Phone by its screen , memory and brand from database
     * @param screen is a string to specify its screen
     * @param memory is a string to specify its memory
     * @param brand is a string to specify its brand
     * @return a list of Phones
     * @throws InterruptedException
     */
    public List<Phone> SearchPhoneByScreenSize_MemoryAndBrand(String  screen,String memory,String  brand ) throws InterruptedException {
        Phone temp = new Phone();
        List<Phone> phones = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        phones=getAllPhone();

        for (Phone phone : phones) {
            if(screen.equals(phone.getPhone_screenSize()) && memory.equals(phone.getPhone_internalMemory()) && brand.equals(phone.getPhone_brand())) {
                temp = phone;
                phones2.add(temp);
            }

        }
        return phones2;
    }
}
