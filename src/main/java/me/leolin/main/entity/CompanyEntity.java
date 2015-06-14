package me.leolin.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Leolin
 */

@Entity
public class CompanyEntity implements Serializable {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String dbName;

    public CompanyEntity() {
    }

    public CompanyEntity(String id, String name, String dbName) {
        this.id = id;
        this.name = name;
        this.dbName = dbName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
