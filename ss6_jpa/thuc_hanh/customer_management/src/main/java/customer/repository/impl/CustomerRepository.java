package customer.repository.impl;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:38
*/

import customer.model.Customer;
import customer.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String FIND_ALL = "select c from customers c";

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = entityManager.createQuery(FIND_ALL, Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Integer id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
