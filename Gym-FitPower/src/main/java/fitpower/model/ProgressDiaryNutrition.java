/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ismael
 */
@Entity
public class ProgressDiaryNutrition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float dailyCalories;
    private Float dailyProteins;
    private Float dailyCarbohydrates;
    private Float dailyFats;
    private Float currentWeight;

    public ProgressDiaryNutrition(Long id, Float dailyCalories, Float dailyProteins, Float dailyCarbohydrates, Float dailyFats, Float currentWeight) {
        this.id = id;
        this.dailyCalories = dailyCalories;
        this.dailyProteins = dailyProteins;
        this.dailyCarbohydrates = dailyCarbohydrates;
        this.dailyFats = dailyFats;
        this.currentWeight = currentWeight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgressDiaryNutrition)) {
            return false;
        }
        ProgressDiaryNutrition other = (ProgressDiaryNutrition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fitpower.model.ProgressDiaryNutrition[ id=" + id + " ]";
    }

    public Float getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(Float dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public Float getDailyProteins() {
        return dailyProteins;
    }

    public void setDailyProteins(Float dailyProteins) {
        this.dailyProteins = dailyProteins;
    }

    public Float getDailyCarbohydrates() {
        return dailyCarbohydrates;
    }

    public void setDailyCarbohydrates(Float dailyCarbohydrates) {
        this.dailyCarbohydrates = dailyCarbohydrates;
    }

    public Float getDailyFats() {
        return dailyFats;
    }

    public void setDailyFats(Float dailyFats) {
        this.dailyFats = dailyFats;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

}
