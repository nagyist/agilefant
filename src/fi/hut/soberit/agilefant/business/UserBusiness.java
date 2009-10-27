package fi.hut.soberit.agilefant.business;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.joda.time.Duration;
import org.joda.time.Interval;

import fi.hut.soberit.agilefant.model.User;

/**
 * Interface for user business.
 * 
 * @author rjokelai
 * 
 */
public interface UserBusiness extends GenericBusiness<User> {

    /**
     * Store a user and return the persisted object.
     * <p>
     * Changes the password if (password1 != null) and (password1 == password2)
     * @param teamIds TODO
     * @param passwordConfirm TODO
     * @return the newly persisted user
     */
    User storeUser(User data, Set<Integer> teamIds, String password, String passwordConfirm);

    /**
     * Check if user is creator of any stories.
     * 
     * @param user
     * @return true is user has created stories, false otherwise.
     */
    boolean hasUserCreatedStories(User user);

    User retrieveByLoginName(String loginName);

    public boolean isLoginNameUnique(String loginName);
    
    /**
     * Get all enabled users.
     * 
     * @return list of enabled users
     */
    List<User> getEnabledUsers();

    /**
     * Get all disabled users.
     * 
     * @return list of disabled users
     */
    List<User> getDisabledUsers();

    void disableUser(int id);

    void enableUser(int id);

    /**
     * Duration object representing total (days) that the given user can work
     * within the given timeframe.
     */
    public Duration calculateWorktimePerPeriod(User user, Interval interval);

    public Collection<User> retrieveMultiple(Set<Integer> userIds);

}
