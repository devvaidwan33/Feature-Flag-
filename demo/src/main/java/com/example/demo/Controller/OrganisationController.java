package com.example.demo.Controller;

import com.example.demo.Model.Organisation;
import com.example.demo.Service.OrganisationService;
import com.example.demo.dto.CraeteOrganisationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orgs")
public class OrganisationController {
    // after making service class we need to import it here
    OrganisationService organisationService; // refrence variable of object of service layer

    // hum ek dependency injection ke through object banayenge service layer ka aur use define karenge
    //OrganisationController ke costructor se taki service layer ke object ke through hum call karpaye
    // sevice layer ke methods ko
    // i.e controller layer baat kar paye service layer se
    public OrganisationController(OrganisationService organizationService){
        this.organisationService =organizationService; // intilize object of service layer
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // if we need to create multiple organisation at a time so we need to make create mathod retype to
    // ArrayList<Organisation> to organisation
    public Organisation create(@Valid @RequestBody CraeteOrganisationRequest request){
        return organisationService.create(request.name());
    }
    // @reqyestbody json format m diye gaye name of yaha request.name m set kar dega
    // fir ve organisationService m likhe gye create method ko as a parameter pass hoga
    // jo fir repo ko pass karega iise save karne ke liye DB m
    // request ek refrence variable hai createOrganisationRquest naam ki class ka jisme ek name method hai
    // jo set kargea organisation ka naam jab create hoga .. client bss naam dega organisation ko or create ho jayega

    @GetMapping
    public List<Organisation> getAll(){
        return organisationService.getAll();
        // controller layer koi bussiness logic nhi rkhta
        // to ye service layer ko call karega jisme ek getAll naame ka method hoga jo actual bussiness logic
    }
    @GetMapping ("/{orgId}")
    public Organisation getById(@PathVariable UUID orgId){

        return organisationService.getById(orgId);
    }
}
