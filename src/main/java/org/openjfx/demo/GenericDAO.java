package org.openjfx.demo;

import entity.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GenericDAO<T> {
    private final SessionFactory sessionFactory;



    public GenericDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.save(entity);
            t.commit();
        }
    }

    public T retrieve(Class<T> clazz, int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(clazz, id);
        }
    }

    public Users retrieveUserByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
            Root<Users> root = criteriaQuery.from(Users.class);

            criteriaQuery.select(root).where(builder.equal(root.get("username"), username));

            return session.createQuery(criteriaQuery).uniqueResult();
        }
    }

    public List<Rating> retrieveAllRatings() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public List<Rating> retrieveAllRatingsByUserId(int userId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("userId"), userId));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public Users retrieveUserById(int userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Users.class, userId);
        }
    }
    public List<Rating> RetrieveAllRatings(){
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }


    public List<Recipes> retrieveAllRecipes() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipes> criteriaQuery = builder.createQuery(Recipes.class);
            Root<Recipes> root = criteriaQuery.from(Recipes.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public List<Recipes> retrieveRecipesBasedOnName(String name) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipes> criteriaQuery = builder.createQuery(Recipes.class);
            Root<Recipes> root = criteriaQuery.from(Recipes.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeName"), name));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public List<Users> retrieveAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
            Root<Users> root = criteriaQuery.from(Users.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public List<LoggedUser> retrieveAllLoggedUsers() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<LoggedUser> criteriaQuery = builder.createQuery(LoggedUser.class);
            Root<LoggedUser> root = criteriaQuery.from(LoggedUser.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }


    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.update(entity);
            t.commit();
        }
    }

    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.delete(entity);
            t.commit();
        }
    }
    public List<Rating> retrieveRatingsBasedOnRating(T i) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("rating"), i));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public Recipes retrieveRecipeBasedOnId(T productId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipes> criteriaQuery = builder.createQuery(Recipes.class);
            Root<Recipes> root = criteriaQuery.from(Recipes.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), productId));

            return session.createQuery(criteriaQuery).uniqueResult();
        }
    }

    public List<Rating> RetrieveRatingsBasedOnRating(T i) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("rating"), i));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public Recipes retrieveRecipeById(T recipeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Recipes.class, (int) recipeId);
        }
    }

    public List<Rating> RetrieveRatingsBasedOnRecipe(T text) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), text));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public List<Rating> RetrieveRatingBasedOnRecipeName(T text){
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), text));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public List<Rating> RetrieveRatingsBasedOnId(T recipeId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), recipeId));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public Recipes retrieveRecipeIdBasedOnName(T name) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipes> criteriaQuery = builder.createQuery(Recipes.class);
            Root<Recipes> root = criteriaQuery.from(Recipes.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeName"), name));

            return session.createQuery(criteriaQuery).uniqueResult();
        }
    }
    public Rating retrieveRecipeBasedOnName(T text) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), text));

            return session.createQuery(criteriaQuery).uniqueResult();
        }
    }

    public List<Rating> RetrieveRatingsBasedOnRecipeId(T recipeId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), recipeId));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
