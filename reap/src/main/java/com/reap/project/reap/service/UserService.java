package com.reap.project.reap.service;

import com.reap.project.reap.dto.AdminDTO;
import com.reap.project.reap.model.UserBadges;
import com.reap.project.reap.model.Role;
import com.reap.project.reap.model.User;
import com.reap.project.reap.model.UserRecognize;
import com.reap.project.reap.repository.RoleRepository;
import com.reap.project.reap.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Service
public class UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(User user){
        user.setActive(1);
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setRole("User");
        roles.add(role);
        user.setRoles(roles);
        List<UserBadges> badges = new ArrayList<>();
        UserBadges gold = new UserBadges("Gold",3);
        UserBadges silver = new UserBadges("Silver",2);
        UserBadges bronze = new UserBadges("Bronze",1);
        user.setGoldBadgesReceived(0);
        user.setBronzeBadgesReceived(0);
        user.setSilverBadgesReceived(0);
        List<UserBadges> badgesList = Arrays.asList(gold,silver,bronze);
        user.setBadges(badgesList);
        user.setUserCompleteName(user.getFirstname()+" "+user.getLastname());
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findByID(int id){
        return userRepository.findById(id);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void updateUser(AdminDTO adminDTO){
        User userToUpdate = userRepository.findById(adminDTO.getId());
        if(userToUpdate!=null){
            List<UserBadges> badgesList = findBadgesId(userToUpdate.getId());
            for(UserBadges userBadges : badgesList){
                String badgeType = userBadges.getType();
                if(badgeType.equals("Gold")){
                    int badgeCount = adminDTO.getGoldCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType,badgeCount,badgeID);
                }
                if(badgeType.equals("Silver")){
                    int badgeCount = adminDTO.getSilverCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType,badgeCount,badgeID);
                }
                if(badgeType.equals("Bronze")){
                    int badgeCount = adminDTO.getBronzeCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType,badgeCount,badgeID);
                }
            }
            Role userRoleObject = findRolesId(adminDTO.getId());
            updateRole(userRoleObject.getId(),adminDTO.getRole());
            updateUserActive(adminDTO.getActive(),userToUpdate.getId());
        }
    }

    @Transactional
    public void updateUserActive(int active,int id) {
        userRepository.updateUserActive(active,id);
    }

    @Transactional
    public void updateRole(int id, String roleToUpdate) {
        userRepository.updateRole(id,roleToUpdate);
    }

    public boolean updateBadges(User loggedInUser, UserRecognize userRecognize){
        System.out.println(loggedInUser);
        boolean flag = true;
        ModelAndView modelAndView = new ModelAndView();
        User userExist = userRepository.findUserByEmail(userRecognize.getNewersEmail());
        if(userExist!=null){
            if(userRecognize.getBadgeType().equals("Gold")){
                List<UserBadges> badgesList = findBadgesId(loggedInUser.getId());
                for(UserBadges userBadges : badgesList){
                    String badgeType = userBadges.getType();
                    if(badgeType.equals("Gold")){
                        int badgeCount = userBadges.getCount();
                        int badgeID = userBadges.getId();
                        if(badgeCount > 0){
                            updateBadgesCount(badgeType,badgeCount-1,badgeID);
                            userExist.setGoldBadgesReceived(userExist.getGoldBadgesReceived()+1);
                        }else{
                            modelAndView.addObject("Errormsg","Gold Badges Are Not Available");
                            flag=false;
                        }
                    }
                }
            }
            if(userRecognize.getBadgeType().equals("Silver")){
                List<UserBadges> badgesList = findBadgesId(loggedInUser.getId());
                for(UserBadges userBadges : badgesList){
                    String badgeType = userBadges.getType();
                    if(badgeType.equals("Silver")){
                        int badgeCount = userBadges.getCount();
                        int badgeID = userBadges.getId();
                        if(badgeCount > 0){
                            updateBadgesCount(badgeType,badgeCount-1,badgeID);
                            userExist.setSilverBadgesReceived(userExist.getSilverBadgesReceived()+1);
                        }else{
                            modelAndView.addObject("Errormsg","Gold Badges Are Not Available");
                            flag=false;
                        }
                    }
                }
            }
            if(userRecognize.getBadgeType().equals("Bronze")){
                List<UserBadges> badgesList = findBadgesId(loggedInUser.getId());
                for(UserBadges userBadges : badgesList){
                    String badgeType = userBadges.getType();
                    if(badgeType.equals("Bronze")){
                        int badgeCount = userBadges.getCount();
                        int badgeID = userBadges.getId();
                        if(badgeCount > 0){
                            updateBadgesCount(badgeType,badgeCount-1,badgeID);
                            userExist.setBronzeBadgesReceived(userExist.getBronzeBadgesReceived()+1);
                        }else{
                            modelAndView.addObject("Errormsg","Gold Badges Are Not Available");
                            flag=false;
                        }
                    }
                }
            }
            String newersName = userExist.getUserCompleteName();
            userRecognize.setNewersName(newersName);
            userRecognize.setAppreciatedByUserName(loggedInUser.getFirstname()+" "+loggedInUser.getLastname());
            userRecognize.setAppreciatedByUserId(loggedInUser.getId());
            userRecognize.setTimeStamp(new Date());
            List<UserRecognize> userRecognizeList = new ArrayList<>();
            userRecognizeList.add(userRecognize);
            userExist.setRecognizeList(userRecognizeList);

            if(flag){
                userRepository.save(userExist);
            }
        }
        return flag;
    }

    @Transactional
    public void updateBadgesCount(String badgeType, int badgeCount, int badgeID) {
        userRepository.updateBadgesCount(badgeType,badgeCount,badgeID);
    }

    public List<UserRecognize> findUserRecognizeForSharedBadges(int id){
        return userRepository.findAllById(id);
    }

    public List<UserRecognize> findUserRecognizeforReceivedBadges(String email) {
        return userRepository.findAllByEmail(email);
    }

    public List<UserRecognize> findUserRecognizeforAllBadges(String email, int id) {
        return userRepository.findAllByEmailAndId(email,id);
    }

    public List<UserRecognize> findRecognizeList(){
        return userRepository.findRecognizeList();
    }

    public List<UserBadges> findBadgesId(int id){
        return userRepository.findBadgesId(id);
    }

    public Role findRolesId(int id){
        return userRepository.findRolesId(id);
    }

    @Transactional
    public void delete(User user)
    {
        userRepository.delete(user);
    }
}
