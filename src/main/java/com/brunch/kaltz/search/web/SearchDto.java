package com.brunch.kaltz.search.web;

import com.brunch.kaltz.search.domain.Search;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SearchDto {

    private String dataname;
    private String datanumber;

    public SearchDto(String dataname, String datanumber) {
        this.dataname = dataname;
        this.datanumber = datanumber;
    }

    public Search makeSearchObj() {
//        double v = Double.parseDouble(this.datanumber);
        BigDecimal v = new BigDecimal(this.datanumber);
        return new Search(this.dataname, v);
    }
}
