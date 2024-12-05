package com.example;

import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
    public Wrapper combineStructure() throws Exception {

        String arg0 = "SampleName";

        GregorianCalendar calendar = new GregorianCalendar(2024, 11, 4);
        XMLGregorianCalendar arg1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

        List<String> arg2 = new ArrayList<>();
        arg2.add("Signature1");
        arg2.add("Signature2");

        Objd arg3 = new Objd();
        arg3.setDistrict("District");
        arg3.setCity("City");
        arg3.setPostal(1111);

        ObjCollection arg4 = new ObjCollection();
        arg4.getUserDetails().add(arg3);
        arg4.getContractDetails().add(arg3);

        Wrapper res = dataset.combineStructure(arg0, arg1, arg2, arg3, arg4);

        return res;
    }
}
