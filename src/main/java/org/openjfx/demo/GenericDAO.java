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

    public List<Rating> retrieveAllRatingsByRecipeId(int recipeId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Rating> criteriaQuery = builder.createQuery(Rating.class);
            Root<Rating> root = criteriaQuery.from(Rating.class);

            criteriaQuery.select(root).where(builder.equal(root.get("recipeId"), recipeId));

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

    public List<SavedRecipes> retrieveAllSavedRecipes() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<SavedRecipes> criteriaQuery = builder.createQuery(SavedRecipes.class);
            Root<SavedRecipes> root = criteriaQuery.from(SavedRecipes.class);

            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    public List<Recipes> retrieveRecipesBasedOnCheckBoxes(boolean eggs, boolean milk, boolean cheese, boolean sausage, boolean cucumber, boolean tomato, boolean cream, boolean sugar, boolean water, boolean flour, boolean saliami, boolean macaroni, boolean tomatosauce, boolean spaghetti, boolean calendar, boolean cabbage) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipes> criteriaQuery = builder.createQuery(Recipes.class);
            Root<Recipes> root = criteriaQuery.from(Recipes.class);

            criteriaQuery.select(root).where(builder.and(
                    builder.equal(root.get("eggs"), eggs),
                    builder.equal(root.get("milk"), milk),
                    builder.equal(root.get("cheese"), cheese),
                    builder.equal(root.get("sausage"), sausage),
                    builder.equal(root.get("cucumber"), cucumber),
                    builder.equal(root.get("tomato"), tomato),
                    builder.equal(root.get("cream"), cream),
                    builder.equal(root.get("sugar"), sugar),
                    builder.equal(root.get("water"), water),
                    builder.equal(root.get("flour"), flour),
                    builder.equal(root.get("saliami"), saliami),
                    builder.equal(root.get("macaroni"), macaroni),
                    builder.equal(root.get("tomatosauce"), tomatosauce),
                    builder.equal(root.get("spaghetti"), spaghetti),
                    builder.equal(root.get("calendar"), calendar),
                    builder.equal(root.get("cabbage"), cabbage)
            ));

            return session.createQuery(criteriaQuery).getResultList();
        }

    }
    public List<SavedRecipes> retrieveRecipesBasedOnUserId(int userId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<SavedRecipes> criteriaQuery = builder.createQuery(SavedRecipes.class);
            Root<SavedRecipes> root = criteriaQuery.from(SavedRecipes.class);

            criteriaQuery.select(root).where(builder.equal(root.get("userId"), userId));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
