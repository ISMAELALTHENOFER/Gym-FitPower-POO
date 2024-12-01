/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ismael
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private List<String> goal;
    private Gym gym;
    private List<NotificationTraining> notificationsTrainings;
    private List<NotificationNutrition> notificationNutritions;
    private List<Routine> routines;
    private List<NutritionPlan> nutritionPlans;

    public Customer() {
    }

    public Customer(Long id, String name, String lastName, List<String> goal, Gym gym, List<NotificationTraining> notificationsTrainings, List<NotificationNutrition> notificationNutritions, List<Routine> routines, List<NutritionPlan> nutritionPlans) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.goal = goal;
        this.gym = gym;
        this.notificationsTrainings = notificationsTrainings;
        this.notificationNutritions = notificationNutritions;
        this.routines = routines;
        this.nutritionPlans = nutritionPlans;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fitpower.model.Customer[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getGoal() {
        return goal;
    }

    public void setGoal(List<String> goal) {
        this.goal = goal;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public List<NotificationTraining> getNotificationsTrainings() {
        return notificationsTrainings;
    }

    public void setNotificationsTrainings(List<NotificationTraining> notificationsTrainings) {
        this.notificationsTrainings = notificationsTrainings;
    }

    public List<NotificationNutrition> getNotificationNutritions() {
        return notificationNutritions;
    }

    public void setNotificationNutritions(List<NotificationNutrition> notificationNutritions) {
        this.notificationNutritions = notificationNutritions;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

    public List<NutritionPlan> getNutritionPlans() {
        return nutritionPlans;
    }

    public void setNutritionPlans(List<NutritionPlan> nutritionPlans) {
        this.nutritionPlans = nutritionPlans;
    }

}
