package com.example;

import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.soap_service.allinone.Dataset;
import org.acme.soap_service.allinone.Wrapper;
import org.acme.soap_service.allinone.Objd;
import org.acme.soap_service.allinone.ObjCollection;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

@Path("/Send/Batch")
public class dataSetClient {

    @CXFClient("DatasetService")
    Dataset dataset;

    @GET
    @Path("/insert")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Wrapper combineStructure() throws Exception {

        String type = "SampleName";

        GregorianCalendar calendar = new GregorianCalendar(2024, 11, 4);
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

        List<String> sign  = new ArrayList<>();
        sign.add("Signature1");
        sign.add("Signature2");

        Objd objd = new Objd();
        objd.setDistrict("District");
        objd.setCity("City");
        objd.setPostal(1111);

        ObjCollection collection = new ObjCollection();
        collection.getUserDetails().add(objd);
        collection.getContractDetails().add(objd);

        Wrapper res = dataset.combineStructure(type, date, sign, objd, collection);

        return res;
    }
}
