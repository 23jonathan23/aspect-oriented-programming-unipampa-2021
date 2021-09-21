package com.sales.online.games.salesonlinegames.Presentation.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "platform")
public class Platforms implements Serializable {

    public static final long serialVersionUID = 1L;
    
    public static final Platforms WINDOWS = new Platforms("WINDOWS", 0L);
    public static final Platforms MAC = new Platforms("MAC", 1L);
    public static final Platforms LINUX = new Platforms("LINUX", 2L);
    public static final Platforms ANDROID = new Platforms("ANDROID", 3L);
    public static final Platforms IOS = new Platforms("IOS", 4L);
    public static final Platforms XBOXONE = new Platforms("XBOXONE", 5L);
    public static final Platforms PLAYSTATION4 = new Platforms("PLAYSTATION4", 6L);
    public static final Platforms NINTENDOSWITCH = new Platforms("NINTENDOSWITCH", 7L);

    @Id
    @Column(name = "platformid")
    private long id;

    private String name;
    private Platforms(String name, long platformid) {
        this.id = platformid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
