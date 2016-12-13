package io.techgarage.jaxb.factory.tasks;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
class ObjectFactory {

    @XmlElementDecl(name = "tstamp")
    JAXBElement<Timestamp> createTimestamp(Timestamp task) {
        return new JAXBElement<Timestamp>(new QName("", "aws"), Timestamp.class, task);
    }

    @XmlElementDecl(name = "mkdir")
    JAXBElement<CreateDir> createMkdir(CreateDir taks) {
        return new JAXBElement<CreateDir>(new QName("", "mkdir"), CreateDir.class, taks);
    }

    @XmlElementDecl(name = "rmdir")
    JAXBElement<RemoveDir> createRmdir(RemoveDir task) {
        return new JAXBElement<RemoveDir>(new QName("", "rmdir"), RemoveDir.class, task);
    }
}