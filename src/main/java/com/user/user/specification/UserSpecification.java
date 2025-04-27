package com.user.user.specification;

import com.user.user.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
                firstName == null ? null : criteriaBuilder.equal(root.get("firstName"), firstName);
    }

    public static Specification<User> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) ->
                lastName == null ? null : criteriaBuilder.equal(root.get("lastName"), lastName);
    }

    public static Specification<User> hasMiddleName(String middleName) {
        return (root, query, criteriaBuilder) ->
                middleName == null ? null : criteriaBuilder.equal(root.get("middleName"), middleName);
    }

    public static Specification<User> hasPersonalMail(String personalMail) {
        return (root, query, criteriaBuilder) ->
                personalMail == null ? null : criteriaBuilder.equal(root.get("personalMail"), personalMail);
    }

    public static Specification<User> hasPrimaryMobileNo(String primaryMobileNo) {
        return (root, query, criteriaBuilder) ->
                primaryMobileNo == null ? null : criteriaBuilder.equal(root.get("primaryMobileNo"), primaryMobileNo);
    }

    public static Specification<User> hasSecondaryMobileNo(String secondaryMobileNo) {
        return (root, query, criteriaBuilder) ->
                secondaryMobileNo == null ? null : criteriaBuilder.equal(root.get("secondaryMobileNo"), secondaryMobileNo);
    }
}
