package org.eclipse.jakarta.hello.dao;

import jakarta.persistence.*;
import org.eclipse.jakarta.hello.entity.Product;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class ProductDaoImpl implements ProductDao {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction entityTransaction;

    public ProductDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager =  entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }


    @Override
    public List<Product> getProducts() {
        try {
            entityTransaction.begin();
            List<Product>products = new ArrayList<>();
            System.out.println("here1");
            products=entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            System.out.println("here2");
            entityTransaction.commit();
            return products;
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it further
        }
    }

    @Override
    public void addProduct(String name, double price) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it further
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                entityManager.remove(product);
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it further
        }
    }

    @Override
    public void updateProduct(int id, String name, double price) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                product.setName(name);
                product.setPrice(price);
                entityManager.merge(product);
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it further
        }
    }
    public Product findById(int id){
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
               return product;
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it further
        }
        return null;
    }
}
