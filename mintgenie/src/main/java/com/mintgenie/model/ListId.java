package com.mintgenie.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListId implements Serializable {

    private static final long serialVersionUID = 1L;
    private int watchlistid;
    private String type;

    public ListId() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ListId(int watchlistid, String type) {
        super();
        this.watchlistid = watchlistid;
        this.type = type;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getWatchlistid() {
        return watchlistid;
    }

    public void setWatchlistid(int watchlistid) {
        this.watchlistid = watchlistid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ListId [watchlistid=" + watchlistid + ", type=" + type + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, watchlistid);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListId other = (ListId) obj;
        return Objects.equals(type, other.type) && watchlistid == other.watchlistid;
    }


}
