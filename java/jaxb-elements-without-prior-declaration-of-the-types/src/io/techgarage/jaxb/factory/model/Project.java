package io.techgarage.jaxb.factory.model;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "tasks")
public class Project {

    private Collection<Task> tasks = new ArrayList<>();

    @XmlElementRef(name = "task")
    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }
}


