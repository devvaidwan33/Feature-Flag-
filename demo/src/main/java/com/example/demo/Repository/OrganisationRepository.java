package com.example.demo.Repository;

import com.example.demo.Model.Organisation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationRepository {
    // make a save method having return type Organisation we can know organisation craeted by using getid
    // and getName methods

    // this not a method calling but a method defination which take parameter from service create method
    Organisation save(Organisation organisation);

    List<Organisation> findAll();

    Optional<Organisation> findById(UUID id);
    // optional ka matlab hai yaha value ho bhi sakti hai or nhi bhi
    //i.e organisation exists kar bhi skta hai or nhi bhi
    // Organization mil sakti hai ->
    //Optional mein value hogi ->
    //Organization nahi mili ->
    //Optional.empty()
}
