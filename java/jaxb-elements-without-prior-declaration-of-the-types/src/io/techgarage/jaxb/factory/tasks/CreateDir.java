package io.techgarage.jaxb.factory.tasks;

import io.techgarage.jaxb.factory.model.Task;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mkdir")
public class CreateDir extends Task {

    private String directory;

    @XmlAttribute(name = "dir")
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
