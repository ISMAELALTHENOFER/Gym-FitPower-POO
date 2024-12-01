/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ismael
 */
@Entity
public class NutritionPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String goals;
    private Float targetWeight;
    private Float initialWeight;
    private Boolean asset;
    private Float dailyCalories;
    private Float dailyProteins;
    private Float dailyCarbohydrates;
    private Float dailyFats;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
    private String recommendation;

    public NutritionPlan() {
    }

    public NutritionPlan(Long id, String goals, Float targetWeight, Float initialWeight, Boolean asset, Float dailyCalories, Float dailyProteins, Float dailyCarbohydrates, Float dailyFats, LocalDateTime startdate, LocalDateTime enddate, String recommendation) {
        this.id = id;
        this.goals = goals;
        this.targetWeight = targetWeight;
        this.initialWeight = initialWeight;
        this.asset = asset;
        this.dailyCalories = dailyCalories;
        this.dailyProteins = dailyProteins;
        this.dailyCarbohydrates = dailyCarbohydrates;
        this.dailyFats = dailyFats;
        this.startdate = startdate;
        this.enddate = enddate;
        this.recommendation = recommendation;
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
        if (!(object instanceof NutritionPlan)) {
            return false;
        }
        NutritionPlan other = (NutritionPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fitpower.model.NutritionPlan[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Float getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Float initialWeight) {
        this.initialWeight = initialWeight;
    }

    public Boolean getAsset() {
        return asset;
    }

    public void setAsset(Boolean asset) {
        this.asset = asset;
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

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

}
