package io.techgarage.jaxb.factory.app;

import io.techgarage.jaxb.factory.model.Project;
import io.techgarage.jaxb.factory.tasks.CreateDir;
import io.techgarage.jaxb.factory.tasks.RemoveDir;
import io.techgarage.jaxb.factory.tasks.Timestamp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class Application {

    public static void main(String[] args) throws JAXBException, IOException {
        Project project = new Project();
        project.getTasks().add(new Timestamp());
        project.getTasks().add(new CreateDir());
        project.getTasks().add(new RemoveDir());

        Marshaller marshaller = JAXBContext.newInstance("io.techgarage.jaxb.factory.model:io.techgarage.jaxb.factory.tasks").createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(project, writer);
            System.out.println(writer.toString());
        }
    }
}
