package entity;

import base.entity.BaseEntity;
import entity.enumeration.CityType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City extends BaseEntity<Integer> {
    private String name;
    @Enumerated(EnumType.STRING)
    private CityType cityType;
}
