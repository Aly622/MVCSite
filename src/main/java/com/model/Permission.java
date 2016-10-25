package com.model;

import java.io.Serializable;

/**
 * Created by Oliver.Liu on 6/28/2016.
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = -8025597823572680802L;
    private Integer id;
    private String resourceCode;

    public Permission() {
        super();
    }
    // --------------------------------------------------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permission other = (Permission) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    // --------------------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getResourceCode() {
        return resourceCode;
    }
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }
}
