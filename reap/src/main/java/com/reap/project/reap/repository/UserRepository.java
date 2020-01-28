package com.reap.project.reap.repository;

import com.reap.project.reap.model.Role;
import com.reap.project.reap.model.User;
import com.reap.project.reap.model.UserBadges;
import com.reap.project.reap.model.UserRecognize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     User findUserByEmail(String email);

     List<User> findAll();

     User findById(int id);

     @Query("select r from UserRecognize r where appreciated_by_user_id = :id")
     List<UserRecognize> findAllById(@Param("id") int id);

     @Query("select r from UserRecognize r where newers_email = :email")
     List<UserRecognize> findAllByEmail(@Param("email") String email);

     @Query("select r from UserRecognize r where newers_email = :email or appreciated_by_user_id = :id")
     List<UserRecognize> findAllByEmailAndId(@Param("email") String email, @Param("id") int id);

     @Query("select r from UserRecognize r order by r.timeStamp desc")
     List<UserRecognize> findRecognizeList();

     @Query("select u.badges from User u where u.id = :id")
     List<UserBadges> findBadgesId(@Param("id") int id);

     @Modifying
     @Transactional
     @Query("update UserBadges b set b.badgeCount = :badgeCount where b.badgeType = :badgeType and b.id = :badgeID")
     void updateBadgesCount(@Param("badgeType") String badgeType, @Param("badgeCount") int badgeCount,@Param("badgeID") int badgeID);

     @Query("select u.roles from User u where u.id = :id")
     Role findRolesId(@Param("id") int id);

     @Modifying
     @Transactional
     @Query("update Role r set r.role = :role where r.id = :id")
     void updateRole(@Param("id") int id,@Param("role") String roleToUpdate);

     @Modifying
     @Transactional
     @Query("update User u set u.active = :active where u.id = :id")
     void updateUserActive(@Param("active") int active,@Param("id") int id);
}
