package com.example.demo.Repository;

import com.example.demo.Model.Organisation;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrganisationRepository implements OrganisationRepository{
    // uuid to uniqly indetify org and Organiisation class to get all information of organisation
    // if we use object of org here we have to call methods of org by obj
    // so we use full class which return every thing of all organisation
    private final Map<UUID, Organisation> store = new ConcurrentHashMap<>();

    @Override
    //                        Organisation class type a orgnasiastion object pass kar rhe hai to acess
            // organisation class methods
    public Organisation save( Organisation organisation){
        store.put(organisation.getId(), organisation);
        return organisation;
    }

    @Override
    // .valuse return krega sari valuse i.e sare organisation ki sari information
    public List<Organisation> findAll(){
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Organisation> findById(UUID id){
        return Optional.ofNullable(store.get(id));
    }
    // optional ka matlab hai yaha value ho bhi sakti hai or nhi bhi
    //i.e organisation exists kar bhi skta hai or nhi bhi
    // Organization mil sakti hai ->
    //Optional mein value hogi ->
    //Organization nahi mili ->
    //Optional.empty(


}
