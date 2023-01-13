package com.mintgenie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ListId implements Serializable {

    private static final long serialVersionUID = 1L;
    private int watchlistid;
    private int stockid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListId listId = (ListId) o;
        return watchlistid == listId.watchlistid && stockid == listId.stockid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchlistid, stockid);
    }
}