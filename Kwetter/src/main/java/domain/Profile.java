/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Jeroen
 */
@Entity
public class Profile implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String name;
    private File profilePicture;
    private String bio;
    private String locatie;
    private String website;
    @OneToMany
    private List<Kwet> kwets;
    @ManyToMany(mappedBy = "tagged")
    private List<Kwet> heartedKwets;
    @OneToMany
    private List<Profile> following;
    
    public Profile() {
        this.kwets = new ArrayList();
        this.heartedKwets = new ArrayList();
    }

    public Kwet placeKwet(String message) {
        Kwet kwet = new Kwet(message);
        this.kwets.add(kwet);
        return kwet;
    }
    
    public void follow(Profile profile){
        this.following.add(profile);
    }
    
    public void unFollow(Profile profile){
        this.following.remove(profile);
    }
    
    public void giveHearth(Kwet kwet){
        this.heartedKwets.add(kwet);
    }

    public void unGiveHearth(Kwet kwet){
        this.heartedKwets.remove(kwet);
    }
    
    public void removeKwet(Kwet kwet){
        this.kwets.remove(kwet);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Kwet> getKwets() {
        return kwets;
    }

    public void setKwets(List<Kwet> kwets) {
        this.kwets = kwets;
    }

    public List<Kwet> getHeartedKwets() {
        return heartedKwets;
    }

    public void setHeartedKwets(List<Kwet> heartedKwets) {
        this.heartedKwets = heartedKwets;
    }

    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }
    
    

}