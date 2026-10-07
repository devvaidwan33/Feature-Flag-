package com.example.demo.Service;

import com.example.demo.Model.Organisation;
import com.example.demo.Repository.OrganisationRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {
    // we make a refrence variable of repository layer to call its matheods
    OrganisationRepository organisationRepository;
    public OrganisationService(OrganisationRepository organisationRepository){
        this.organisationRepository=organisationRepository;
    }

    // we just need a name to create an organisation
    // and now we make object of organisation class to send valuse through constructor
    public Organisation create(String name){
        Organisation organisation = new Organisation(UUID.randomUUID(),name);
        return organisationRepository.save(organisation);
        // hamnse repo layer ko organisation ka object share
        // kardiya taki vo organisation class ke har method ko access kar paye
        // when cliet call create method it first goes to controller where the create called this create method of
        // service and request.name give the name("Google") and pass this google as a parameter to create method
        // of service layer
    }
             // return type
     public List<Organisation> getAll(){

        return organisationRepository.findAll();
     }
     public Organisation getById(UUID id){
        return organisationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Organisation" + id + "Not Found"));
     }
}
