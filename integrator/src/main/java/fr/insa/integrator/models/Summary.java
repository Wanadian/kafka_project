package fr.insa.integrator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    private String id;
    private Global global;
    private List<Country> countries;
    private Date date;
}
